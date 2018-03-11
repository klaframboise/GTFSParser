package com.kevinlaframboise.gtfsparser.builder;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.TreeMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;

import com.kevinlaframboise.gtfsparser.model.Stop;
import com.kevinlaframboise.gtfsparser.model.StopTime;
import com.kevinlaframboise.gtfsparser.model.Trip;

public class StopTimeParser implements GTFSParser {

	public static final int NUM_OF_REQ_FIELDS = 5;

	/**
	 * File to be parsed, stop_times.txt respecting the GTFS format.
	 */
	private File file;
	
	/**
	 * Stops referenced by the stop_times records
	 */
	private TreeMap<String, Stop> stops;
	
	/**
	 * Trips referenced by the stop_times records
	 */
	private TreeMap<String, Trip> trips;

	/* Stop Attributes */
	private Date arrivalTime;
	private Date departureTime;
	private int sequence;
	private String headsign;
	private int pickupType;
	private int dropOffType;
	private float shapeDistTraveled;
	private int timepoint;

	public StopTimeParser(File file, TreeMap<String, Stop> stops, TreeMap<String, Trip> trips) {
		this.file = file;
		this.stops = stops;
		this.trips = trips;
	}

	@Override
	public void parse() throws IOException {
		// Get file url
		URI fileUri = file.toURI();
		URL fileUrl = fileUri.toURL();

		// Using BOM input stream to deal with byte-order mark charcater
		Reader reader = new InputStreamReader(new BOMInputStream(fileUrl.openStream()), "UTF-8");

		/* Parse the stop time */ 
		CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader());
		StopTime aStopTime;
		String tripId;
		Trip aTrip;
		String stopId;
		Stop aStop;
		for(CSVRecord record : parser) {
			// Discard malformed records
			if(record.size() < NUM_OF_REQ_FIELDS) continue;
			
			/* Required attributes */
			tripId = record.get(Headers.trip_id);
			arrivalTime = new Date(Time.valueOf(record.get(Headers.arrival_time)).getTime());
			departureTime = new Date(Time.valueOf(record.get(Headers.departure_time)).getTime());
			stopId = record.get(Headers.stop_id);
			sequence = Integer.parseInt(record.get(Headers.stop_sequence));
			
			/* Get associated objects */
			aTrip = trips.get(tripId);
			aStop = stops.get(stopId);
			
			// Create stop times object
			aStopTime = new StopTime(arrivalTime, departureTime, sequence, aStop);
			
			/* Optional attributes */
			try {
				headsign = record.get(Headers.stop_headsign);
				aStopTime.setHeadsign(headsign);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				pickupType = Integer.parseInt(record.get(Headers.pickup_type));
				aStopTime.setPickupType(pickupType);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				dropOffType = Integer.parseInt(record.get(Headers.drop_off_type));
				aStopTime.setDropOffType(dropOffType);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				shapeDistTraveled = Float.parseFloat(record.get(Headers.shape_dist_traveled));
				aStopTime.setShapeDistTraveled(shapeDistTraveled);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				timepoint = Integer.parseInt(record.get(Headers.timepoint));
				aStopTime.setTimepoint(timepoint);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			// Add reference to current stop time to corresponding trip
			aTrip.addStopTime(aStopTime);
		}

		parser.close();

	}

	enum Headers {
		trip_id,arrival_time,departure_time,stop_id,stop_sequence,stop_headsign,pickup_type,drop_off_type,shape_dist_traveled,timepoint
	}
}

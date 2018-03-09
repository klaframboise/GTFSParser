package com.kevinlaframboise.gtfsparser.builder;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;

import com.kevinlaframboise.gtfsparser.controller.AgencyController;
import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.Route;
import com.kevinlaframboise.gtfsparser.model.Service;
import com.kevinlaframboise.gtfsparser.model.Trip;

/**
 * Parser for trips.txt. Adds the resulting trip objects to the routes it belongs to.
 * @author Kevin Laframboise
 *
 */
public class TripParser {

	public static final int NUM_OF_REQ_FIELDS = 3;

	/**
	 * File to be parsed, trips.txt respecting the GTFS format.
	 */
	private File file;

	/**
	 * Agency for which this trip is being parsed
	 */
	private Agency agency;

	//Trip Attributes
	private Route route;
	private List<Service> services;
	private String id;
	private String headsign;
	private String shortName;
	private int direction;
	private String block;
	private int wheelchairAccessible;
	private int bikesAllowed;
	
	public TripParser(File file, Agency agency) {
		this.file = file;
		this.agency = agency;
	}

	public TreeMap<String, Trip> parse() throws IOException {
		// Initialize return object
		TreeMap<String, Trip> trips = new TreeMap<String, Trip>();
		// Get file url
		URI fileUri = file.toURI();
		URL fileUrl = fileUri.toURL();

		// Using BOM input stream to deal with byte-order mark charcater
		Reader reader = new InputStreamReader(new BOMInputStream(fileUrl.openStream()), "UTF-8");

		/* Parse the calendar */ 
		CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader());
		AgencyController controller = new AgencyController();
		Trip aTrip;
		String routeId;
		String serviceId;
		for(CSVRecord record : parser) {
			// Discard malformed records
			if(record.size() < NUM_OF_REQ_FIELDS) continue;

			/* Required records */
			routeId = record.get(Headers.route_id);
			serviceId = record.get(Headers.service_id);
			id = record.get(Headers.trip_id);
			
			route = controller.getRouteById(agency, routeId);
			services = controller.getServiceById(agency, serviceId);

			//Create Trip object
			aTrip = new Trip(id);

			/* Optional records */
			try {
				headsign = record.get(Headers.trip_headsign);
				aTrip.setHeadsign(headsign);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				shortName = record.get(Headers.trip_short_name);
				aTrip.setShortName(shortName);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				direction = Integer.parseInt(record.get(Headers.direction_id));
				aTrip.setDirection(direction);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				block = record.get(Headers.block_id);
				aTrip.setBlock(block);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			//TODO implement shape association
			
			try {
				wheelchairAccessible = Integer.parseInt(record.get(Headers.wheelchair_accessible));
				aTrip.setWheelchairAccessible(wheelchairAccessible);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				bikesAllowed = Integer.parseInt(record.get(Headers.bikes_allowed));
				aTrip.setBikesAllowed(bikesAllowed);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}

			//Add trip to route, service and list of trips
			route.addTrip(aTrip);
			for(Service service : services) {
				aTrip.addService(service);
			}
			trips.put(id, aTrip);
		}
		
		parser.close();
		return trips;

	}

	enum Headers {
		route_id,service_id,trip_id,block_id,shape_id,trip_headsign,trip_short_name,direction_id,wheelchair_accessible,bikes_allowed
	}

}

package com.kevinlaframboise.gtfsparser.builder;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.util.TreeMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;

import com.kevinlaframboise.gtfsparser.model.Stop;

public class StopParser {

	public static final int NUM_OF_REQ_FIELDS = 4;

	/**
	 * File to be parsed, trips.txt respecting the GTFS format.
	 */
	private File file;

	/* Stop Attributes */
	private String id;
	private String code;
	private String name;
	private String desc;
	private double lat;
	private double lon;
	private String zoneId;
	private String url;
	private int locationType;
	private String parentStation;
	private String timezone;
	private int wheelchairBoarding;

	public StopParser(File file) {
		this.file = file;
	}

	public TreeMap<String, Stop> parse() throws IOException {
		// Initialize return object
		TreeMap<String, Stop> stops = new TreeMap<String, Stop>(); 
		
		// Get file url
		URI fileUri = file.toURI();
		URL fileUrl = fileUri.toURL();

		// Using BOM input stream to deal with byte-order mark charcater
		Reader reader = new InputStreamReader(new BOMInputStream(fileUrl.openStream()), "UTF-8");

		/* Parse the calendar */ 
		CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader());
		Stop aStop;
		for(CSVRecord record : parser) {
			// Discard malformed records
			if(record.size() < NUM_OF_REQ_FIELDS) continue;

			/* Required records */
			id = record.get(Headers.stop_id);
			name = record.get(Headers.stop_name);
			lat = Double.parseDouble(record.get(Headers.stop_lat));
			lon = Double.parseDouble(record.get(Headers.stop_lon));
			
			// Create stop object
			aStop = new Stop(id, name, lat, lon);
			
			/* Optional record */
			try {
				code = record.get(Headers.stop_code);
				aStop.setCode(code);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				desc = record.get(Headers.stop_desc);
				aStop.setDesc(desc);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				zoneId = record.get(Headers.zone_id);
				aStop.setZoneId(zoneId);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				url = record.get(Headers.stop_url);
				aStop.setUrl(url);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				locationType = Integer.parseInt(record.get(Headers.location_type));
				aStop.setLocationType(locationType);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				parentStation = record.get(Headers.parent_station);
				aStop.setParentStation(parentStation);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				timezone = record.get(Headers.stop_timezone);
				aStop.setTimezone(timezone);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				wheelchairBoarding = Integer.parseInt(record.get(Headers.wheelchair_boarding));
				aStop.setWheelchairBoarding(wheelchairBoarding);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			// Add stop to list of stops
			stops.put(id, aStop);

		}
		parser.close();
		return stops;
	}

	enum Headers {
		stop_id,stop_code,stop_name,stop_desc,stop_lat,stop_lon,zone_id,stop_url,location_type,parent_station,stop_timezone,wheelchair_boarding
	}

}

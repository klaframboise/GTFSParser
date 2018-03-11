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

import com.kevinlaframboise.gtfsparser.controller.AgencyController;
import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.Stop;
import com.kevinlaframboise.gtfsparser.model.Trip;

/**
 * This class parses the agency.txt file of the GTFS model.
 * @author Kevin Laframboise
 *
 */
public class AgencyParser implements GTFSParser {
	
	public static final int NUM_OF_REQ_FIELDS = 3;
	
	/**
	 * File to be parsed, agency.txt respecting the GTFS format.
	 */
	private File file;
	
	/**
	 * Controller handling the model.
	 */
	private AgencyController controller;

	/* Agency Attributes */
	private String id;
	private String name;
	private String url;
	private String timezone;
	private String lang;
	private String phone;
	private String fareUrl;
	private String email;

	public AgencyParser(File file) {
		this.file = file;
		controller = new AgencyController();
	}
	
	@Override
	public void parse() throws IOException {	
		
		// Get file url
		URI fileUri = file.toURI();
		URL fileUrl = fileUri.toURL();
		
		// Using BOM input stream to deal with byte-order mark charcater
		Reader reader = new InputStreamReader(new BOMInputStream(fileUrl.openStream()), "UTF-8");
		
		/* Parse the agency */ 
		CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader());
		Agency anAgency;
		for(CSVRecord record : parser) {
			// Discard malformed records
			if(record.size() < NUM_OF_REQ_FIELDS) continue;
			
			url = record.get(Headers.agency_url);
			name = record.get(Headers.agency_name);
			timezone = record.get(Headers.agency_timezone);
			anAgency = controller.createAgency(name, url, timezone);
			
			try {
				id = record.get(Headers.agency_id);
				anAgency.setId(id);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				lang = record.get(Headers.agency_lang);
				anAgency.setLang(lang);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				phone = record.get(Headers.agency_phone);
				anAgency.setPhone(phone);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				fareUrl = record.get(Headers.agency_fare_url);
				anAgency.setFareUrl(fareUrl);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				email = record.get(Headers.agency_email);
				anAgency.setEmail(email);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			/* Parse agency's association */
			// Calendar
			File cFile = new File(file.getParentFile(), "calendar.txt");
			if(cFile.exists()) new CalendarParser(cFile, anAgency).parse();
			
			// Calendar dates, optional file
			File cDate = new File(file.getParentFile(), "calendar_dates.txt");
			if (cDate.exists()) new CalendarDateParser(cDate, anAgency).parse();
			else if(!cDate.exists() && !cFile.exists()) throw new java.io.FileNotFoundException("Was expecting either of calendar.txt or calendar_dates.txt. Neither was found.");
			
			//Routes
			new RouteParser(new File(file.getParentFile(), "routes.txt"), anAgency).parse();
			
			//Trips
			TreeMap<String, Trip> trips = new TripParser(new File(file.getParentFile(), "trips.txt"), anAgency).parse();
			
			//Stops
			TreeMap<String, Stop> stops = new StopParser(new File(file.getParentFile(),"stops.txt")).parse();
			
			//Stop times
			new StopTimeParser(new File(file.getParentFile(), "stop_times.txt"), stops, trips).parse();
			
		}
		
		parser.close();
	}
	
	/**
	 * Headers of the GTFS agency.txt files.
	 * Apache Commons uses the enum element's identifier as the header name, 
	 * hence why they do not respect Java naming convention.
	 * @author Kevin Laframboise
	 *
	 */
	enum Headers {
		agency_id,agency_name,agency_url,agency_timezone,agency_lang,agency_phone,agency_fare_url,agency_email
	}
	
}

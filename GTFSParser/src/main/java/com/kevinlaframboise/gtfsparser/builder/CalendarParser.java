package com.kevinlaframboise.gtfsparser.builder;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;

import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.Calendar;
import com.kevinlaframboise.gtfsparser.model.Service;

/**
 * Parser for calendar.txt. Adds the resulting calendar object to the agency's list of calendar.
 * @author Kevin Laframboise
 *
 */
public class CalendarParser implements GTFSParser {

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	
	public static final int NUM_OF_REQ_FIELDS = 10;
	
	/**
	 * File to be parsed, calendar.txt respecting the GTFS format.
	 */
	private File file;

	/**
	 * Agency for which this calendar is being parsed
	 */
	private Agency agency;

	/* Calendar Attributes */
	private String id;
	private boolean monday;
	private boolean tuesday;
	private boolean wednesday;
	private boolean thursday;
	private boolean friday;
	private boolean saturday;
	private boolean sunday;
	private Date startDate;
	private Date endDate;

	/**
	 * Construct a parser for the given calendar file that will add the resulting calendar to the given agency.
	 * @param file
	 * @param agency
	 */
	public CalendarParser(File file, Agency agency) {
		this.file = file;
		this.agency = agency;
	}

	@Override
	public void parse() throws IOException {
		// Get file url
		URI fileUri = file.toURI();
		URL fileUrl = fileUri.toURL();

		// Using BOM input stream to deal with byte-order mark charcater
		Reader reader = new InputStreamReader(new BOMInputStream(fileUrl.openStream()), "UTF-8");

		/* Parse the calendar */ 
		CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader());
		Calendar aCalendar;
		Service aService;
		for(CSVRecord record : parser) {
			// Discard malformed records
			if(record.size() < NUM_OF_REQ_FIELDS) continue;
			
			id = record.get(Headers.service_id);
			monday = record.get(Headers.monday).equals("1");
			tuesday = record.get(Headers.tuesday).equals("1");
			wednesday = record.get(Headers.wednesday).equals("1");
			thursday = record.get(Headers.thursday).equals("1");
			friday = record.get(Headers.friday).equals("1");
			saturday = record.get(Headers.saturday).equals("1");
			sunday = record.get(Headers.sunday).equals("1");
			
			/* Parse dates */
			String startDateRecord = record.get(Headers.start_date);
			try {
				startDate = new Date(DATE_FORMAT.parse(startDateRecord).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String endDateRecord = record.get(Headers.end_date);
			try {
				endDate = new Date(DATE_FORMAT.parse(endDateRecord).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Create calendar object
			aCalendar = new Calendar(id, monday, tuesday, wednesday, thursday, friday, saturday, sunday, startDate, endDate);
			
			//Add calendar to agency
			aService = new Service(aCalendar);
			agency.addService(aService);
		}
		parser.close();
	}

	/**
	 * Headers of the GTFS calendar.txt files.
	 * Apache Commons uses the enum element's identifier as the header name, 
	 * hence why they do not respect Java naming convention.
	 * @author Kevin Laframboise
	 *
	 */
	enum Headers {
		service_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday, start_date, end_date
	}

}

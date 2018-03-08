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
import com.kevinlaframboise.gtfsparser.model.CalendarDate;
import com.kevinlaframboise.gtfsparser.model.Service;

/**
 * Parser for calendar_dates.txt. Adds the resulting calendar object to the agency's list of calendar.
 * @author Kevin Laframboise
 *
 */
public class CalendarDateParser implements GTFSParser {

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	
	public static final int NUM_OF_REQ_FIELDS = 3;

	/**
	 * File to be parsed, calendar_dates.txt respecting the GTFS format.
	 */
	private File file;

	/**
	 * Agency for which this calendar is being parsed
	 */
	private Agency agency;
	
	/* CalendarDate attributes */
	private String id;
	private Date date;
	private int exceptionType;

	/**
	 * Construct a parser for the given calendar dates file that will add the resulting calendar to the given agency.
	 * @param file
	 * @param agency
	 */
	public CalendarDateParser(File file, Agency agency) {
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
		CalendarDate aCalendarDate;
		Service aService;
		for(CSVRecord record : parser) {
			// Discard malformed records
			if(record.size() < NUM_OF_REQ_FIELDS) continue;
			
			id = record.get(Headers.service_id);
			exceptionType = Integer.parseInt(record.get(Headers.exception_type));

			/* Parse dates */
			String dateRecord = record.get(Headers.date);
			try {
				date = new Date(DATE_FORMAT.parse(dateRecord).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//Create calendar object
			aCalendarDate = new CalendarDate(id, date, exceptionType);

			//Add calendar to agency
			aService = new Service(aCalendarDate);
			agency.addService(aService);
		}
		parser.close();
	}
	
	/**
	 * Headers of the GTFS calendar_dates.txt files.
	 * Apache Commons uses the enum element's identifier as the header name, 
	 * hence why they do not respect Java naming convention.
	 * @author Kevin Laframboise
	 *
	 */
	enum Headers {
		service_id, date, exception_type
	}
}

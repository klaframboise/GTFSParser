package com.kevinlaframboise.gtfsparser.builder;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;

import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.Route;

/**
 * Parser for routes.txt. Adds the resulting route objects to the agency's list of routes.
 * @author Kevin Laframboise
 *
 */
public class RouteParser implements GTFSParser {

	public static final int NUM_OF_REQ_FIELDS = 4;

	/**
	 * File to be parsed, routes.txt respecting the GTFS format.
	 */
	private File file;

	/**
	 * Agency for which this route is being parsed
	 */
	private Agency agency;

	//Route Attributes
	private String id;
	private String shortName;
	private String longName;
	private String desc;
	private int type;
	private String url;
	private String color;
	private String textColor;
	private String sortOrder;


	/**
	 * Construct a parser for the given routes file that will add the resulting calendar to the given agency
	 * @param file
	 * @param agency
	 */
	public RouteParser(File file, Agency agency) {
		super();
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
		Route aRoute;
		for(CSVRecord record : parser) {
			// Discard malformed records
			if(record.size() < NUM_OF_REQ_FIELDS) continue;

			/* Required records */
			id = record.get(Headers.route_id);
			shortName = record.get(Headers.route_short_name);
			longName = record.get(Headers.route_long_name);
			type = Integer.parseInt(record.get(Headers.route_type));

			//Create Route object
			aRoute = new Route(id, shortName, longName, type);
			aRoute.setAgency(agency);
			
			/* Optional records */
			try {
				desc = record.get(Headers.route_desc);
				aRoute.setDesc(desc);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				url = record.get(Headers.route_url);
				aRoute.setUrl(url);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				color = record.get(Headers.route_color);
				aRoute.setColor(color);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				textColor = record.get(Headers.route_text_color);
				aRoute.setTextColor(textColor);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				sortOrder = record.get(Headers.route_sort_order);
				aRoute.setSortOrder(sortOrder);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}

			//Add calendar to agency
			agency.addRoute(aRoute);

		}
		parser.close();
	}

	enum Headers {
		route_id,agency_id,route_short_name,route_long_name,route_desc,route_type,route_url,route_color,route_text_color,route_sort_order
	}

}

package com.kevinlaframboise.gtfsparser.builder;

import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URL;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;

import com.kevinlaframboise.gtfsparser.controller.AgencyController;
import com.kevinlaframboise.gtfsparser.model.Agency;

public class AgencyParser {
	
	private File file;
	private AgencyController controller;

	//Agency Attributes
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
	
	public void parse() throws IOException {
		URI fileUri = file.toURI();
		URL fileUrl = fileUri.toURL();
		Reader reader = new InputStreamReader(new BOMInputStream(fileUrl.openStream()), "UTF-8");
		final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader());
		Agency anAgency;
		for(CSVRecord record : parser) {
			id = record.get(Header.agency_id);
			name = record.get(Header.agency_name);
			timezone = record.get(Header.agency_timezone);
			anAgency = controller.createAgency(id, name, timezone);
			
			try {
				url = record.get(Header.agency_url);
				anAgency.setUrl(url);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				lang = record.get(Header.agency_lang);
				anAgency.setLang(lang);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				phone = record.get(Header.agency_phone);
				anAgency.setPhone(phone);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				fareUrl = record.get(Header.agency_fare_url);
				anAgency.setFareUrl(fareUrl);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
			
			try {
				email = record.get(Header.agency_email);
				anAgency.setEmail(email);
			} catch (IllegalArgumentException e) {
				// Do nothing, optional attribute
			}
		}
	}
	
	enum Header {
		agency_id,agency_name,agency_url,agency_timezone,agency_lang,agency_phone,agency_fare_url,agency_email
	}
	
}

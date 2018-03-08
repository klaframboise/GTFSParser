package com.kevinlaframboise.gtfsparser.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.kevinlaframboise.gtfsparser.builder.GTFSDirectory;
import com.thoughtworks.xstream.XStream;

public class TestSerialization {
	
	static GTFSModel gtfs;
	/**
	 * Instance of an XStream object.
	 */
	private static XStream xstream = new XStream();
	/**
	 * Filename. data.xml by default
	 */
	private static String filename = "data.xml";

	public static void main(String[] args) {
		
		GTFSDirectory dir = new GTFSDirectory("gtfs");
		System.out.println("Parsing GTFS...");
		long start = System.currentTimeMillis();
		dir.parseGTFS();
		long end = System.currentTimeMillis();
		System.out.println("Parsing completed. Time taken: " + (end-start)/1000.0 + " sec");
		
		
		System.out.println("Serializing GTFS...");
		setFilename(filename);
		setAlias("gtfs_model", GTFSModel.class);
		setAlias("agency", Agency.class);
		setAlias("calendar", Calendar.class);
		setAlias("calendar_date", CalendarDate.class);
		setAlias("fare_attribute", FareAttribute.class);
		setAlias("fare_rule", FareRule.class);
		setAlias("feed_info", FeedInfo.class);
		setAlias("frequency", Frequency.class);
		setAlias("route", Route.class);
		setAlias("service", Service.class);
		setAlias("service_indicator", ServiceIndicator.class);
		setAlias("shape", Shape.class);
		setAlias("stop", Stop.class);
		setAlias("stop_time", StopTime.class);
		setAlias("transfer", Transfer.class);
		setAlias("trip", Trip.class);
		start = System.currentTimeMillis();
		saveToXMLwithXStream(GTFSModel.getInstance());
		end = System.currentTimeMillis();
		System.out.println("Serialization complete. Time taken: " + (end-start)/1000.0 + " sec");


	}

	/**
	 * Saves the given object to an XML file using XStream.
	 * @param obj to be saved
	 * @return true for successful operation, false otherwise.
	 */
	public static boolean saveToXMLwithXStream(Object obj) {
		xstream.setMode(XStream.ID_REFERENCES);
		String xml = xstream.toXML(obj); // save our xml file
		try {
			FileWriter writer = new FileWriter(filename);
			writer.write(xml);
			writer.close();
			return true;
		} catch (IOException e) {
			//e.printStackTrace();
			return false;
		}
	}

	/**
	 * Reads an object from a XML file that was written with XStream.
	 * @return the read object.
	 */
	public static Object loadFromXMLwithXStream() {
		xstream.setMode(XStream.ID_REFERENCES);
		try {
			FileReader fileReader = new FileReader(filename); // load our xml file
			return xstream.fromXML(fileReader);
		} catch (IOException e) {
			//e.printStackTrace();
			return null;
		}
	}

	/**
	 * Sets a xml tag to be used when saving the given class.
	 * @param xmlTagName the name of the xml tag.
	 * @param className the class using the given tab.
	 */
	public static void setAlias(String xmlTagName, Class<?> className) {
		xstream.alias(xmlTagName, className);
	}

	/**
	 * Sets the filename to the given name.
	 * @param fn new filename
	 */
	public static void setFilename(String fn) {
		filename = fn;
	}
	
	

}

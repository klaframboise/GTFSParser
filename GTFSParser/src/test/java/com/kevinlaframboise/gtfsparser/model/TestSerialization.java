package com.kevinlaframboise.gtfsparser.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import com.cedarsoftware.util.io.JsonWriter;
import com.google.gson.Gson;
import com.kevinlaframboise.gtfsparser.builder.GTFSDirectory;
import com.thoughtworks.xstream.XStream;

public class TestSerialization {
	
	static GTFSModel gtfs;

	public static void main(String[] args) {
		
		GTFSDirectory dir = new GTFSDirectory("gtfs");
		
		long start = System.currentTimeMillis();
		dir.parseGTFS();
		long end = System.currentTimeMillis();
		System.out.println("Parse complete. Time taken: " + (end-start)/1000.0 + " sec");
		
		System.out.println("-----GSON-----");
	//	serializeWithGson();
		System.out.println("-----JSON-IO-----");
		serializeWithJsonIo();
		System.out.println("-----XSTREAM-----");
	//	serializeWithXStream();
		
	}
	
	public static void serializeWithGson() {
		long start = System.currentTimeMillis();
		Gson gson = new Gson();
		gtfs = GTFSModel.getInstance();
		String json = gson.toJson(gtfs);
		
		File jsonFile = new File("gtfs_gson.json");
		PrintWriter out = null;
		try {
			out = new PrintWriter(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		out.write(json);
		out.close();
		long end = System.currentTimeMillis();
		System.out.println("Serialization complete with gson. Time taken: " + (end-start)/1000.0 + " sec");
		System.out.println("Resulting file size: " + jsonFile.length() / 1.0e6 + "MB");
	}
	
	public static void serializeWithJsonIo() {
		long start = System.currentTimeMillis();
		gtfs = GTFSModel.getInstance();
		Map<String, Object> args = new HashMap<>();
		args.put(JsonWriter.PRETTY_PRINT, false);
		args.put(JsonWriter.SKIP_NULL_FIELDS, true);
		args.put(JsonWriter.SHORT_META_KEYS, true);
		args.put(JsonWriter.TYPE_NAME_MAP, new TypeMap());
		String json = JsonWriter.objectToJson(gtfs, args);
		
		File jsonFile = new File("gtfs_json-io.json");
		PrintWriter out = null;
		try {
			out = new PrintWriter(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		out.write(json);
		out.close();
		long end = System.currentTimeMillis();
		System.out.println("Serialization complete with json-io. Time taken: " + (end-start)/1000.0 + " sec");
		System.out.println("Resulting file size: " + jsonFile.length() / 1.0e6 + "MB");
	}
	
	public static void serializeWithXStream() {
		long start = System.currentTimeMillis();
		gtfs = GTFSModel.getInstance();
		XStream xstream = new XStream();
		xstream.setMode(XStream.ID_REFERENCES);
		String xml = xstream.toXML(gtfs); // save our xml file
		File jsonFile = new File("gtfs_xstream.xml");
		try {
			FileWriter writer = new FileWriter(jsonFile);
			writer.write(xml);
			writer.close();
		} catch (IOException e) {

		}
		long end = System.currentTimeMillis();
		System.out.println("Serialization complete with xstream. Time taken: " + (end-start)/1000.0 + " sec");
		System.out.println("Resulting file size: " + jsonFile.length() / 1.0e6 + "MB");
	}
	

}

class TypeMap extends HashMap<String, String> {
	
	public TypeMap() {
		
		/* Java types */
		put("java.util.ArrayList" , "al");
		
		/* Model types */
		Reflections refl = new Reflections(new ConfigurationBuilder() 
				  .setUrls(ClasspathHelper.forPackage("com.kevinlaframboise.gtfsparser.model")) 
				  .setScanners(new SubTypesScanner(false)));
		String typeName;
		for(String type : refl.getAllTypes()) {
			// Ignore non-model types
			if(!type.split("\\.")[type.split("\\.").length-2].equals("model")) continue;
			typeName = type.split("\\.")[type.split("\\.").length-1];
			System.out.println("doing type: " + typeName);
			int len;
			for(len = 0; containsValue(typeName.substring(0, len)) && len < typeName.length(); len++);
			put(type, typeName.substring(0, len));
		}
		
	}
	
}
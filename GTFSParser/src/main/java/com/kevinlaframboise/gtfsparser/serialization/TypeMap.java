package com.kevinlaframboise.gtfsparser.serialization;

import java.util.HashMap;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

/**
 * Maps canonical type names to shorten type names in order to compress the resulting
 * json file as much as possible.
 * @author Kevin Laframboise
 *
 */
public class TypeMap extends HashMap<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4993863107718360427L;

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
			int len;
			for(len = 0; containsValue(typeName.substring(0, len)) && len < typeName.length(); len++);
			put(type, typeName.substring(0, len));
		}
		
	}
	
}

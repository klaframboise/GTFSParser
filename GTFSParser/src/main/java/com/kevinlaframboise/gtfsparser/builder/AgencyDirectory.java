package com.kevinlaframboise.gtfsparser.builder;

import java.io.File;
import java.io.IOException;

import com.kevinlaframboise.gtfsparser.listener.ParsingProgressListener;

public class AgencyDirectory extends File {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8375623285340896164L;

	public AgencyDirectory(File parent, String child) {
		super(parent, child);
	}
	
	public void parseAgency() {
		parseAgency(null);
	}
	
	public void parseAgency(ParsingProgressListener listener) {
		try {
			AgencyParser parser = new AgencyParser(new File(this, "agency.txt"));
			if(listener != null) parser.addListener(listener);
			parser.parse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

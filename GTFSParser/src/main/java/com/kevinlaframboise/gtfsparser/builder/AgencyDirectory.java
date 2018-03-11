package com.kevinlaframboise.gtfsparser.builder;

import java.io.File;
import java.io.IOException;

public class AgencyDirectory extends File {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8375623285340896164L;

	public AgencyDirectory(File parent, String child) {
		super(parent, child);
	}
	
	public void parseAgency() {
		try {
			new AgencyParser(new File(this, "agency.txt")).parse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

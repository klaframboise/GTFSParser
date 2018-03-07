package com.kevinlaframboise.gtfsparser.builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AgencyDirectory extends File {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8375623285340896164L;
	private File[] files;

	public AgencyDirectory(File parent, String child) {
		super(parent, child);
		files = listFiles();
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

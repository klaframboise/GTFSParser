package com.kevinlaframboise.gtfsparser.builder;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import com.kevinlaframboise.gtfsparser.listener.ParsingProgressListener;


public class GTFSDirectory extends File {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -235472024766999211L;
	private List<AgencyDirectory> agencyDirectories;

	public GTFSDirectory(String name) {
		super(name);
		makeAgencyDirectories();
	}
	
	public GTFSDirectory(File parent, String child) {
		super(parent, child);
		makeAgencyDirectories();
	}
	
	private void makeAgencyDirectories() {
		agencyDirectories = new ArrayList<AgencyDirectory>();
		
		String[] children = list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if(new File(dir, name).isDirectory()) return true;
				else return false;
			}
			
		});
		
		AgencyDirectory anAgencyDirectory;
		for(String child : children) {
			anAgencyDirectory = new AgencyDirectory(this, child);
			agencyDirectories.add(anAgencyDirectory);
		}
	}
	
	public void parseGTFS() {
		parseGTFS(null);
	}
	
	public void parseGTFS(ParsingProgressListener listener) {
		for(AgencyDirectory dir : agencyDirectories) {
			dir.parseAgency(listener);
		}
	}

}

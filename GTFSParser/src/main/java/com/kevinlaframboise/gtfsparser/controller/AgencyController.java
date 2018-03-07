package com.kevinlaframboise.gtfsparser.controller;

import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.GTFSModel;

public class AgencyController {
	
	private GTFSModel gtfs;
	
	public AgencyController() {
		gtfs = GTFSModel.getInstance();
	}

	/**
	 * Creates and add a new agency to the GTFS model.
	 * @param name of the new agency
	 * @param url of the new agency 
	 * @param timezone of the new agency
	 * @return the newly created agency
	 */
	public Agency createAgency(String name, String url, String timezone) {
		Agency newAgency = new Agency(name, url, timezone);
		gtfs.addAgency(newAgency);
		return newAgency;
	}

}

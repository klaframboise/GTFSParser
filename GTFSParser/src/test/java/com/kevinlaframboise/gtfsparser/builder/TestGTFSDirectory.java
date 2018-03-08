package com.kevinlaframboise.gtfsparser.builder;

import java.util.List;

import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.GTFSModel;
import com.kevinlaframboise.gtfsparser.model.Route;
import com.kevinlaframboise.gtfsparser.model.Service;
import com.kevinlaframboise.gtfsparser.model.Trip;

public class TestGTFSDirectory {

	public static void main(String[] args) {
		
		GTFSDirectory dir = new GTFSDirectory("gtfs");
		
		dir.parseGTFS();
		
		List<Agency> agencies = GTFSModel.getInstance().getAgencies();
		for(Agency agency : agencies) {
			System.out.println(agency);
			
			for(Service service : agency.getServices()) {
				System.out.println("--" + service);
			}
			
			for(Route route : agency.getRoutes()) {
				System.out.println("--" + route);
				for(Trip trip : route.getTrips()) {
					System.out.println("----" + trip);
				}
			}

		}

	}

}

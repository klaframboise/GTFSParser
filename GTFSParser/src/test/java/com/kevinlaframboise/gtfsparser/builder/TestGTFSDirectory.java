package com.kevinlaframboise.gtfsparser.builder;

import java.util.List;

import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.GTFSModel;
import com.kevinlaframboise.gtfsparser.model.Route;
import com.kevinlaframboise.gtfsparser.model.Service;
import com.kevinlaframboise.gtfsparser.model.Stop;
import com.kevinlaframboise.gtfsparser.model.StopTime;
import com.kevinlaframboise.gtfsparser.model.Trip;

public class TestGTFSDirectory {

	public static void main(String[] args) {
		
		GTFSDirectory dir = new GTFSDirectory("gtfs");
		
		long start = System.currentTimeMillis();
		dir.parseGTFS();
		long end = System.currentTimeMillis();
		
		System.out.println("Parse complete. Time taken: " + (end-start)/1000.0 + " sec");
		
//		List<Agency> agencies = GTFSModel.getInstance().getAgencies();
//		for(Agency agency : agencies) {
//			System.out.println(agency);
//			
//			for(Service service : agency.getServices()) {
//				System.out.println("--" + service);
//			}
//			
//			for(Stop stop : agency.getStops()) {
//				System.out.println("--" + stop);
//			}
//			
//			for(Route route : agency.getRoutes()) {
//				System.out.println("--" + route);
//				for(Trip trip : route.getTrips()) {
//					System.out.println("----" + trip);
//					for(StopTime stopTime : trip.getStopTimes()) {
//						System.out.println(stopTime);
//					}
//				}
//			}
//
//		}

	}

}

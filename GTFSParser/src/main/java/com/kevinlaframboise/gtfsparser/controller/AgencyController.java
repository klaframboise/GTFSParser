package com.kevinlaframboise.gtfsparser.controller;

import java.util.ArrayList;
import java.util.List;

import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.GTFSModel;
import com.kevinlaframboise.gtfsparser.model.Route;
import com.kevinlaframboise.gtfsparser.model.Service;
import com.kevinlaframboise.gtfsparser.model.Stop;
import com.kevinlaframboise.gtfsparser.model.Trip;

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
	
	/**
	 * Finds a route belonging to the given agency with the given id.
	 * Works on the principle that two Route objects are considered equal if
	 * the id and agency are equal.
	 * @param agency
	 * @param id
	 * @return if found, the route. Null otherwise.
	 */
	public Route getRouteById(Agency agency, String id) {
		
		List<Route> routes = agency.getRoutes();
		Route comparisonRoute = new Route(id, null, null, 0);
		int index = routes.indexOf(comparisonRoute);
		if(index >= 0) return routes.get(index); 
		else return null;
		
	}
	
	/**
	 * Finds a stop belonging to the given agency with the given id.
	 * Works on the principle that two Stop objects are considered equal if
	 * the id and agency are equal.
	 * @param agency
	 * @param id
	 * @return if found, the stop. Null otherwise.
	 */
//	public Stop getStopById(Agency agency, String id) {
//		
//		List<Stop> stops = agency.getStops();
//		Stop comparisonStop = new Stop(id, null, 0, 0);
//		int index = stops.indexOf(comparisonStop);
//		if(index >= 0) return stops.get(index); 
//		else return null;
//		
//	}
	
	/**
	 * Finds a trip belonging to the given route with the given id.
	 * Works on the principle that two Trip objects are considered equal if
	 * the id and route are equal.
	 * @param route
	 * @param id
	 * @return if found, the trip. Null otherwise.
	 */
	public Trip getTripById(Route route, String id) {
		
		List<Trip> trips = route.getTrips();
		Trip comparisonTrip = new Trip(id);
		int index = trips.indexOf(comparisonTrip);
		if(index >= 0) return trips.get(index); 
		else return null;
		
	}
	
	/**
	 * Finds a trip belonging to the given agency with the given id.
	 * Works on the principle that two Trip objects are considered equal if
	 * the ids are equal.
	 * @param agency
	 * @param id
	 * @return if found, the trip. Null otherwise.
	 */
	public Trip getTripByIdInAgency(Agency agency, String id) {
		
		Trip trip = null;
		for(Route route : agency.getRoutes()) {
			trip = getTripById(route, id);
			if(trip != null) return trip;
		}
		return trip;
	}
	
	/**
	 * Finds the services belonging to the given agency with the given id.
	 * Works on the principle that two Service objects are considered equal if
	 * the service indicators share the same id.
	 * @param agency
	 * @param id
	 * @return a List containing the corresponding services
	 */
	public List<Service> getServiceById(Agency agency, String id) {
		
		List<Service> services = agency.getServices();
		List<Service> result = new ArrayList<Service>();
		
		for(Service service : services) {
			if(service.getServiceIndicator().getId().equals(id)) {
				result.add(service);
			}
		}
		
		return result;
		
	}

}

package com.kevinlaframboise.gtfsparser.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.GTFSModel;
import com.kevinlaframboise.gtfsparser.model.Route;
import com.kevinlaframboise.gtfsparser.model.Service;
import com.kevinlaframboise.gtfsparser.model.ServiceIndicator;
import com.kevinlaframboise.gtfsparser.model.Trip;

public class TestAgencyController {
	
	GTFSModel gtfs;
	AgencyController controller;
	Agency agency;
	Route route;

	@Before
	public void setUp() throws Exception {
		gtfs = GTFSModel.getInstance();
		controller = new AgencyController();
		agency = new Agency("name", "url", "timezone");
		route = new Route("id", "short", "long", 0);
	}

	@Test
	public void testCreateAgency() {
		String name = "name";
		String url = "url";
		String timezone = "timezone";
		controller.createAgency(name, url, timezone);
		
		assertTrue(gtfs.hasAgencies());
		Agency agency = gtfs.getAgency(0);
		assertEquals(name, agency.getName());
		assertEquals(url, agency.getUrl());
		assertEquals(timezone, agency.getTimezone());
	}
	
	@Test
	public void testGetRouteById() {
		String testId = "test route";
		Route testRoute = new Route(testId, "short name", "long name", 0);
		testRoute.setAgency(agency);
		agency.addRoute(testRoute);
		Route foundRoute = controller.getRouteById(agency, testId);
		assertSame(testRoute, foundRoute);
	}
	
	@Test
	public void testGetRouteByIdRouteNotFound() {
		String testId = "test route";
		Route testRoute = new Route(testId, "short name", "long name", 0);
		testRoute.setAgency(agency);
		agency.addRoute(testRoute);
		Route foundRoute = controller.getRouteById(agency, "another id");
		assertNull(foundRoute);
	}
	
	@Test
	public void testGetServiceById() {
		String testId = "test service";
		Service testService = new Service(new ServiceIndicator(testId));
		agency.addService(testService);
		List<Service> foundServices = controller.getServiceById(agency, testId);
		assertTrue(foundServices.contains(testService));
	}
	
	@Test
	public void testGetServiceByIdServiceNotFound() {
		String testId = "test service";
		Service testService = new Service(new ServiceIndicator(testId));
		agency.addService(testService);
		List<Service> foundServices = controller.getServiceById(agency, "another id");
		assertTrue(foundServices.isEmpty());
	}
	
	@Test
	public void testGetTripById() {
		String testId = "test trip";
		Trip testTrip = new Trip(route, testId);
		route.addTrip(testTrip);
		Trip foundTrip = controller.getTripById(route, testId);
		assertSame(testTrip, foundTrip);
	}
	
	@Test
	public void testGetTripByIdTripNotFound() {
		String testId = "test trip";
		Trip testTrip = new Trip(route, testId);
		route.addTrip(testTrip);
		Trip foundTrip = controller.getTripById(route, "another id");
		assertNull(foundTrip);
	}

}

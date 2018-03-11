package com.kevinlaframboise.gtfsparser.listener;

import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.Route;
import com.kevinlaframboise.gtfsparser.model.Stop;
import com.kevinlaframboise.gtfsparser.model.StopTime;
import com.kevinlaframboise.gtfsparser.model.Trip;

public interface ParsingProgressListener {
	
	public void onAgencyCreate(Agency agency);
	public void onRouteCreate(Route route);
	public void onTripCreate(Trip trip);
	public void onStopCreate(Stop stop);
	public void onStopTimeCreate(StopTime stopTime);

}

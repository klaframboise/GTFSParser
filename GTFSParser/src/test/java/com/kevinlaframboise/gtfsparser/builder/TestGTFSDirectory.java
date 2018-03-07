package com.kevinlaframboise.gtfsparser.builder;

import java.util.List;

import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.GTFSModel;

public class TestGTFSDirectory {

	public static void main(String[] args) {
		
		GTFSDirectory dir = new GTFSDirectory("gtfs");
		
		dir.parseGTFS();
		
		List<Agency> agencies = GTFSModel.getInstance().getAgencies();
		for(Agency agency : agencies) {
			System.out.println(agency);
		}

	}

}

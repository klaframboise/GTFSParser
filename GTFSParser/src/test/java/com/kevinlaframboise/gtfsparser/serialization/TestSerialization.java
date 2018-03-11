package com.kevinlaframboise.gtfsparser.serialization;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.kevinlaframboise.gtfsparser.builder.GTFSDirectory;
import com.kevinlaframboise.gtfsparser.model.GTFSModel;

public class TestSerialization {
	
	GTFSModel gtfs;

	@Before
	public void setUp() throws Exception {
		
		System.out.println("Parsing GTFS...");
		GTFSDirectory dir = new GTFSDirectory("gtfs");
		dir.parseGTFS();
		gtfs = GTFSModel.getInstance();
		
	}

	@Test
	public void test() {
		File json = new File("gtfs.json.gzip");
		int numberOfAgencies = gtfs.numberOfAgencies();
		int numberOfRoutesAgency1 = gtfs.getAgency(0).numberOfRoutes();
		
		System.out.println("Serializing...");
		GTFSPersistence.serializeWithJsonIoAndGZip(json);
		gtfs.delete();
		System.out.println("Deserializing...");
		GTFSPersistence.deserializeJsonIoAndGzip(json);
		
		assertEquals(numberOfAgencies, gtfs.numberOfAgencies());
		assertEquals(numberOfRoutesAgency1, gtfs.getAgency(0).numberOfRoutes());
		
	}

}

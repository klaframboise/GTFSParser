package com.kevinlaframboise.gtfsparser.builder;

import java.io.IOException;

/**
 * Interface implemented by every entity parser.
 * @author Kevin Laframboise
 *
 */
public interface GTFSParser {

	/**
	 * Method that parses a GTFS entity from a csv file.
	 * @throws IOException
	 */
	public void parse() throws IOException;
	
}

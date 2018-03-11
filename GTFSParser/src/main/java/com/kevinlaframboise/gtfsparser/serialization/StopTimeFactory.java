package com.kevinlaframboise.gtfsparser.serialization;

import com.cedarsoftware.util.io.JsonReader.ClassFactory;
import com.kevinlaframboise.gtfsparser.model.Stop;
import com.kevinlaframboise.gtfsparser.model.StopTime;

/**
 * Factory for StopTime objects used during deserialization.
 * (StopTime cannot be instantiated with a null Stop)
 * @author Kevin Laframboise
 *
 */
public class StopTimeFactory implements ClassFactory {

	@Override
	public Object newInstance(Class c) {
		return new StopTime(null, null, 0, new Stop(null, null, 0, 0));
	}

}

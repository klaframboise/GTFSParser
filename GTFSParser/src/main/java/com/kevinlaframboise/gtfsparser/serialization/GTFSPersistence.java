package com.kevinlaframboise.gtfsparser.serialization;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;
import com.kevinlaframboise.gtfsparser.model.Agency;
import com.kevinlaframboise.gtfsparser.model.FeedInfo;
import com.kevinlaframboise.gtfsparser.model.GTFSModel;
import com.kevinlaframboise.gtfsparser.model.StopTime;
import com.kevinlaframboise.gtfsparser.model.Transfer;

/**
 * This class saves and loads a gtfs model encoded in json from disk.
 * @author Kevin Laframboise
 *
 */
public class GTFSPersistence {
	
	static GTFSModel gtfs;

	/**
	 * Serializes the current instance of the GTFSModel to json.
	 * The json file is then gzipped as the resulting file can be very large.
	 * @param gzipFile
	 */
	public static void serializeWithJsonIoAndGZip(File gzipFile) {

		gtfs = GTFSModel.getInstance();
		Map<String, Object> args = new HashMap<>();
		args.put(JsonWriter.PRETTY_PRINT, false);
		args.put(JsonWriter.SKIP_NULL_FIELDS, true);
		args.put(JsonWriter.SHORT_META_KEYS, true);
		args.put(JsonWriter.TYPE_NAME_MAP, new TypeMap());
		
		try {
			GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(gzipFile));
			JsonWriter jsonWriter = new JsonWriter(out, args);
			jsonWriter.write(gtfs);
			jsonWriter.close();
			out.flush();
			out.finish();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}

	}
	
	/**
	 * Deserializes the gzipped json representation of the gtfs model.
	 * @param gzipFile
	 */
	public static void deserializeJsonIoAndGzip(File gzipFile) {

		Map<String, Object> args = new HashMap<>();
		args.put(JsonWriter.TYPE_NAME_MAP, new TypeMap());
		StopTimeFactory stopTimeFac = new StopTimeFactory();
		JsonReader.assignInstantiator(StopTime.class, stopTimeFac);
		GTFSModel newGtfs = null;
		
		try {
			GZIPInputStream in = new GZIPInputStream(new BufferedInputStream(new FileInputStream(gzipFile), 2048));
			newGtfs = (GTFSModel)JsonReader.jsonToJava(in, args);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		putDataInModel(newGtfs);
	}
	
	/**
	 * Overwrites the fields of the GTFSModel currently in memory with those of the GTFSModel
	 * passed as argument.
	 * @param newGtfs
	 */
	private static void putDataInModel(GTFSModel newGtfs) {
		/* Clear old model */
		gtfs = GTFSModel.getInstance();
		gtfs.delete();
		
		/* Build new model */
		for(Agency agency : newGtfs.getAgencies()) {
			gtfs.addAgency(agency);
		}
		
		for(FeedInfo feedInfo : newGtfs.getFeedInfos()) {
			gtfs.addFeedInfo(feedInfo);
		}
		
		for(Transfer transfer : newGtfs.getTransfers()) {
			gtfs.addTransfer(transfer);
		}
	}

}

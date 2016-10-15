package com.wizzair.DBDAOs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AirportNameDAO {

	private static Map<String, String> airportNameAndIataCodes = new ConcurrentHashMap<String, String>();

	static {
		
		airportNameAndIataCodes.put("Baku", "GYD");
		airportNameAndIataCodes.put("Larnaca", "LCA");
		airportNameAndIataCodes.put("Kutaisi", "KUT");
		airportNameAndIataCodes.put("Tel Aviv", "TLV");
		airportNameAndIataCodes.put("Dubai", "DWC");
		airportNameAndIataCodes.put("Brussels Charleroi", "CRL");
		airportNameAndIataCodes.put("Tuzla", "TZL");
		airportNameAndIataCodes.put("Bourgas", "BOJ");
		airportNameAndIataCodes.put("Sofia", "SOF");
		airportNameAndIataCodes.put("Varna", "VAR");
		airportNameAndIataCodes.put("Split", "SPU");
		airportNameAndIataCodes.put("Brno", "BRQ");
		airportNameAndIataCodes.put("Prague", "PRG");
		airportNameAndIataCodes.put("Copenhagen", "CPH");
		airportNameAndIataCodes.put("Billund", "BLL");
		airportNameAndIataCodes.put("Turku", "TKU");
		airportNameAndIataCodes.put("Paris Beauvais", "BVA");
		airportNameAndIataCodes.put("Grenoble", "GNB");
		airportNameAndIataCodes.put("Nice", "NCE");
		airportNameAndIataCodes.put("Berlin Schoenefeld", "SXF");
		airportNameAndIataCodes.put("Cologne", "CGN");
		airportNameAndIataCodes.put("Dortmund", "DTM");
		airportNameAndIataCodes.put("Friedrichshafen", "FDH");
		airportNameAndIataCodes.put("Frankfurt Hahn", "HHN");
		airportNameAndIataCodes.put("Hamburg", "HAM");
		airportNameAndIataCodes.put("Karlsruhe/Baden-Baden", "FKB");
		airportNameAndIataCodes.put("Memmingen", "FMM");
		airportNameAndIataCodes.put("Nuremberg", "NUE");
		airportNameAndIataCodes.put("Thessaloniki", "SKG");
		airportNameAndIataCodes.put("Budapest", "BUD");
		airportNameAndIataCodes.put("Debrecen", "DEB");
		airportNameAndIataCodes.put("Reykjavik", "KEF");
		airportNameAndIataCodes.put("Alghero (Sardinia)", "AHO");
		airportNameAndIataCodes.put("Bari", "BRI");
		airportNameAndIataCodes.put("Milan Bergamo", "BGY");
		airportNameAndIataCodes.put("Bologna", "BLQ");
		airportNameAndIataCodes.put("Catania", "CTA");
		airportNameAndIataCodes.put("Milan Malpensa", "MXP");
		airportNameAndIataCodes.put("Naples", "NAP");
		airportNameAndIataCodes.put("Perugia", "PEG");
		airportNameAndIataCodes.put("Pisa", "PSA");
		airportNameAndIataCodes.put("Rome Ciampino", "CIA");
		airportNameAndIataCodes.put("Rome Fiumicino", "FCO");
		
		//twice as many left for addition
	
	}
	
	public static List<String> getSuggestionsByPrefix(String prefix) {
		List<String> result = new ArrayList<String>();
		
		if ((prefix == null )||(prefix.trim().length() == 0)) {
			return result;
		}
		
		for (String name : airportNameAndIataCodes.keySet()) {
			if (name.startsWith(prefix)) {
				result.add(name);
			}
		}
 		
 		return result;
	}	
}
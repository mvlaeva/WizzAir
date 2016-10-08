package com.wizzair.APIConnection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonObject;
import com.wizzair.model.Flight;
import com.wizzair.model.FlightSearch;

public class APIQueryDAO {

	public static List<Flight> getFlights(FlightSearch search) throws IOException {

		String request = "http://partners.api.skyscanner.net/apiservices/pricing/v1.0/";
		URL url = new URL(request);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		// conn.setInstanceFollowRedirects(false);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("charset", "utf-8");

		String apiKey = "zd245468154105197435988199897794";

		String urlParameters = "apiKey=zd245468154105197435988199897794&country=BR&currency=BRL&locale=pt-BR&originplace=SDU&destinationplace=GRU&outbounddate=2016-10-18&locationschema=Iata&adults=1";

		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;

		conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));

		conn.setUseCaches(false);

		JsonObject object = null;

		try {
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.write(postData);
			wr.flush();
			wr.close();

			int responseCode = conn.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
			System.out.println("Header Fields : " + conn.getHeaderFields());

		} catch (Exception e) {
			System.out.println(e);
		}

		Map<String, String> map = new HashMap<String, String>();

		for (String header : conn.getHeaderFields().keySet()) {
			if (header != null) {
				for (String value : conn.getHeaderFields().get(header)) {
					// System.out.println(header + ":" + value);
					map.put(header, value);
				}
			}
		}

		System.out.println();
		for (Entry<String, String> op : map.entrySet()) {
			System.out.println(op.getKey() + ":" + op.getValue());
		}

		String sessionKey = map.get("Location");
		String request2 = sessionKey + "?apiKey=" + apiKey;

		URL url2 = new URL(request2);
		HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();

		conn2.setRequestProperty("Accept", "application/json");

		BufferedReader in = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		/*
		 * File file = new File("json.txt"); OutputStream os = null; try { os =
		 * new BufferedOutputStream( new FileOutputStream(file) ); os.write(new
		 * String(response.toString()).getBytes("UTF-8")); } finally{
		 * 
		 * }
		 */
		System.out.println(response.toString());
		return null;
	}
}

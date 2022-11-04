package com.taskOnNov3;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.*;

public class JSONtoString {

	public static void main(String[] args) {
		JSONtoString object = new JSONtoString();
		object.getJSONtoString();
	}

	private void getJSONtoString() {
		try {
			URL url = new URL("https://reqres.in/api/unknown");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package com.taskOnNov3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Data;
import model.Details;
import model.Support;
import swing.Swing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.HttpURLConnection;
import java.io.*;

public class JSONtoString {
	private List<Details> details;
	private Support support;
	private Details detail;
	private Swing swing;

	public JSONtoString() {
		support = new Support();
	}

	public static void main(String[] args) {
		JSONtoString object = new JSONtoString();
		object.getJSONtoString();
	}

	private void getJSONtoString() {
		try {
			URL url = new URL("https://reqres.in/api/unknown");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String jsonResponse;
			StringBuilder sb = new StringBuilder();
			while ((jsonResponse = reader.readLine()) != null) {
				sb.append(jsonResponse);
			}
			System.out.println(sb.toString());
			detail = JSONtoPojo(sb.toString());
			swing = new Swing(detail);
			swing.addInJList(swing);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Details JSONtoPojo(String jsonData) throws JsonMappingException, JsonProcessingException, ParseException {
		ObjectMapper mapper = new ObjectMapper();
		Details detail = mapper.readValue(jsonData, Details.class);
		return detail;
	}

}

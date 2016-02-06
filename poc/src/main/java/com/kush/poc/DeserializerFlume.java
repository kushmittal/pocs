package com.kush.poc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.event.JSONEvent;
import org.apache.flume.serialization.EventDeserializer;
import org.apache.flume.serialization.ResettableInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.collect.Maps;

public class DeserializerFlume implements EventDeserializer {

	private Context context;
	private ResettableInputStream in;

	public DeserializerFlume(Context context, ResettableInputStream in) {
		super();
		this.context = context;
		this.in = in;
	}

	public Event readEvent() throws IOException {
		System.out.println("Read event");
		return new JSONEvent();
	}

	public List<Event> readEvents(int numEvents) throws IOException {
		System.out.println("Read events" + numEvents);
		List<Event> events = new ArrayList<Event>();
		FlumeInputStream flumeInputStream = new FlumeInputStream(in);
		InputStreamReader isr = new InputStreamReader(flumeInputStream);
		BufferedReader br = new BufferedReader(isr);
		JSONObject jsonObject = null;
		JSONArray jsonArrayRecord = null;
		try {
			String line = br.readLine();
			if (br != null && line != null) {
				//line = "{" + line;
				System.out.println(line);
				jsonObject = new JSONObject(line);
				if (jsonObject.has("Records")) {
					jsonArrayRecord = (JSONArray) jsonObject.get("Records");
					for (int i = 0; i < jsonArrayRecord.length(); i++) {
						String jsonString = jsonArrayRecord.getJSONObject(i)
								.toString();
						if (jsonString.contains("AddTags")
								|| jsonString.contains("RemoveTags")
								|| jsonString
										.contains("RemoveTagsFromResource")
								|| jsonString.contains("AddTagsToResource")
								|| jsonString.contains("DeleteDBInstance")
								|| jsonString.contains("CreateDBInstance")
								|| jsonString.contains("DeleteVolume")
								|| jsonString.contains("DeleteLoadBalancer")
								|| jsonString.contains("CreateVolume")
								|| jsonString.contains("CreateLoadBalancer")
								|| jsonString.contains("TerminateInstances")
								|| jsonString.contains("RunInstances")
								|| jsonString.contains("DeleteTags")
								|| jsonString.contains("CreateTags")) {
							JSONEvent jsonEvent = new JSONEvent();
							Map<String, String> input = Maps.newHashMap();
							input.put(String.valueOf(i), String.valueOf(i));
							jsonEvent.setHeaders(input);
							System.out.println(jsonArrayRecord.getJSONObject(i)
									.toString().getBytes().length);
							jsonEvent.setBody(jsonArrayRecord.getJSONObject(i)
									.toString().getBytes());
							events.add(jsonEvent);
						}
					}
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(events.size() + "length");
		return events;
	}

	public void mark() throws IOException {

	}

	public void reset() throws IOException {

	}

	public void close() throws IOException {

	}

	public static class Builder implements EventDeserializer.Builder {

		public EventDeserializer build(Context context, ResettableInputStream in) {
			System.out.println("Build");
			return new DeserializerFlume(context, in);
		}

	}

}

class FlumeInputStream extends InputStream {

	private final ResettableInputStream in;

	public FlumeInputStream(ResettableInputStream input) {
		this.in = input;
	}

	@Override
	public int read() throws IOException {
		try {
			return this.in.read();
		} catch (Exception e) {
			return 0;
		}
	}

}

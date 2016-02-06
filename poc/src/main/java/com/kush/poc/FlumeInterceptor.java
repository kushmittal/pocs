package com.kush.poc;

import java.util.Iterator;
import java.util.List;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;
import org.codehaus.jackson.map.ObjectMapper;

public class FlumeInterceptor implements Interceptor {

	public void close() {
		System.out.println("close");
		// TODO Auto-generated method stub
		
	}

	public void initialize() {
		System.out.println("initialize");
		// TODO Auto-generated method stub
		
	}

	public Event intercept(Event event) {
		System.out.println("intercept event");
		//System.out.println(event);
		byte[] eventBody = event.getBody();
		  ObjectMapper mapper = new ObjectMapper();
		System.out.println(new String(eventBody));
		// TODO Auto-generated method stub
		return event;
	}

	public List<Event> intercept(List<Event> events) {
		System.out.println("intercept events");
		 for (Iterator<Event> iterator = events.iterator(); iterator.hasNext();)
	     {
	       Event next = intercept(iterator.next());
	     }
		 return events;
	}
	
	public static class Builder implements Interceptor.Builder {

		public void configure(Context arg0) {
			// TODO Auto-generated method stub
			System.out.println("configire builder");
		}

		public Interceptor build() {
			System.out.println("build");
			// TODO Auto-generated method stub
			return new FlumeInterceptor();
			
			
		}

	}

}

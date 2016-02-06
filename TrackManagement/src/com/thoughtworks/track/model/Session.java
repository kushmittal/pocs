package com.thoughtworks.track.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.thoughtworks.track.core.SessionConfig;


public abstract class Session {

	protected int id;
	protected String type;
	protected int startTime;
	protected int endTime;
	protected int totalTime;

	public abstract void scheduleSession(List<Talk> talkList);

	public Session(SessionConfig config) {
		this.id = config.getId();
		this.type = config.getName();
		this.startTime = convertToTime(config.getStartTime());
		this.endTime = convertToTime(config.getEndTime());
		this.totalTime = startTime;

	}

	private int convertToTime(int startTime) {

		Date date = null;
		try {
			date = new SimpleDateFormat("HHmm").parse(String.format("%04d",startTime));
		} catch (ParseException e) {

		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	
	public void print(int previousSessionTIme)
	{
		
	}

}

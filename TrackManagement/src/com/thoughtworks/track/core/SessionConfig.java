package com.thoughtworks.track.core;

/**
 * this class encapsulates the session configuration
 * 
 * @author kushagra.mittal
 *
 */
public class SessionConfig {

	private int id;
	private String name;
	private int startTime;
	private int endTime;

	public SessionConfig(int id, String name, int startTime, int endTime) {

		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}

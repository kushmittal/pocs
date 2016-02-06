package com.thoughtworks.track.model;

import com.thoughtworks.track.core.TrackConstants;


/**
 * this class encapsulates the data of  a talk
 * @author kushagra.mittal
 *
 */
public class Talk implements Comparable<Talk> {
	private String talkTopic;
	private int timeDuration;
	private boolean isIncluded;

	public boolean isIncluded() {
		return isIncluded;
	}

	public void setIncluded(boolean isIncluded) {
		this.isIncluded = isIncluded;
	}

	/**
	 * Constructor for Talk.
	 * @param talkTopic
	 * @param time
	 */
	public Talk(String talkTopic, int timeDuration) {
		this.talkTopic = talkTopic;
		this.timeDuration = timeDuration;
		this.isIncluded = false;
	}

	public Talk(Talk t) {
		this.talkTopic = t.talkTopic;
		this.timeDuration = t.timeDuration;
		this.isIncluded = true;
	}

	/**
	 * To get time duration for the talk.
	 * 
	 * @return
	 */
	public int getTimeDuration() {
		return timeDuration;
	}

	/**
	 * To get the talkTopic of the talk.
	 * 
	 * @return
	 */
	public String getTalkTopic() {
		return talkTopic;
	}

	public void print(String startTime) {
		StringBuffer sb = new StringBuffer();
		sb.append(startTime);
		sb.append(" ");
		sb.append(this.getTalkTopic());
		sb.append(" ");
		sb.append(this.getTimeDuration());
		sb.append(TrackConstants.minuteSuffix);
		System.out.println(sb.toString());
	}

	@Override
	public int compareTo(Talk arg0) {
		if (this.getTimeDuration() > arg0.getTimeDuration())
			return 1;
		if (this.getTimeDuration() < arg0.getTimeDuration())
			return -1;
		return 0;
	}
}
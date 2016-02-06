package com.thoughtworks.track.model;

import java.util.List;

import com.thoughtworks.track.core.SessionConfig;
import com.thoughtworks.track.core.TrackConstants;
import com.thoughtworks.track.utility.TrackUtility;


public class IntervalSession extends Session {

	public IntervalSession(SessionConfig config) {
		super(config);
	}

	@Override
	public void scheduleSession(List<Talk> talkList) {

	}

	public void print(int previousSessionTIme) {
		StringBuffer buff = new StringBuffer();
		if (this.type.equals(TrackConstants.LUNCH_SESSION)) {
			String startTime = TrackUtility.formatTime(this.startTime);
			buff.append(startTime);
			buff.append(" ");
			buff.append(this.type);
			System.out.println(buff);
		} else if (this.type.equals(TrackConstants.NETWORKING_SESSION)) {
			String startTime;
			
			if (previousSessionTIme > this.startTime) {
			    startTime = TrackUtility.formatTime(previousSessionTIme);
			} else {
				startTime = TrackUtility.formatTime(this.startTime);
			}
			buff.append(startTime);
			buff.append(" ");
			buff.append(this.type);
			System.out.println(buff);
		}
	}

}
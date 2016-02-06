package com.thoughtworks.track.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.track.core.SessionConfig;
import com.thoughtworks.track.utility.TrackUtility;

public class TalkSession extends Session {

	private List<Talk> scheduledList;

	public TalkSession(SessionConfig config) {
		super(config);
		scheduledList = new ArrayList<Talk>();
	}

	@Override
	public void scheduleSession(List<Talk> talkList) {

		Iterator<Talk> iterator = talkList.iterator();
		while (iterator.hasNext()) {
			Talk talk = iterator.next();
			if (totalTime > endTime)
				break;
				if ((endTime - totalTime) >= talk.getTimeDuration()) {
					System.out.println("total time :"+totalTime);
					totalTime += talk.getTimeDuration();
					talk.setIncluded(true);
					scheduledList.add(new Talk(talk));
					iterator.remove();
				}
				}
			}

	public void print(int previousSessionTime) {
		int currentTime = this.startTime;

		for (Talk talk : scheduledList) {
			String time = TrackUtility.formatTime(currentTime);
			talk.print(time);
			currentTime = currentTime + talk.getTimeDuration();
		}
	}
}

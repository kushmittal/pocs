package com.thoughtworks.track.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thoughtworks.track.core.SessionConfig;
import com.thoughtworks.track.core.TrackAlgorithm;
import com.thoughtworks.track.core.TrackConstants;
import com.thoughtworks.track.core.TrackLoader;
import com.thoughtworks.track.exception.TrackException;
import com.thoughtworks.track.model.IntervalSession;
import com.thoughtworks.track.model.Session;
import com.thoughtworks.track.model.Talk;
import com.thoughtworks.track.model.TalkSession;
import com.thoughtworks.track.model.Track;


public class TrackManager {
	private TrackAlgorithm algorithm;

	public TrackManager(TrackAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	private List<Talk> validTalksList;

	/**
	 * creates the track list from the input list of strings 
	 * @throws Exception
	 * 
	 **/
	public List<Track> getTrackList(List<String> list) throws Exception {

		if(list == null || list.size() == 0 )
			return null;
		List<Track> tracks = new ArrayList<Track>();
		try {
			populateValidTalks(list);
			algorithm.solve(validTalksList);
			List<SessionConfig> sessionlist = TrackLoader.getSessionList();
			while (validTalksList.size() > 0) {
				Iterator<SessionConfig> iter = sessionlist.iterator();
				Track track = new Track();
				tracks.add(track);
				while (iter.hasNext()) {
					SessionConfig sessionConfig = (SessionConfig) iter.next();
					Session session = getSession(sessionConfig);
					track.addNewSession(session);
					if (validTalksList.size() > 0)
						session.scheduleSession(validTalksList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tracks;
	}

	private Session getSession(SessionConfig sessionConfig) throws TrackException {
		if (sessionConfig.getName().equalsIgnoreCase(TrackConstants.AFTERNOON_SESSION)
				|| sessionConfig.getName().equalsIgnoreCase(TrackConstants.MORNING_SESSION)) {
			return new TalkSession(sessionConfig);
		} else if (sessionConfig.getName().equalsIgnoreCase(TrackConstants.LUNCH_SESSION)
				|| sessionConfig.getName().equalsIgnoreCase(TrackConstants.NETWORKING_SESSION)) {
			return new IntervalSession(sessionConfig);
		} else {
			throw new TrackException("Invalid Session type!!");
		}

	}

	/**
	 * Validate talk list, check the time for talk and initialize validTalkList
	 * object accordingly.
	 * 
	 * @param talkList
	 * @throws Exception
	 */

	private void populateValidTalks(List<String> talkList) throws Exception {

		if (talkList == null || talkList.isEmpty()) {
			return;
		}

		validTalksList = new ArrayList<Talk>();

		int maxTalkTime = TrackConstants.maxTalkMinutes;
		int minTalkTime = TrackConstants.minTalkMinutes;
		int talktime = 0;
		// Iterate list and validate time.
		for (String talk : talkList) {
			talk = talk.replaceAll("\\s+", " ").trim();
			Pattern pattern = Pattern.compile("(.*)(\\s){1}([0-2]?[0-9]?[0-9]{1}min|lightning)\\b");
			Matcher matcher = pattern.matcher(talk);
			if (!matcher.matches()) {
				continue;
			}

			talktime = calculateTalkTime(matcher.group(3));
			if (talktime <= maxTalkTime && talktime >= minTalkTime) {
				// Add talk to the valid talk List.
				Talk talkObj = new Talk(matcher.group(1), talktime);
				talkObj.print(null);
				validTalksList.add(talkObj);
				// System.out.println("Considering : " + name);
			} else {
			}
		}
	}

	private int calculateTalkTime(String endingStr) {
		String minuteSuffix = TrackConstants.minuteSuffix;
		String lightningSuffix = TrackConstants.lightningSuffix;
		int talktime = 0;
		try {
			if (endingStr.endsWith(minuteSuffix)) {
				talktime = Integer.parseInt(endingStr.substring(0, endingStr.indexOf(minuteSuffix)));
			} else if (endingStr.endsWith(lightningSuffix)) {
				talktime = TrackConstants.lightningMinutes;
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return talktime;
	}
}

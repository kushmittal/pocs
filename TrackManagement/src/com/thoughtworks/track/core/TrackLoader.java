package com.thoughtworks.track.core;

import java.util.ArrayList;
import java.util.List;

/**
 * this class loads the configuration of sessions
 * 
 * @author kushagra.mittal
 *
 */
public class TrackLoader {

	private static List<SessionConfig> sessionsList;

	static {
		sessionsList = new ArrayList<SessionConfig>();
		SessionConfig config1 = new SessionConfig(1, "morning", 900, 1200);
		SessionConfig config2 = new SessionConfig(2, "lunch", 1200, 1300);
		SessionConfig config3 = new SessionConfig(3, "afternoon", 1300, 1700);
		SessionConfig config4 = new SessionConfig(4, "networking", 1600, 1800);
		sessionsList.add(config1);
		sessionsList.add(config2);
		sessionsList.add(config3);
		sessionsList.add(config4);

	}

	public static List<SessionConfig> getSessionList() {
		return sessionsList;
	}

}

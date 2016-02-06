package com.thoughtworks.track.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Track {
	
		static int count = 0;
		private final int ID;
		private List<Session> sessions;

		public List<Session> getSessions() {
			return sessions;
		}

		public int getID() {
			return ID;
		}

		public Track() {
			this.ID = ++count;
			sessions = new ArrayList<Session>();
		}

		public void addNewSession(Session s) {
			sessions.add(s);
		}

		public void print() {
			Iterator<Session> iter = sessions.iterator();
			int currentSessionEndTime = 0, prevSessionEndTime = 0;
			while (iter.hasNext()) {
				Session s = iter.next();
				currentSessionEndTime = s.getTotalTime();
				s.print(prevSessionEndTime);
				prevSessionEndTime = currentSessionEndTime;
			}
		}
	}


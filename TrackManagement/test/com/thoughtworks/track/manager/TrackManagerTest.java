package com.thoughtworks.track.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.track.core.TrackAlgorithm;
import com.thoughtworks.track.core.TrackAlgorithmImpl;
import com.thoughtworks.track.model.Track;

public class TrackManagerTest {

	private TrackManager trackManager;
	private TrackAlgorithm trackAlgo;

	@Before
	public void setUp() throws Exception {
		trackAlgo  = new TrackAlgorithmImpl();
		trackManager = new TrackManager(trackAlgo);
	}

	@After
	public void tearDown() throws Exception {
		trackAlgo = null;
		trackManager = null;
	}

	@Test
	public void testGetTrackList() throws Exception {
		List<Track> list =  trackManager.getTrackList(createTrackList());
		Assert.assertEquals(2, list.size());
		Assert.assertEquals(4, ((Track)list.get(0)).getSessions().size());
		Assert.assertEquals(4, ((Track)list.get(1)).getSessions().size());
	}
	
	@Test
	public void testGetTrackListNull() throws Exception {
		List<Track> list =  trackManager.getTrackList(null);
		Assert.assertNull(list);
	}

	private List<String> createTrackList() {
		List<String> listTracks = new ArrayList<String>();
		listTracks.add("Writing Fast Tests Against Enterprise Rails 60min");
		listTracks.add("Overdoing it in Python 45min");
		listTracks.add("Lua for the Masses 30min");
		listTracks.add("Ruby Errors from Mismatched Gem Versions 45min");
		listTracks.add("Common Ruby Errors 45min");
		listTracks.add("Rails for Python Developers lightning");
		listTracks.add("Communicating Over Distance 60min");
		listTracks.add("Accounting-Driven Development 45min");
		listTracks.add("Woah 30min");
		listTracks.add("Sit Down and Write 30min");
		listTracks.add("Pair Programming vs Noise 45min");
		listTracks.add("Rails Magic 60min");
		listTracks.add("Ruby on Rails: Why We Should Move On 60min");
		listTracks.add("Clojure Ate Scala (on my project) 45min");
		listTracks.add("Programming in the Boondocks of Seattle 30min");
		listTracks.add("Ruby vs. Clojure for Back-End Development 30min");
		listTracks.add("Ruby on Rails Legacy App Maintenance 60min");
		listTracks.add("A World Without HackerNews 30min");
		listTracks.add("User Interface CSS in Rails Apps 30min");
		return listTracks;
	}

}

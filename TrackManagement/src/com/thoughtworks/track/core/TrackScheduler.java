package com.thoughtworks.track.core;

import java.util.List;

import com.thoughtworks.track.manager.TrackManager;
import com.thoughtworks.track.model.Track;
import com.thoughtworks.track.utility.TrackUtility;

public class TrackScheduler {
	public static void main(String[] args) throws Exception {

		TrackAlgorithm algorithm = new TrackAlgorithmImpl();
		TrackManager manager = new TrackManager(algorithm);

		List<Track> tracklist = manager.getTrackList(TrackUtility.readInput("input/input.txt"));
		for (Track track : tracklist) {
			System.out.println("Track: " + track.getID());
			track.print();
		}

	}
}

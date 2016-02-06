package com.thoughtworks.track.core;

import java.util.Collections;
import java.util.List;

import com.thoughtworks.track.model.Talk;


/*
 * This class sorts the list of talk objects in ascending order on the basis of their time duration
 */
public class TrackAlgorithmImpl implements TrackAlgorithm
{

	@Override
	public void solve(Object obj) {
		
		Collections.sort((List<Talk>) obj);
		
	}
	
}

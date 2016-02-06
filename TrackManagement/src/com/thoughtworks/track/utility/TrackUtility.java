package com.thoughtworks.track.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author kushagra.mittal
 *
 */
public class TrackUtility {
	
	private final static String AM="AM";
	private final static String PM="PM";

	public static String formatTime(int currentTime) {
		int hour = currentTime / 60;
		String dTime;
		if (hour < 12)
		{
			dTime = AM;
		}
		else
		{
			dTime = PM;
		}
		if (hour > 12)
			hour = hour - 12;
		return  hour+":"+ (currentTime % 60) +" "+dTime;
	}

	
	public static List<String> readInput(String filename) {
		if (filename == null || "".equals(filename)) {
			return null;
		}
		List<String> inputList = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			String strLine = null;
			while ((strLine = br.readLine()) != null) {
				inputList.add(strLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null)
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return inputList;
	}
}

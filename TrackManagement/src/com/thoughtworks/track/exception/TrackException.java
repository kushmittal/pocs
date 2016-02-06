package com.thoughtworks.track.exception;

/**
 * Custom exception class for Invalid operations
 * @author kushagra.mittal
 *
 */
public class TrackException extends Exception {

	private static final long serialVersionUID = 1L;

	public TrackException(String msg) {
		super(msg);
	}

}

package com.graphqldemo.exception;


public class TutorialNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -971227892255360586L;

	public TutorialNotFoundException(String message) {
		super(message);
	}
}

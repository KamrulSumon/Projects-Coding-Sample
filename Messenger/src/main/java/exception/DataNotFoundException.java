package org.sumon.rest.messenger.exception;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -96587452136545775L;
	
	public DataNotFoundException(String message){
		super(message);
	}
}

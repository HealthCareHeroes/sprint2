package edu.uncc.ssdi.util;

public class DataExistsErrorException extends Exception{

	
	private static final long serialVersionUID = 1L;
	String message;
	
	public DataExistsErrorException(String message) {

		this.message = message;
	}
	
	
	@Override
	public String toString() {
		return ("Error : "+ message);
	}
	
}

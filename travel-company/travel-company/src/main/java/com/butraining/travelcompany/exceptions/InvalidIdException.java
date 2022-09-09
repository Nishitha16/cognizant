
package com.butraining.travelcompany.exceptions;
public class InvalidIdException extends RuntimeException {
	
	private static final long serialVersionUID = 42L;
	
	
	public InvalidIdException(String s)
	{
		super(s);
	}
	

}

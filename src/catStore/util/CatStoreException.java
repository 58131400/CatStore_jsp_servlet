/*
 * TuThienException.java
 * 
 * Version
 * 
 * 24-04-2020
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE      	AUTHOR		DESCRIPTION
 * ----------------------------------------
 * 24-04-2020	ThaiND3			
 */


package catStore.util;

// TODO: Auto-generated Javadoc
/**
 * The Class TuThienException.
 */
public class CatStoreException extends Exception{

	/** The param. */
	private String param;

	/**
	 * Instantiates a new tu thien exception.
	 *
	 * @param param the param
	 */
	public CatStoreException(String param) {
		super();
		this.param = param;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return param + "cua ban khong hop le";
	}
	
}

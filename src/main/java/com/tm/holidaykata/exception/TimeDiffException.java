package com.tm.holidaykata.exception;

/**
 * @author srake
 *
 */
public class TimeDiffException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6544274829778049974L;
	private String errorMsg;

	public TimeDiffException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}


}

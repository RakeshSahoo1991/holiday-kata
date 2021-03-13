/**
 * 
 */
package com.tm.holidaykata.exception;

/**
 * @author srake
 *
 */
public class InvalidYearException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5590203875092542092L;

	private String errorMsg;

	public InvalidYearException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}

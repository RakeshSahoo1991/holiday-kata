/**
 * 
 */
package com.tm.holidaykata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tm.holidaykata.model.ErrorModel;


/**
 * This class is responsible for handling all exception to service
 * @author srake
 *
 */
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final String INVALID_YEAR ="INVALID_YEAR";
	
	private static final String ERROR_FINDING_TIME_DIFF ="ERROR_FINDING_TIME_DIFF";
	
	/**
	 * This method sets appropriate error to the response, when there is a InvalidYearException in the service
	 * @param ex
	 * @return ResponsEntity of type ErrorModel
	 */
	@ExceptionHandler(value = { InvalidYearException.class })
    public ResponseEntity<ErrorModel> handleInvalidYear(InvalidYearException ex) {
		ErrorModel errorModel = new ErrorModel(INVALID_YEAR, ex.getErrorMsg());
        return new ResponseEntity<ErrorModel>(errorModel,HttpStatus.CONFLICT);

    }
	
	/**
	 * This method sets appropriate error to the response, when there is a TimeDiffException in the service
	 * @param ex
	 * @return ResponsEntity of type ErrorModel
	 */
	@ExceptionHandler(value = { TimeDiffException.class })
    public ResponseEntity<ErrorModel> handleTimeDiffError(TimeDiffException ex) {
		ErrorModel errorModel = new ErrorModel(ERROR_FINDING_TIME_DIFF, ex.getErrorMsg());
        return new ResponseEntity<ErrorModel>(errorModel,HttpStatus.CONFLICT);

    }

}

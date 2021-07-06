package com.cognizant.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * This is the Global Exception Handler Used to handle All the other Exception
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * This is the override method for Message Not Readable
	 */
	@Override
	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new ApiErrorResponse(status, "Malformed JSON request", ex), status);
	}
	/**
	 * For Handling ConsumerBusinessNotfoundException
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ConsumerBusinessNotfoundException.class)
	public ResponseEntity<ApiErrorResponse> handleConsumerBusinessNotfoundException(ConsumerBusinessNotfoundException ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND);
		errorResponse.setLocalizedMessage(ex.getLocalizedMessage());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	/**
	 * For Handling ConsumerPropertyException
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ConsumerPropertyException.class)
	public ResponseEntity<ApiErrorResponse> handleConsumerPropertyException(ConsumerPropertyException ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND);
		errorResponse.setLocalizedMessage(ex.getLocalizedMessage());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
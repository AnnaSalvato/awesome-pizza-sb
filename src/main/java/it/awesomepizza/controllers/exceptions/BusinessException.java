package it.awesomepizza.controllers.exceptions;

/**
 * Custom exception
 */
public class BusinessException extends Exception {

	public BusinessException() {}

	public BusinessException(String message, Throwable error) {
		super(message, error);
	}

	public BusinessException(Throwable error) {
		super(error);
	}

	public BusinessException(String message) {
		super(message);
	}
}

package it.awesomepizza.controllers.exceptions;

import jakarta.validation.ValidationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

/**
 * Handler some specific error to build the response
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handler the BusinessException error
	 * @param ex BusinessException error
	 * @return ApiError mapped response
	 */
	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<Object> buildResponseEntity(BusinessException ex) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex, "BUSINESS_EXCEPTION");
		return buildResponseEntity(apiError);
	}

	/**
	 * Handler the ValidationException error
	 * @param ex ValidationException error
	 * @return ApiError mapped response
	 */
	@ExceptionHandler(ValidationException.class)
	protected ResponseEntity<Object> buildResponseEntity(ValidationException ex) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex, "VALIDATION_EXCEPTION");
		return buildResponseEntity(apiError);
	}

	/**
	 * Handler the NoSuchElementException error
	 * @param ex NoSuchElementException error
	 * @return ApiError mapped response
	 */
	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<Object> buildResponseEntity(NoSuchElementException  ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex, "NO_ELEMENT");
		return buildResponseEntity(apiError);
	}


	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}

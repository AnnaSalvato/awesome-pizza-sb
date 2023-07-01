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

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<Object> buildResponseEntity(BusinessException ex) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex, "BUSINESS_EXCEPTION");
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(ValidationException.class)
	protected ResponseEntity<Object> buildResponseEntity(ValidationException ex) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex, "VALIDATION_EXCEPTION");
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<Object> buildResponseEntity(NoSuchElementException  ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex, "NO_ELEMENT");
		return buildResponseEntity(apiError);
	}


	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}

package it.awesomepizza.controllers.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Class to represent the error data
 */
public class ApiError {

	private HttpStatus status;
	private LocalDateTime timestamp;
	private String message;
	private String code;

	private ApiError() {
		timestamp = LocalDateTime.now();
	}

	public ApiError(HttpStatus status, Throwable ex, String code) {
		this();
		this.status = status;
		this.message = ex.getMessage();
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}

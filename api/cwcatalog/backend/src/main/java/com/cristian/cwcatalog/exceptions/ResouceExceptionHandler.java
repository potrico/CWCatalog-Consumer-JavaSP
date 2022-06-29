package com.cristian.cwcatalog.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResouceExceptionHandler {
		
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ValidationError err = new ValidationError();
		err.setStatus(status.value());
		err.setMessage(e.getBindingResult().getFieldErrors().stream().map(ex -> ex.getDefaultMessage())
                .collect(java.util.stream.Collectors.joining(", ")));

		return ResponseEntity.status(status).body(err);
	}
	
}

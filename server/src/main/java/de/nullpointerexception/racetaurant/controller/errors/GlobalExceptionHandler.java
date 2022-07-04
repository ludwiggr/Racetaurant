package de.nullpointerexception.racetaurant.controller.errors;

import java.util.Collections;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map handle(MethodArgumentNotValidException exception) {
		return error(exception.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList()
				.get(0));
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map handle(MethodArgumentTypeMismatchException exception) {
		return error(exception.getMostSpecificCause().getMessage());
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map handle(ConstraintViolationException exception) {
		return error(exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList().get(0));
	}

	private Map error(String message) {
		return Collections.singletonMap("error", message);
	}
}

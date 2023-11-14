package br.com.fiap.MaeConecta.config;

import br.com.fiap.MaeConecta.model.exception.ErrorResponse;
import br.com.fiap.MaeConecta.model.exception.FieldError;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolation(
			ConstraintViolationException ex, WebRequest request) {

		List<FieldError> fieldErrors = new ArrayList<>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			FieldError fieldError = new FieldError();
			fieldError.setField(violation.getPropertyPath().toString());
			fieldError.setMessage(violation.getMessage());
			fieldErrors.add(fieldError);
		}

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setMessage("Erro de validação");
		errorResponse.setFieldErrors(fieldErrors);

		return handleExceptionInternal(
				ex, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}

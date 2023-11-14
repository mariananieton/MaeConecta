package br.com.fiap.MaeConecta.model.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	private int code;
	private HttpStatus status;
	private String message;
	private List<FieldError> fieldErrors;
}

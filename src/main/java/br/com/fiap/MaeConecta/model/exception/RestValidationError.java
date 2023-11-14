package br.com.fiap.MaeConecta.model.exception;

public record RestValidationError(String field, String message) {
}

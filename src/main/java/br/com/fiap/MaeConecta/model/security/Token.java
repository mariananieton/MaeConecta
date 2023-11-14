package br.com.fiap.MaeConecta.model.security;

public record Token(
		String token,
		String type,
		String prefix
) {
}

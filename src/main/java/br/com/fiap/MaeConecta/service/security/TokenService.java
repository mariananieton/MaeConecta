package br.com.fiap.MaeConecta.service.security;

import br.com.fiap.MaeConecta.model.Login;
import br.com.fiap.MaeConecta.model.security.Credencial;
import br.com.fiap.MaeConecta.model.security.Token;
import br.com.fiap.MaeConecta.repository.LoginRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

	@Autowired
	LoginRepository loginRepository;

	String secret = "secret";

	public Token generateToken(@Valid Credencial credencial) {
		Algorithm alg = Algorithm.HMAC256(secret);

		Login user = loginRepository.findByEmail(credencial.email())
				.orElseThrow(() -> new JWTVerificationException("Usuário não encontrado"));

		String token = JWT.create()
				.withClaim("id", user.getId().toString())
				.withClaim("email", user.getEmail())
				.withIssuer("MaeConecta")
				.withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
				.sign(alg);

		return new Token(token, "JWT", "Bearer ");
	}

	public Login getValidateUser(String token) {
		Algorithm alg = Algorithm.HMAC256(secret);
		var jwtVerifier = JWT.require(alg).withIssuer("MaeConecta").build();
		var jwt = jwtVerifier.verify(token);

		String userId = jwt.getClaim("id").asString();
		String email = jwt.getClaim("email").asString();

		Long id = Long.parseLong(userId);
		return loginRepository.findById(id)
				.orElseThrow(() -> new JWTVerificationException("Usuário não encontrado"));
	}

}

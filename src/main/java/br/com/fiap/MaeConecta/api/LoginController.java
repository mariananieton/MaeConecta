package br.com.fiap.MaeConecta.api;

import br.com.fiap.MaeConecta.dto.form.LoginFormDTO;
import br.com.fiap.MaeConecta.dto.resposta.LoginResponseDTO;
import br.com.fiap.MaeConecta.model.security.Credencial;
import br.com.fiap.MaeConecta.service.LoginService;
import br.com.fiap.MaeConecta.service.security.TokenService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	TokenService tokenService;

	@Autowired
	AuthenticationManager authenticationManager;

	Logger log = LoggerFactory.getLogger(LoginController.class);

	@PostMapping("/api/v1/login")
	public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
		authenticationManager.authenticate(credencial.toAuthentication());
		var token = tokenService.generateToken(credencial);

		return ResponseEntity.ok(token);
	}

	@PutMapping("/api/v1/login/{id}")
	public ResponseEntity<LoginResponseDTO> atualizar(@PathVariable Long id,
													  @RequestBody @Valid LoginFormDTO loginFormDTO) {
		log.info("Atualizando login");
		return ResponseEntity.ok(loginService.atualizar(id, loginFormDTO));
	}
}

package br.com.fiap.MaeConecta.api;

import br.com.fiap.MaeConecta.dto.form.UsuarioFormDTO;
import br.com.fiap.MaeConecta.dto.response.UsuarioResponseDTO;
import br.com.fiap.MaeConecta.service.UsuarioService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	Logger log = LoggerFactory.getLogger(UsuarioController.class);

	@PostMapping
	public ResponseEntity<UsuarioResponseDTO> salvar(@RequestBody @Valid UsuarioFormDTO usuarioFormDTO) {
		log.info("Salvando usuário");

		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(usuarioFormDTO));
	}

	@GetMapping("{id}")
	public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
		log.info("Buscando usuário por id");

		return ResponseEntity.ok(usuarioService.buscarPorId(id));
	}

	@PutMapping("{id}")
	public ResponseEntity<UsuarioResponseDTO> atualizar(@PathVariable Long id,
														@RequestBody UsuarioFormDTO usuarioFormDTO) {
		log.info("Atualizando usuário");

		return ResponseEntity.ok(usuarioService.atualizar(id, usuarioFormDTO));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<UsuarioResponseDTO> deletarPorId(@PathVariable Long id) {
		log.info("Deletando usuário por id");

		usuarioService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}
}

package br.com.fiap.MaeConecta.api;

import br.com.fiap.MaeConecta.dto.form.ContatoEmergenciaFormDTO;
import br.com.fiap.MaeConecta.dto.response.ContatoEmergenciaResponseDTO;
import br.com.fiap.MaeConecta.service.ContatoEmergenciaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contato")
public class ContatoEmergenciaController {

	@Autowired
	ContatoEmergenciaService contatoEmergenciaService;

	Logger log = LoggerFactory.getLogger(ContatoEmergenciaController.class);

	@PostMapping("{id}")
	public ResponseEntity<ContatoEmergenciaResponseDTO> salvar(@PathVariable Long id,
															   @RequestBody @Valid ContatoEmergenciaFormDTO contatoEmergenciaFormDTO) {
		log.info("Salvando contato de emergência");

		return ResponseEntity.status(HttpStatus.CREATED).body(contatoEmergenciaService.salvar(id, contatoEmergenciaFormDTO));
	}

	@GetMapping("{id}")
	public ResponseEntity<ContatoEmergenciaResponseDTO> buscarPorId(@PathVariable Long id) {
		log.info("Buscando contato de emergência por id");

		return ResponseEntity.ok(contatoEmergenciaService.buscarPorId(id));
	}

	@PutMapping("{id}")
	public ResponseEntity<ContatoEmergenciaResponseDTO> atualizar(@PathVariable Long id,
																  @RequestBody ContatoEmergenciaFormDTO contatoEmergenciaFormDTO) {
		log.info("Atualizando contato de emergência");

		return ResponseEntity.ok(contatoEmergenciaService.atualizar(id, contatoEmergenciaFormDTO));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ContatoEmergenciaResponseDTO> deletarPorId(@PathVariable Long id) {
		log.info("Deletando contato de emergência por id");

		contatoEmergenciaService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<ContatoEmergenciaResponseDTO>> buscarTodos() {
		log.info("Buscando todos os contatos de emergência");

		return ResponseEntity.ok(contatoEmergenciaService.buscarTodos());
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<List<ContatoEmergenciaResponseDTO>> buscarTodos(@PathVariable Long id) {
		log.info("Buscando todos os contatos de emergência do usuário");

		return ResponseEntity.ok(contatoEmergenciaService.buscarTodos(id));
	}

}

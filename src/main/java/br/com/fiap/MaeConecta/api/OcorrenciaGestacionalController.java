package br.com.fiap.MaeConecta.api;

import br.com.fiap.MaeConecta.dto.form.OcorrenciaGestacionalFormDTO;
import br.com.fiap.MaeConecta.dto.response.OcorrenciaGestacionalResponseDTO;
import br.com.fiap.MaeConecta.service.OcorrenciaGestacionalService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ocorrencia")
public class OcorrenciaGestacionalController {

	@Autowired
	OcorrenciaGestacionalService ocorrenciaGestacionalService;

	Logger log = LoggerFactory.getLogger(OcorrenciaGestacionalController.class);

	@PostMapping("{id}")
	public ResponseEntity<OcorrenciaGestacionalResponseDTO> salvar(@PathVariable Long id,
																   @RequestBody @Valid OcorrenciaGestacionalFormDTO ocorrenciaGestacionalFormDTO) {
		log.info("Salvando ocorrência gestacional");

		return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaGestacionalService.salvar(id, ocorrenciaGestacionalFormDTO));
	}

	@GetMapping("{id}")
	public ResponseEntity<OcorrenciaGestacionalResponseDTO> buscarPorId(@PathVariable Long id) {
		log.info("Buscando ocorrência gestacional por id");

		return ResponseEntity.ok(ocorrenciaGestacionalService.buscarPorId(id));
	}

	@PutMapping("{id}")
	public ResponseEntity<OcorrenciaGestacionalResponseDTO> atualizar(@PathVariable Long id,
																	  @RequestBody OcorrenciaGestacionalFormDTO ocorrenciaGestacionalFormDTO) {
		log.info("Atualizando ocorrência gestacional");

		return ResponseEntity.ok(ocorrenciaGestacionalService.atualizar(id, ocorrenciaGestacionalFormDTO));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<OcorrenciaGestacionalResponseDTO> deletarPorId(@PathVariable Long id) {
		log.info("Deletando ocorrência gestacional por id");

		ocorrenciaGestacionalService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<OcorrenciaGestacionalResponseDTO>> buscarTodos() {
		log.info("Buscando todas as ocorrências gestacionais");

		return ResponseEntity.ok(ocorrenciaGestacionalService.buscarTodos());
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<List<OcorrenciaGestacionalResponseDTO>> buscarTodos(@PathVariable Long id) {
		log.info("Buscando todas as ocorrências gestacionais do usuário");

		return ResponseEntity.ok(ocorrenciaGestacionalService.buscarTodos(id));
	}

}

package br.com.fiap.MaeConecta.api;

import br.com.fiap.MaeConecta.dto.form.ProcedimentoFormDTO;
import br.com.fiap.MaeConecta.dto.response.ProcedimentoResponseDTO;
import br.com.fiap.MaeConecta.model.Procedimento;
import br.com.fiap.MaeConecta.service.ProcedimentoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/procedimento")
public class ProcedimentoController {

	@Autowired
	ProcedimentoService procedimentoService;

	Logger log = LoggerFactory.getLogger(ProcedimentoController.class);

	@PostMapping
	public ResponseEntity<ProcedimentoResponseDTO> salvar(@RequestBody @Valid Procedimento procedimento) {
		log.info("Salvando procedimento");

		return ResponseEntity.status(HttpStatus.CREATED).body(procedimentoService.salvar(procedimento));
	}

	@GetMapping("{id}")
	public ResponseEntity<ProcedimentoResponseDTO> buscarPorId(@PathVariable Long id) {
		log.info("Buscando procedimento por id");

		return ResponseEntity.ok(procedimentoService.buscarPorId(id));
	}

	@PutMapping("{id}")
	public ResponseEntity<ProcedimentoResponseDTO> atualizar(@PathVariable Long id,
															 @RequestBody ProcedimentoFormDTO procedimentoFormDTO) {
		log.info("Atualizando procedimento");

		return ResponseEntity.ok(procedimentoService.atualizar(id, procedimentoFormDTO));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ProcedimentoResponseDTO> deletarPorId(@PathVariable Long id) {
		log.info("Deletando procedimento por id");

		procedimentoService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<ProcedimentoResponseDTO>> buscarTodos() {
		log.info("Buscando todos os procedimentos");

		return ResponseEntity.ok(procedimentoService.buscarTodos());
	}

}

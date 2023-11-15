package br.com.fiap.MaeConecta.service;

import br.com.fiap.MaeConecta.dto.form.ContatoEmergenciaFormDTO;
import br.com.fiap.MaeConecta.dto.response.ContatoEmergenciaResponseDTO;
import br.com.fiap.MaeConecta.model.ContatoEmergencia;

import java.util.List;

public interface ContatoEmergenciaService {

	ContatoEmergenciaResponseDTO salvar(ContatoEmergencia contatoEmergencia);

	ContatoEmergenciaResponseDTO buscarPorId(Long id);

	ContatoEmergenciaResponseDTO atualizar(Long id, ContatoEmergenciaFormDTO contatoEmergenciaFormDTO);

	void deletarPorId(Long id);

	List<ContatoEmergenciaResponseDTO> buscarTodos();

}

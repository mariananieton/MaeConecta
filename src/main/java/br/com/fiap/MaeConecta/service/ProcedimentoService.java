package br.com.fiap.MaeConecta.service;

import br.com.fiap.MaeConecta.dto.form.ProcedimentoFormDTO;
import br.com.fiap.MaeConecta.dto.response.ProcedimentoResponseDTO;

import java.util.List;

public interface ProcedimentoService {

	ProcedimentoResponseDTO salvar(Long id, ProcedimentoFormDTO procedimentoFormDTO);

	ProcedimentoResponseDTO buscarPorId(Long id);

	ProcedimentoResponseDTO atualizar(Long id, ProcedimentoFormDTO procedimentoFormDTO);

	void deletarPorId(Long id);

	List<ProcedimentoResponseDTO> buscarTodos();

	List<ProcedimentoResponseDTO> buscarTodos(Long id);

}

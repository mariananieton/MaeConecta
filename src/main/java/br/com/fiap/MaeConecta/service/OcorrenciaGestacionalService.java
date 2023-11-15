package br.com.fiap.MaeConecta.service;

import br.com.fiap.MaeConecta.dto.form.OcorrenciaGestacionalFormDTO;
import br.com.fiap.MaeConecta.dto.response.OcorrenciaGestacionalResponseDTO;

import java.util.List;

public interface OcorrenciaGestacionalService {

	OcorrenciaGestacionalResponseDTO salvar(Long id, OcorrenciaGestacionalFormDTO ocorrenciaGestacionalFormDTO);

	OcorrenciaGestacionalResponseDTO buscarPorId(Long id);

	OcorrenciaGestacionalResponseDTO atualizar(Long id, OcorrenciaGestacionalFormDTO ocorrenciaGestacionalFormDTO);

	void deletarPorId(Long id);

	List<OcorrenciaGestacionalResponseDTO> buscarTodos();

	List<OcorrenciaGestacionalResponseDTO> buscarTodos(Long id);

}

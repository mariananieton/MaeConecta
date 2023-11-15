package br.com.fiap.MaeConecta.service;

import br.com.fiap.MaeConecta.dto.form.OcorrenciaGestacionalFormDTO;
import br.com.fiap.MaeConecta.dto.response.OcorrenciaGestacionalResponseDTO;
import br.com.fiap.MaeConecta.model.OcorrenciaGestacional;

import java.util.List;

public interface OcorrenciaGestacionalService {

	OcorrenciaGestacionalResponseDTO salvar(OcorrenciaGestacional ocorrenciaGestacional);

	OcorrenciaGestacionalResponseDTO buscarPorId(Long id);

	OcorrenciaGestacionalResponseDTO atualizar(Long id, OcorrenciaGestacionalFormDTO ocorrenciaGestacionalFormDTO);

	void deletarPorId(Long id);

	List<OcorrenciaGestacionalResponseDTO> buscarTodos();

}

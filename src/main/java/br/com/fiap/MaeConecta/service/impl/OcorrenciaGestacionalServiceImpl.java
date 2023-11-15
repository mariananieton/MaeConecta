package br.com.fiap.MaeConecta.service.impl;

import br.com.fiap.MaeConecta.dto.form.OcorrenciaGestacionalFormDTO;
import br.com.fiap.MaeConecta.dto.response.OcorrenciaGestacionalResponseDTO;
import br.com.fiap.MaeConecta.exception.RestNotFoundException;
import br.com.fiap.MaeConecta.model.OcorrenciaGestacional;
import br.com.fiap.MaeConecta.repository.OcorrenciaGestacionalRepository;
import br.com.fiap.MaeConecta.service.OcorrenciaGestacionalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OcorrenciaGestacionalServiceImpl implements OcorrenciaGestacionalService {

	@Autowired
	OcorrenciaGestacionalRepository ocorrenciaGestacionalRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public OcorrenciaGestacionalResponseDTO salvar(OcorrenciaGestacional ocorrenciaGestacional) {
		ocorrenciaGestacionalRepository.save(ocorrenciaGestacional);

		return convertToOcorrenciaGestacionalResponse(ocorrenciaGestacional);
	}

	@Override
	public OcorrenciaGestacionalResponseDTO buscarPorId(Long id) {
		return convertToOcorrenciaGestacionalResponse(getOcorrenciaGestacional(id));
	}

	@Override
	public OcorrenciaGestacionalResponseDTO atualizar(Long id, OcorrenciaGestacionalFormDTO ocorrenciaGestacionalFormDTO) {
		OcorrenciaGestacional ocorrenciaGestacional = ocorrenciaGestacionalRepository.findById(id).get();
		ocorrenciaGestacional.setTitulo(ocorrenciaGestacionalFormDTO.getTitulo());
		ocorrenciaGestacional.setDataOcorrencia(ocorrenciaGestacionalFormDTO.getDataOcorrencia());
		ocorrenciaGestacional.setDescricao(ocorrenciaGestacionalFormDTO.getDescricao());

		ocorrenciaGestacionalRepository.save(ocorrenciaGestacional);

		return convertToOcorrenciaGestacionalResponse(ocorrenciaGestacional);
	}

	@Override
	public void deletarPorId(Long id) {
		var ocorrenciaGestacional = getOcorrenciaGestacional(id);
		ocorrenciaGestacionalRepository.delete(ocorrenciaGestacional);
	}

	@Override
	public List<OcorrenciaGestacionalResponseDTO> buscarTodos() {
		List<OcorrenciaGestacional> ocorrenciasGestacionais = ocorrenciaGestacionalRepository.findAll();
		List<OcorrenciaGestacionalResponseDTO> ocorrenciasGestacionaisResponseDTO = new ArrayList<>();

		for (OcorrenciaGestacional ocorrenciaGestacional : ocorrenciasGestacionais) {
			OcorrenciaGestacionalResponseDTO ocorrenciaGestacionalResponseDTO = convertToOcorrenciaGestacionalResponse(ocorrenciaGestacional);
			ocorrenciasGestacionaisResponseDTO.add(ocorrenciaGestacionalResponseDTO);
		}

		return ocorrenciasGestacionaisResponseDTO;
	}

	private OcorrenciaGestacionalResponseDTO convertToOcorrenciaGestacionalResponse(OcorrenciaGestacional ocorrenciaGestacional) {
		return modelMapper.map(ocorrenciaGestacional, OcorrenciaGestacionalResponseDTO.class);
	}

	public OcorrenciaGestacional getOcorrenciaGestacional(Long id) {
		return ocorrenciaGestacionalRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Ocorrência Gestacional não encontrada"));
	}
}
package br.com.fiap.MaeConecta.service.impl;

import br.com.fiap.MaeConecta.dto.form.OcorrenciaGestacionalFormDTO;
import br.com.fiap.MaeConecta.dto.response.OcorrenciaGestacionalResponseDTO;
import br.com.fiap.MaeConecta.exception.RestNotFoundException;
import br.com.fiap.MaeConecta.model.OcorrenciaGestacional;
import br.com.fiap.MaeConecta.model.Procedimento;
import br.com.fiap.MaeConecta.model.Usuario;
import br.com.fiap.MaeConecta.repository.OcorrenciaGestacionalRepository;
import br.com.fiap.MaeConecta.repository.ProcedimentoRepository;
import br.com.fiap.MaeConecta.repository.UsuarioRepository;
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
	UsuarioRepository usuarioRepository;

	@Autowired
	ProcedimentoRepository procedimentoRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public OcorrenciaGestacionalResponseDTO salvar(Long id, OcorrenciaGestacionalFormDTO ocorrenciaGestacionalFormDTO) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new RestNotFoundException("Usuário não encontrado"));

		OcorrenciaGestacional ocorrenciaGestacional = convertToEntity(ocorrenciaGestacionalFormDTO);
		ocorrenciaGestacional.setTitulo(ocorrenciaGestacionalFormDTO.getTitulo());
		ocorrenciaGestacional.setDataOcorrencia(ocorrenciaGestacionalFormDTO.getDataOcorrencia());
		ocorrenciaGestacional.setDescricao(ocorrenciaGestacionalFormDTO.getDescricao());
		ocorrenciaGestacional.setUsuario(usuario);
		if (ocorrenciaGestacionalFormDTO.getProcedimentoId() != null) {
			Procedimento procedimento = procedimentoRepository.findById(ocorrenciaGestacionalFormDTO.getProcedimentoId())
					.orElseThrow(() -> new RestNotFoundException("Procedimento não encontrado"));
			ocorrenciaGestacional.setProcedimento(procedimento);
		}

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

	@Override
	public List<OcorrenciaGestacionalResponseDTO> buscarTodos(Long userId) {
		List<OcorrenciaGestacional> ocorrenciasGestacionais = ocorrenciaGestacionalRepository.findAllByUsuarioId(userId);
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

	private OcorrenciaGestacional convertToEntity(OcorrenciaGestacionalFormDTO ocorrenciaGestacionalFormDTO) {
		return modelMapper.map(ocorrenciaGestacionalFormDTO, OcorrenciaGestacional.class);
	}

	public OcorrenciaGestacional getOcorrenciaGestacional(Long id) {
		return ocorrenciaGestacionalRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Ocorrência Gestacional não encontrada"));
	}

}
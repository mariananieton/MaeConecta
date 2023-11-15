package br.com.fiap.MaeConecta.service.impl;

import br.com.fiap.MaeConecta.dto.form.ProcedimentoFormDTO;
import br.com.fiap.MaeConecta.dto.response.ProcedimentoResponseDTO;
import br.com.fiap.MaeConecta.exception.RestNotFoundException;
import br.com.fiap.MaeConecta.model.Procedimento;
import br.com.fiap.MaeConecta.repository.ProcedimentoRepository;
import br.com.fiap.MaeConecta.service.ProcedimentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcedimentoServiceImpl implements ProcedimentoService {

	@Autowired
	ProcedimentoRepository procedimentoRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ProcedimentoResponseDTO salvar(Procedimento procedimento) {
		procedimentoRepository.save(procedimento);

		return convertToProcedimentoResponse(procedimento);
	}

	@Override
	public ProcedimentoResponseDTO buscarPorId(Long id) {
		return convertToProcedimentoResponse(getProcedimento(id));
	}

	@Override
	public ProcedimentoResponseDTO atualizar(Long id, ProcedimentoFormDTO procedimentoFormDTO) {
		Procedimento procedimento = procedimentoRepository.findById(id).get();
		procedimento.setDataProcedimento(procedimentoFormDTO.getDataProcedimento());
		procedimento.setTipoProcedimento(procedimentoFormDTO.getTipoProcedimento());
		procedimento.setEspecialidade(procedimentoFormDTO.getEspecialidade());

		procedimentoRepository.save(procedimento);

		return convertToProcedimentoResponse(procedimento);
	}

	@Override
	public void deletarPorId(Long id) {
		var procedimento = getProcedimento(id);
		procedimentoRepository.delete(procedimento);
	}

	@Override
	public List<ProcedimentoResponseDTO> buscarTodos() {
		List<Procedimento> procedimentos = procedimentoRepository.findAll();
		List<ProcedimentoResponseDTO> procedimentosResponseDTO = new ArrayList<>();

		for (Procedimento procedimento : procedimentos) {
			ProcedimentoResponseDTO procedimentoResponseDTO = convertToProcedimentoResponse(procedimento);
			procedimentosResponseDTO.add(procedimentoResponseDTO);
		}

		return procedimentosResponseDTO;
	}

	private ProcedimentoResponseDTO convertToProcedimentoResponse(Procedimento procedimento) {
		return modelMapper.map(procedimento, ProcedimentoResponseDTO.class);
	}

	public Procedimento getProcedimento(Long id) {
		return procedimentoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Procedimento não encontrado"));
	}
}

package br.com.fiap.MaeConecta.service.impl;

import br.com.fiap.MaeConecta.dto.form.ContatoEmergenciaFormDTO;
import br.com.fiap.MaeConecta.dto.response.ContatoEmergenciaResponseDTO;
import br.com.fiap.MaeConecta.exception.RestNotFoundException;
import br.com.fiap.MaeConecta.model.ContatoEmergencia;
import br.com.fiap.MaeConecta.model.Usuario;
import br.com.fiap.MaeConecta.repository.ContatoEmergenciaRepository;
import br.com.fiap.MaeConecta.repository.UsuarioRepository;
import br.com.fiap.MaeConecta.service.ContatoEmergenciaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatoEmergenciaServiceImpl implements ContatoEmergenciaService {

	@Autowired
	ContatoEmergenciaRepository contatoEmergenciaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ContatoEmergenciaResponseDTO salvar(Long id, ContatoEmergenciaFormDTO contatoEmergenciaFormDTO) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new RestNotFoundException("Usuário não encontrado"));

		ContatoEmergencia contatoEmergencia = convertToEntity(contatoEmergenciaFormDTO);
		contatoEmergencia.setNome(contatoEmergenciaFormDTO.getNome());
		contatoEmergencia.setTelefone(contatoEmergenciaFormDTO.getTelefone());
		contatoEmergencia.setRelacionamento(contatoEmergenciaFormDTO.getRelacionamento());
		contatoEmergencia.setUsuario(usuario);

		contatoEmergenciaRepository.save(contatoEmergencia);

		return convertToContatoEmergenciaResponse(contatoEmergencia);
	}

	@Override
	public ContatoEmergenciaResponseDTO buscarPorId(Long id) {
		return convertToContatoEmergenciaResponse(getContatoEmergencia(id));
	}

	@Override
	public ContatoEmergenciaResponseDTO atualizar(Long id, ContatoEmergenciaFormDTO contatoEmergenciaFormDTO) {
		ContatoEmergencia contatoEmergencia = contatoEmergenciaRepository.findById(id).get();
		contatoEmergencia.setNome(contatoEmergenciaFormDTO.getNome());
		contatoEmergencia.setTelefone(contatoEmergenciaFormDTO.getTelefone());
		contatoEmergencia.setRelacionamento(contatoEmergenciaFormDTO.getRelacionamento());

		contatoEmergenciaRepository.save(contatoEmergencia);

		return convertToContatoEmergenciaResponse(contatoEmergencia);
	}

	@Override
	public void deletarPorId(Long id) {
		var contatoEmergencia = getContatoEmergencia(id);
		contatoEmergenciaRepository.delete(contatoEmergencia);
	}

	@Override
	public List<ContatoEmergenciaResponseDTO> buscarTodos() {
		List<ContatoEmergencia> contatosEmergencia = contatoEmergenciaRepository.findAll();
		List<ContatoEmergenciaResponseDTO> contatosEmergenciaResponseDTO = new ArrayList<>();

		for (ContatoEmergencia contatoEmergencia : contatosEmergencia) {
			ContatoEmergenciaResponseDTO contatoEmergenciaResponseDTO = convertToContatoEmergenciaResponse(contatoEmergencia);
			contatosEmergenciaResponseDTO.add(contatoEmergenciaResponseDTO);
		}

		return contatosEmergenciaResponseDTO;
	}

	@Override
	public List<ContatoEmergenciaResponseDTO> buscarTodos(Long userId) {
		List<ContatoEmergencia> contatosEmergencia = contatoEmergenciaRepository.findAllByUsuarioId(userId);
		List<ContatoEmergenciaResponseDTO> contatosEmergenciaResponseDTO = new ArrayList<>();

		for (ContatoEmergencia contatoEmergencia : contatosEmergencia) {
			ContatoEmergenciaResponseDTO contatoEmergenciaResponseDTO = convertToContatoEmergenciaResponse(contatoEmergencia);
			contatosEmergenciaResponseDTO.add(contatoEmergenciaResponseDTO);
		}

		return contatosEmergenciaResponseDTO;
	}

	private ContatoEmergenciaResponseDTO convertToContatoEmergenciaResponse(ContatoEmergencia contatoEmergencia) {
		return modelMapper.map(contatoEmergencia, ContatoEmergenciaResponseDTO.class);
	}

	private ContatoEmergencia convertToEntity(ContatoEmergenciaFormDTO contatoEmergenciaFormDTO) {
		return modelMapper.map(contatoEmergenciaFormDTO, ContatoEmergencia.class);
	}

	public ContatoEmergencia getContatoEmergencia(Long id) {
		return contatoEmergenciaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Contato de Emergência não encontrado"));
	}
}

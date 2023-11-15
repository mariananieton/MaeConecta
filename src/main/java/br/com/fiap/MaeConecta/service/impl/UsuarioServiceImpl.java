package br.com.fiap.MaeConecta.service.impl;

import br.com.fiap.MaeConecta.dto.form.UsuarioFormDTO;
import br.com.fiap.MaeConecta.dto.response.UsuarioResponseDTO;
import br.com.fiap.MaeConecta.exception.RestNotFoundException;
import br.com.fiap.MaeConecta.model.Usuario;
import br.com.fiap.MaeConecta.repository.UsuarioRepository;
import br.com.fiap.MaeConecta.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public UsuarioResponseDTO buscarPorId(Long id) {
		return convertToUsuarioResponse(getUsuario(id));
	}

	@Override
	public UsuarioResponseDTO atualizar(Long id, UsuarioFormDTO usuarioFormDTO) {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuario.setNome(usuarioFormDTO.getNome());
		usuario.setDataNascimento(usuarioFormDTO.getDataNascimento());
		usuario.setDataCadastro(usuarioFormDTO.getDataCadastro());
		usuario.setTipoSanguineo(usuarioFormDTO.getTipoSanguineo());
		usuario.setSemanasGestacao(usuarioFormDTO.getSemanasGestacao());

		usuarioRepository.save(usuario);

		return convertToUsuarioResponse(usuario);
	}

	@Override
	public void deletarPorId(Long id) {
		var usuario = getUsuario(id);
		usuarioRepository.delete(usuario);
	}


	private UsuarioResponseDTO convertToUsuarioResponse(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioResponseDTO.class);
	}

	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuário não encontrado"));
	}
}

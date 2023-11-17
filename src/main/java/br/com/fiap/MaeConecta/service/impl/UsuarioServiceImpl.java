package br.com.fiap.MaeConecta.service.impl;

import br.com.fiap.MaeConecta.dto.form.LoginFormDTO;
import br.com.fiap.MaeConecta.dto.form.UsuarioFormDTO;
import br.com.fiap.MaeConecta.dto.response.UsuarioResponseDTO;
import br.com.fiap.MaeConecta.exception.RestNotFoundException;
import br.com.fiap.MaeConecta.model.Login;
import br.com.fiap.MaeConecta.model.TipoSanguineo;
import br.com.fiap.MaeConecta.model.Usuario;
import br.com.fiap.MaeConecta.repository.UsuarioRepository;
import br.com.fiap.MaeConecta.service.LoginService;
import br.com.fiap.MaeConecta.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	LoginService loginService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public UsuarioResponseDTO salvar(UsuarioFormDTO usuarioFormDTO) {
		Usuario usuario = convertToEntity(usuarioFormDTO);
		usuario.setNome(usuarioFormDTO.getNome());
		usuario.setDataNascimento(usuarioFormDTO.getDataNascimento());
		usuario.setDataCadastro(LocalDate.now());
		usuario.setTipoSanguineo(TipoSanguineo.fromString(usuarioFormDTO.getTipoSanguineo()));
		usuario.setSemanasGestacao(usuarioFormDTO.getSemanasGestacao());

		LoginFormDTO loginFormDTO = usuarioFormDTO.getLogin();
		loginFormDTO.setSenha(encoder.encode(loginFormDTO.getSenha()));

		Login login = convertToEntity(loginFormDTO);
		loginService.salvar(login);

		usuario.setLogin(login);
		usuarioRepository.save(usuario);

		return convertToUsuarioResponse(usuario);
	}

	@Override
	public UsuarioResponseDTO buscarPorId(Long id) {
		Usuario usuario = getUsuario(id);
		UsuarioResponseDTO responseDTO = convertToUsuarioResponse(usuario);
		responseDTO.setTipoSanguineo(usuario.getTipoSanguineo());
		return responseDTO;
	}

	@Override
	public UsuarioResponseDTO atualizar(Long id, UsuarioFormDTO usuarioFormDTO) {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuario.setNome(usuarioFormDTO.getNome());
		usuario.setDataNascimento(usuarioFormDTO.getDataNascimento());
		usuario.setTipoSanguineo(TipoSanguineo.fromString(usuarioFormDTO.getTipoSanguineo()));
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

	private Usuario convertToEntity(UsuarioFormDTO usuarioFormDTO) {
		return modelMapper.map(usuarioFormDTO, Usuario.class);
	}

	private Login convertToEntity(LoginFormDTO loginFormDTO) {
		return modelMapper.map(loginFormDTO, Login.class);
	}

	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuário não encontrado"));
	}
}

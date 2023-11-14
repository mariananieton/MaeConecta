package br.com.fiap.MaeConecta.service.impl;

import br.com.fiap.MaeConecta.dto.form.LoginFormDTO;
import br.com.fiap.MaeConecta.dto.form.UsuarioFormDTO;
import br.com.fiap.MaeConecta.dto.resposta.UsuarioResponseDTO;
import br.com.fiap.MaeConecta.model.Login;
import br.com.fiap.MaeConecta.model.Usuario;
import br.com.fiap.MaeConecta.model.UsuarioLogin;
import br.com.fiap.MaeConecta.service.LoginService;
import br.com.fiap.MaeConecta.service.UsuarioLoginService;
import br.com.fiap.MaeConecta.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioLoginServiceImpl implements UsuarioLoginService {

	@Autowired
	LoginService loginService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public UsuarioResponseDTO salvar(UsuarioLogin usuarioLogin) {
		UsuarioFormDTO usuarioFormDTO = usuarioLogin.getUsuario();

		LoginFormDTO loginFormDTO = usuarioLogin.getLogin();
		loginFormDTO.setSenha(encoder.encode(loginFormDTO.getSenha()));

		Login login = convertToEntity(loginFormDTO);
		loginService.salvar(login);

		Usuario usuario = convertToEntity(usuarioFormDTO);
		usuario.setLogin(login);

		usuarioService.salvar(usuario);

		return convertToUsuarioResponse(usuario);
	}

	private Login convertToEntity(LoginFormDTO loginFormDTO) {
		return modelMapper.map(loginFormDTO, Login.class);
	}

	private Usuario convertToEntity(UsuarioFormDTO usuarioFormDTO) {
		return modelMapper.map(usuarioFormDTO, Usuario.class);
	}

	private UsuarioResponseDTO convertToUsuarioResponse(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioResponseDTO.class);
	}
}

package br.com.fiap.MaeConecta.service.impl;

import br.com.fiap.MaeConecta.dto.form.LoginFormDTO;
import br.com.fiap.MaeConecta.dto.resposta.LoginResponseDTO;
import br.com.fiap.MaeConecta.exception.RestNotFoundException;
import br.com.fiap.MaeConecta.model.Login;
import br.com.fiap.MaeConecta.repository.LoginRepository;
import br.com.fiap.MaeConecta.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public Login salvar(Login login) {
		return loginRepository.save(login);
	}

	@Override
	public Login buscarPorId(Long id) {
		return loginRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Login não encontrado"));
	}

	@Override
	public LoginResponseDTO atualizar(Long id, LoginFormDTO loginFormDTO) {
		var login = buscarPorId(id);
		login.setEmail(login.getEmail());
		login.setSenha(encoder.encode(login.getSenha()));

		return convertToLoginResponse(salvar(login));
	}

	@Override
	public void deletarPorId(Long id) {
		loginRepository.delete(buscarPorId(id));
	}

	@Override
	public Login buscarPorEmail(String email) {
		return loginRepository.findByEmail(email).orElseThrow(() -> new RestNotFoundException("Login não encontrado"));
	}

	private LoginResponseDTO convertToLoginResponse(Login login) {
		return modelMapper.map(login, LoginResponseDTO.class);
	}
}

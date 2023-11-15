package br.com.fiap.MaeConecta.service;

import br.com.fiap.MaeConecta.dto.form.LoginFormDTO;
import br.com.fiap.MaeConecta.dto.response.LoginResponseDTO;
import br.com.fiap.MaeConecta.model.Login;

public interface LoginService {

	Login salvar(Login login);

	Login buscarPorId(Long id);

	LoginResponseDTO atualizar(Long id, LoginFormDTO loginFormDTO);

	void deletarPorId(Long id);

	Login buscarPorEmail(String email);
}

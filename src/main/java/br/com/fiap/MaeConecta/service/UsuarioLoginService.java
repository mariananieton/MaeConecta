package br.com.fiap.MaeConecta.service;

import br.com.fiap.MaeConecta.dto.response.UsuarioResponseDTO;
import br.com.fiap.MaeConecta.model.UsuarioLogin;

public interface UsuarioLoginService {

	UsuarioResponseDTO salvar(UsuarioLogin usuarioLogin);

}

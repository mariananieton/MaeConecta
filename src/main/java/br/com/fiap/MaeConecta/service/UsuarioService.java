package br.com.fiap.MaeConecta.service;

import br.com.fiap.MaeConecta.dto.form.UsuarioFormDTO;
import br.com.fiap.MaeConecta.dto.response.UsuarioResponseDTO;

public interface UsuarioService {

	UsuarioResponseDTO salvar(UsuarioFormDTO usuarioFormDTO);

	UsuarioResponseDTO buscarPorId(Long id);

	UsuarioResponseDTO atualizar(Long id, UsuarioFormDTO usuarioFormDTO);

	void deletarPorId(Long id);

}

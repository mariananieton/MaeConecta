package br.com.fiap.MaeConecta.service;

import br.com.fiap.MaeConecta.dto.form.UsuarioFormDTO;
import br.com.fiap.MaeConecta.dto.response.UsuarioResponseDTO;
import br.com.fiap.MaeConecta.model.Usuario;

public interface UsuarioService {

	Usuario salvar(Usuario usuario);

	UsuarioResponseDTO buscarPorId(Long id);

	UsuarioResponseDTO atualizar(Long id, UsuarioFormDTO usuarioFormDTO);

	void deletarPorId(Long id);

}

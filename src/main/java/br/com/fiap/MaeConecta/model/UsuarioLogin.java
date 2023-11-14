package br.com.fiap.MaeConecta.model;

import br.com.fiap.MaeConecta.dto.form.LoginFormDTO;
import br.com.fiap.MaeConecta.dto.form.UsuarioFormDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLogin {

	private UsuarioFormDTO usuario;
	private LoginFormDTO login;

}

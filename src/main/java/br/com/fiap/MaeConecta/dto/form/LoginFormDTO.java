package br.com.fiap.MaeConecta.dto.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginFormDTO {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String senha;
}

package br.com.fiap.MaeConecta.dto.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContatoEmergenciaFormDTO {

	@NotBlank
	@Size(min = 3, max = 200)
	private String nome;

	@NotBlank
	private String telefone;

	@NotBlank
	@Size(min = 3, max = 100)
	private String relacionamento;
}

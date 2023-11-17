package br.com.fiap.MaeConecta.dto.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioFormDTO {

	@NotBlank
	@Size(min = 3, max = 200)
	private String nome;

	@NotNull
	private LocalDate dataNascimento;

	@NotBlank
	private String tipoSanguineo;

	@NotNull
	@Positive
	private Integer semanasGestacao;

	private LoginFormDTO login;

}

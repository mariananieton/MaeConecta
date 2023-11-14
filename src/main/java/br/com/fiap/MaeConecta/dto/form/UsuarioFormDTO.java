package br.com.fiap.MaeConecta.dto.form;

import br.com.fiap.MaeConecta.model.TipoSanguineo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	@Positive
	private Integer idade;

	@NotBlank
	private String cpf;

	@NotNull
	@Positive
	private Integer semanasGestacao;

	@NotNull
	private LocalDate dataCadastro;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoSanguineo tipoSanguineo;
}

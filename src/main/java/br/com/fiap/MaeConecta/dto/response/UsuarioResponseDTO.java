package br.com.fiap.MaeConecta.dto.response;

import br.com.fiap.MaeConecta.model.TipoSanguineo;
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
public class UsuarioResponseDTO {

	@NotNull
	private Long id;

	@NotBlank
	@Size(min = 3, max = 200)
	private String nome;

	@NotNull
	private LocalDate dataNascimento;

	@NotNull
	private LocalDate dataCadastro;

	@NotBlank
	private String tipoSanguineo;

	@NotNull
	@Positive
	private Integer semanasGestacao;

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo.getNome();
	}
}

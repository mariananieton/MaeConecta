package br.com.fiap.MaeConecta.dto.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class OcorrenciaGestacionalFormDTO {

	@NotBlank
	@Size(min = 3)
	private String titulo;

	@NotNull
	private LocalDate dataOcorrencia;

	@NotBlank
	@Size(min = 3, max = 200)
	private String descricao;

	private Long procedimentoId;

}

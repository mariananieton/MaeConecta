package br.com.fiap.MaeConecta.dto.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcedimentoFormDTO {

	@NotNull
	private LocalDate dataProcedimento;

	@NotBlank
	private String tipoProcedimento;

	@NotBlank
	private String especialidade;

}

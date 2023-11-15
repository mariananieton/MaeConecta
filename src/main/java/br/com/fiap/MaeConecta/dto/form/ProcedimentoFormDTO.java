package br.com.fiap.MaeConecta.dto.form;

import br.com.fiap.MaeConecta.model.Especialidade;
import br.com.fiap.MaeConecta.model.TipoProcedimento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoProcedimento tipoProcedimento;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;

}

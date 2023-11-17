package br.com.fiap.MaeConecta.dto.response;

import br.com.fiap.MaeConecta.model.Especialidade;
import br.com.fiap.MaeConecta.model.TipoProcedimento;
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
public class ProcedimentoResponseDTO {

	@NotNull
	private Long id;

	@NotNull
	private LocalDate dataProcedimento;

	@NotBlank
	private String tipoProcedimento;

	@NotBlank
	private String especialidade;

	public void setTipoProcedimento(TipoProcedimento tipoProcedimento) {
		this.tipoProcedimento = tipoProcedimento.getNome();
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade.getNome();
	}
}

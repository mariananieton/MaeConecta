package br.com.fiap.MaeConecta.model;

import jakarta.persistence.*;
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
@Entity(name = "T_MC_PROCEDIMENTO")
public class Procedimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROCEDIMENTO")
	private Long id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoProcedimento tipoProcedimento;

	@NotNull
	@Column(name = "DT_PROCEDIMENTO")
	private LocalDate dataProcedimento;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;

	//TODO relacionamento
	// private Usuario usuario;

	//TODO relacionamento
	// private OcorrenciaGestacional ocorrenciaGestacional;

}

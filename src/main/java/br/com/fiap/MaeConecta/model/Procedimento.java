package br.com.fiap.MaeConecta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_MC_PROCEDIMENTOS")
public class Procedimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROCEDIMENTO")
	private Long id;

	@NotNull
	@Column(name = "DT_PROCEDIMENTO")
	private LocalDate dataProcedimento;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "DS_TIPO_PROCEDIMENTO")
	private TipoProcedimento tipoProcedimento;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "DS_ESPECIALIDADE")
	private Especialidade especialidade;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@OneToMany(mappedBy = "procedimento", cascade = CascadeType.ALL)
	private List<OcorrenciaGestacional> ocorrenciaGestacional;

}

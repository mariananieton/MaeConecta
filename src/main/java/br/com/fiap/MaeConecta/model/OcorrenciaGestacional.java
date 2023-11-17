package br.com.fiap.MaeConecta.model;

import jakarta.persistence.*;
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
@Entity(name = "T_MC_OCORRENCIAS")
public class OcorrenciaGestacional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OCORRENCIA")
	private Long id;

	@NotBlank
	@Size(min = 3)
	@Column(name = "DS_TITULO")
	private String titulo;

	@NotNull
	@Column(name = "DT_OCORRENCIA")
	private LocalDate dataOcorrencia;

	@NotBlank
	@Size(min = 3, max = 200)
	@Column(name = "DS_OCORRENCIA")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "ID_PROCEDIMENTO")
	private Procedimento procedimento;

}

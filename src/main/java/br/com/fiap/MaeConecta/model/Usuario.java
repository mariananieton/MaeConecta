package br.com.fiap.MaeConecta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
@Entity(name = "T_MC_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long id;

	@NotBlank
	@Size(min = 3, max = 200)
	@Column(name = "NM_USUARIO")
	private String nome;

	@NotNull
	@Positive
	@Column(name = "NR_IDADE")
	private Integer idade;

	@NotBlank
	@Column(name = "DS_CPF")
	private String cpf;

	@NotNull
	@Positive
	@Column(name = "NR_SEMANAS")
	private Integer semanasGestacao;

	@NotNull
	@Column(name = "DT_CADASTRO")
	private LocalDate dataCadastro;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoSanguineo tipoSanguineo;

	@ManyToOne(cascade = CascadeType.ALL)
	private Login login;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<ContatoEmergencia> contatosEmergencia;

	//TODO relacionamento
	// private List<Procedimento> procedimentos;

	//TODO relacionamento
	// private List<OcorrenciaGestacional> ocorrenciasGestacionais;
}

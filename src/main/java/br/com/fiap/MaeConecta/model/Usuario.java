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
	@Column(name = "DT_NASCIMENTO")
	private LocalDate dataNascimento;

	@NotNull
	@Column(name = "DT_CADASTRO")
	private LocalDate dataCadastro;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "DS_TIPO_SANGUINEO")
	private TipoSanguineo tipoSanguineo;

	@NotNull
	@Positive
	@Column(name = "DS_SEMANAS")
	private Integer semanasGestacao;

	@ManyToOne(cascade = CascadeType.ALL)
	private Login login;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<ContatoEmergencia> contatosEmergencia;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Procedimento> procedimentos;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<OcorrenciaGestacional> ocorrenciasGestacionais;
}

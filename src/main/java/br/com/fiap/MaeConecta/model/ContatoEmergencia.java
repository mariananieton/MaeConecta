package br.com.fiap.MaeConecta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "T_MC_CONTATOS")
public class ContatoEmergencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTATO")
	private Long id;

	@NotBlank
	@Size(min = 3, max = 200)
	@Column(name = "NM_CONTATO")
	private String nome;

	@NotBlank
	@Column(name = "DS_TELEFONE")
	private String telefone;

	@NotBlank
	@Size(min = 3, max = 100)
	@Column(name = "DS_RELACIONAMENTO")
	private String relacionamento;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

}

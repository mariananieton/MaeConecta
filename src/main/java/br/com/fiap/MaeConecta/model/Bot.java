package br.com.fiap.MaeConecta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_MC_BOT")
public class Bot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BOT")
	private Long id;

	@Column(name = "DS_NOME_BOT")
	private String nome;

	@Column(name = "DS_VERSAO")
	private String versao;

	@OneToOne(mappedBy = "bot", cascade = CascadeType.ALL)
	private Interacao interacao;

}
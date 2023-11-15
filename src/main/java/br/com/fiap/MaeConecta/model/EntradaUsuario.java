package br.com.fiap.MaeConecta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_MC_ENTRADA_USUARIO")
public class EntradaUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MENSAGEM_USUARIO")
	private long id;

	@Column(name = "DS_MENSAGEM")
	private String pergunta;

	@Column(name = "DT_ENVIO")
	private LocalDate dataEnvio;

	@ManyToOne
	@JoinColumn(name = "ID_INTERACAO")
	private Interacao interacao;

}
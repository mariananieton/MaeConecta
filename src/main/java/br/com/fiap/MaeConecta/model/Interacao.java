package br.com.fiap.MaeConecta.model;

import jakarta.persistence.*;
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
@Entity(name = "T_MC_INTERACAO")
public class Interacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_INTERACAO")
	private Long id;

	@Column(name = "ID_CONTEXTO")
	private Long idContexto;

	@Column(name = "DS_ASSUNTO")
	private String assunto;

	@Column(name = "DT_INTERACAO")
	private LocalDate dataInteracao;

	@ManyToOne
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "ID_BOT")
	private Bot bot;

	@OneToMany(mappedBy = "interacao")
	private List<RespostaBot> respostas;

	@OneToMany(mappedBy = "interacao")
	private List<EntradaUsuario> perguntas;

}

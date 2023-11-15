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
@Entity(name = "T_MC_RESPOSTA_BOT")
public class RespostaBot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESPOSTA_BOT")
	private long id;

	@Column(name = "DS_MENSAGEM")
	private String resposta;

	@Column(name = "DT_RESPOSTA")
	private LocalDate dataResposta;

	@ManyToOne
	@JoinColumn(name = "ID_INTERACAO")
	private Interacao interacao;

}

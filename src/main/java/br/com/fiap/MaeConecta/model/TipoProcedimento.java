package br.com.fiap.MaeConecta.model;

public enum TipoProcedimento {

	CONSULTA("Consulta"),
	EXAME("Exame");

	private final String nome;

	TipoProcedimento(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}

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

	public static TipoProcedimento fromString(String nome) {
		for (TipoProcedimento tipoProcedimento : TipoProcedimento.values()) {
			if (tipoProcedimento.nome.equalsIgnoreCase(nome)) {
				return tipoProcedimento;
			}
		}
		throw new IllegalArgumentException("Tipo de procedimento inválido: " + nome);
	}
}

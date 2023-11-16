package br.com.fiap.MaeConecta.model;

public enum TipoSanguineo {
	A_POSITIVO("A+"),
	B_POSITIVO("B+"),
	AB_POSITIVO("AB+"),
	O_POSITIVO("O+"),
	A_NEGATIVO("A-"),
	B_NEGATIVO("B-"),
	AB_NEGATIVO("AB-"),
	O_NEGATIVO("O-");

	private final String nome;

	TipoSanguineo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public static TipoSanguineo fromString(String nome) {
		for (TipoSanguineo tipoSanguineo : TipoSanguineo.values()) {
			if (tipoSanguineo.nome.equalsIgnoreCase(nome)) {
				return tipoSanguineo;
			}
		}
		throw new IllegalArgumentException("Tipo sanguíneo inválido: " + nome);
	}
}


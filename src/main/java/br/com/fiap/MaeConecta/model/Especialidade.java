package br.com.fiap.MaeConecta.model;

public enum Especialidade {
	OBSTETRICIA("Obstetrícia", "Especializada no acompanhamento da gravidez e parto"),
	GINECOLOGIA("Ginecologia", "Trata da saúde do sistema reprodutivo feminino"),
	PEDIATRIA("Pediatria", "Cuida da saúde das crianças, desde o nascimento até a adolescência"),
	NEONATOLOGIA("Neonatologia", "Especializada no cuidado de recém-nascidos"),
	ENFERMAGEM_OBSTETRICA("Enfermagem Obstétrica", "Atua no cuidado de gestantes, parturientes e puérperas"),
	ULTRASSONOGRAFIA("Ultrassonografia", "Utilizada para monitorar o desenvolvimento fetal durante a gravidez"),
	AMNIOSCOPIA("Amnioscopia", "Exame para avaliar o líquido amniótico que envolve o feto"),
	CARDIOTOCOGRAFIA("Cardiotocografia", "Monitoramento dos batimentos cardíacos do feto durante a gravidez"),
	MORFOLOGICO("Ultrassom Morfológico", "Avaliação detalhada da anatomia fetal"),
	EXAMES_DE_SANGUE("Exames de Sangue", "Incluindo hemograma, glicemia, entre outros para monitorar a saúde materna e fetal"),
	GENETICA("Genética", "Avaliação genética para identificar possíveis anomalias cromossômicas"),
	TOCOGRAFIA("Tocografia", "Registro das contrações uterinas durante o trabalho de parto"),
	HORMONIOS("Dosagem de Hormônios", "Monitoramento dos níveis hormonais durante a gravidez"),
	DIABETOLOGIA_GESTACIONAL("Diabetologia Gestacional", "Tratamento de diabetes que se desenvolve durante a gravidez"),
	FISIOTERAPIA_OBSTETRICA("Fisioterapia Obstétrica", "Atua na prevenção e tratamento de disfunções musculoesqueléticas durante a gravidez"),
	PSICOLOGIA_PERINATAL("Psicologia Perinatal", "Apoio psicológico durante a gestação e pós-parto");

	private final String nome;
	private final String descricao;

	Especialidade(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}


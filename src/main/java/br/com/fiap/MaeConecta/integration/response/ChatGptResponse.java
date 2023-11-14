package br.com.fiap.MaeConecta.integration.response;

import java.util.List;
import java.util.StringJoiner;

public class ChatGptResponse {

	private String model;
	private List<Choice> choices;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", ChatGptResponse.class.getSimpleName() + "[", "]")
				.add("model='" + model + "'")
				.add("choices=" + choices)
				.toString();
	}
}

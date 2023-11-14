package br.com.fiap.MaeConecta.integration.request;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ChatGptRequest {

	private String model;
	private List<Message> messages;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void addMessage(Message message) {
		if (this.messages == null) {
			this.messages = new ArrayList<>();
		}
		this.messages.add(message);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", ChatGptRequest.class.getSimpleName() + "[", "]")
				.add("model='" + model + "'")
				.add("messages=" + messages)
				.toString();
	}
}

package br.com.fiap.MaeConecta.integration.request;

import java.util.StringJoiner;

public class Message {

	private String role;
	private String content;

	public Message() {
	}

	public Message(String role, String content) {
		this.role = role;
		this.content = content;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Message.class.getSimpleName() + "[", "]")
				.add("role='" + role + "'")
				.add("content='" + content + "'")
				.toString();
	}
}

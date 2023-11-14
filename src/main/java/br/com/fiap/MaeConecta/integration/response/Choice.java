package br.com.fiap.MaeConecta.integration.response;


import br.com.fiap.MaeConecta.integration.request.Message;

import java.util.StringJoiner;

public class Choice {

	private Integer index;
	private Message message;
	private String finish_reason;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getFinish_reason() {
		return finish_reason;
	}

	public void setFinish_reason(String finish_reason) {
		this.finish_reason = finish_reason;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Choice.class.getSimpleName() + "[", "]")
				.add("index=" + index)
				.add("message=" + message)
				.add("finish_reason='" + finish_reason + "'")
				.toString();
	}
}

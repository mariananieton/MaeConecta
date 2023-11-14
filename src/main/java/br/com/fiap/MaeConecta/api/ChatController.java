package br.com.fiap.MaeConecta.api;

import br.com.fiap.MaeConecta.integration.ChatGpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

	@Autowired
	ChatGpt chatService;

	@PostMapping
	public String sendMessage(@RequestBody String message) {
		return chatService.sendMessage(message);
	}
}

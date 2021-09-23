package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.dto.Message;
import com.github.diegopacheco.sandboxspring.dto.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ChatController {

	@GetMapping("/greeting")
	public String greetings(){
		return "Hello from Spring Boot Websockets app";
	}

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(Message message){
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		return new OutputMessage(message.getFrom(), message.getText(), time);
	}

}


package com.listeners.consumers;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listeners.constantes.RabbitMQConstantes;
import com.listeners.dto.LogoutDTO;


@Component
public class LogoutConsumer {
	
//	ao startar nosso consumidor, sera criado um canal de comunicacao com rabbit, que vai ficar ouvindo  e aguardando mensagens
	@RabbitListener(queues = RabbitMQConstantes.FILA_LOGOUT)
	private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException, IllegalArgumentException {
		LogoutDTO logoutDTO = new ObjectMapper().readValue(mensagem, LogoutDTO.class);
		System.out.println("------------LOGOUT--------------------");
		System.out.println(logoutDTO.getId());
		System.out.println("---------------------------------");
		
//		throw new IllegalArgumentException("Argumento Inválido");
		
	}
}

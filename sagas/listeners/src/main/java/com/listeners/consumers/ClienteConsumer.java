package com.listeners.consumers;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listeners.constantes.RabbitMQConstantes;
import com.listeners.dto.ClienteDTO;


@Component
public class ClienteConsumer {
	
//	ao startar nosso consumidor, sera criado um canal de comunicacao com rabbit, que vai ficar ouvindo  e aguardando mensagens
	@RabbitListener(queues = RabbitMQConstantes.FILA_CLIENTE)
	private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException, IllegalArgumentException {
		ClienteDTO cliDto = new ObjectMapper().readValue(mensagem, ClienteDTO.class);
		System.out.println("------------CLIENTE--------------------");
		System.out.println(cliDto.id);
		System.out.println(cliDto.email);
		System.out.println(cliDto.nome);
		System.out.println(cliDto.sobrenome);
		System.out.println("---------------------------------");
		
//		throw new IllegalArgumentException("Argumento Inválido");
		
	}
}

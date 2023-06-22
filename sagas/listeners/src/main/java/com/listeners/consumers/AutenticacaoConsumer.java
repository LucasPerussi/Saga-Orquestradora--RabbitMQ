package com.listeners.consumers;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listeners.constantes.RabbitMQConstantes;
import com.listeners.dto.AutenticacaoDTO;


@Component
public class AutenticacaoConsumer {
	
//	ao startar nosso consumidor, sera criado um canal de comunicacao com rabbit, que vai ficar ouvindo  e aguardando mensagens
	@RabbitListener(queues = RabbitMQConstantes.FILA_AUTENTICACAO)
	private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException, IllegalArgumentException {
		AutenticacaoDTO autenticacaoDTO = new ObjectMapper().readValue(mensagem, AutenticacaoDTO.class);
		System.out.println("------------AUTENTICACAO--------------------");
		System.out.println(autenticacaoDTO.email);
		System.out.println(autenticacaoDTO.senha);
		System.out.println("---------------------------------");
		
//		throw new IllegalArgumentException("Argumento Inválido");
		
	}
}

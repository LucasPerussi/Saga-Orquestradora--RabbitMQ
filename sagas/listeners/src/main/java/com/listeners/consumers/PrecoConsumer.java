package com.listeners.consumers;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listeners.constantes.RabbitMQConstantes;
import com.listeners.dto.precoDTO;


@Component
public class PrecoConsumer {
	
//	ao startar nosso consumidor, sera criado um canal de comunicacao com rabbit, que vai ficar ouvindo  e aguardando mensagens
	@RabbitListener(queues = RabbitMQConstantes.FILA_PRECO)
	private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException, IllegalArgumentException {
		precoDTO precoDTO = new ObjectMapper().readValue(mensagem, precoDTO.class);
		System.out.println("------------PRECO--------------------");
		System.out.println(precoDTO.codigoProduto);
		System.out.println(precoDTO.preco);
		System.out.println("---------------------------------");
		
//		throw new IllegalArgumentException("Argumento Inválido");
		
	}
}

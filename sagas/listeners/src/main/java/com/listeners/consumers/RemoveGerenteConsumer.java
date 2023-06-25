
package com.listeners.consumers;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listeners.constantes.RabbitMQConstantes;
import com.listeners.dto.RemoveGerente;


@Component
public class RemoveGerenteConsumer {
	
//	ao startar nosso consumidor, sera criado um canal de comunicacao com rabbit, que vai ficar ouvindo  e aguardando mensagens
	@RabbitListener(queues = RabbitMQConstantes.FILA_REMOCAO_GERENTE)
	private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException, IllegalArgumentException {
		RemoveGerente removeGerente = new ObjectMapper().readValue(mensagem, RemoveGerente.class);
		System.out.println("------------REMOVE GERENTE--------------");
		System.out.println(removeGerente.getId());	
		System.out.println("---------------------------------");
		
//		throw new IllegalArgumentException("Argumento Inválido");
		
	}
}

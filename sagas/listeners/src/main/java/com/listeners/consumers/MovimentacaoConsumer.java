package com.listeners.consumers;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listeners.constantes.RabbitMQConstantes;
import com.listeners.dto.MovimentacaoDTO;


@Component
public class MovimentacaoConsumer {
	
//	ao startar nosso consumidor, sera criado um canal de comunicacao com rabbit, que vai ficar ouvindo  e aguardando mensagens
	@RabbitListener(queues = RabbitMQConstantes.FILA_MOVIMENTACAO)
	private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException, IllegalArgumentException {
		MovimentacaoDTO movimentacaoDTO = new ObjectMapper().readValue(mensagem, MovimentacaoDTO.class);
		System.out.println("------------Movimentacao--------------------");
		System.out.println(movimentacaoDTO.id);
		System.out.println(movimentacaoDTO.idOrigem);
		System.out.println(movimentacaoDTO.idDestino);
		System.out.println("---------------------------------");
		
//		throw new IllegalArgumentException("Argumento Inválido");
		
	}
}
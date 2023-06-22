package com.listeners.consumers;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listeners.constantes.RabbitMQConstantes;
import com.listeners.dto.ContaDTO;
import com.listeners.dto.MovimentacaoDTO;


@Component
public class ContaConsumer {
	
//	ao startar nosso consumidor, sera criado um canal de comunicacao com rabbit, que vai ficar ouvindo  e aguardando mensagens
	@RabbitListener(queues = RabbitMQConstantes.FILA_CONTA)
	private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException, IllegalArgumentException {
		ContaDTO contaDTO = new ObjectMapper().readValue(mensagem, ContaDTO.class);
//		MovimentacaoDTO movimentacoes = new ObjectMapper().readValue(mensagem, MovimentacaoDTO.class);
		System.out.println("------------CONTA--------------------");
		System.out.println(contaDTO.id);
		System.out.println(contaDTO.clienteId);
		System.out.println(contaDTO.gerenteId);
		System.out.println(contaDTO.numero);
		System.out.println(contaDTO.saldo);
		System.out.println(contaDTO.limite);
		System.out.println(contaDTO.dataCriacao);
//		System.out.println(contaDTO.movimentacoes);
		if (contaDTO.movimentacoes != null) {
		    	for (MovimentacaoDTO movimentacao : contaDTO.movimentacoes) {
				    System.out.println("------------MOVIMENTAÇÃO-----------------");
				    System.out.println(movimentacao.id);
				    System.out.println(movimentacao.data);
				    System.out.println(movimentacao.tipo);
				    System.out.println(movimentacao.idOrigem);
				    System.out.println(movimentacao.idDestino);
				    System.out.println("----------------------------------------");
				}
		}else {
				MovimentacaoDTO movimentacao = (MovimentacaoDTO) contaDTO.movimentacoes;
			 	System.out.println("------------MOVIMENTAÇÃO-----------------");
			    System.out.println(movimentacao.id);
			    System.out.println(movimentacao.data);
			    System.out.println(movimentacao.tipo);
			    System.out.println(movimentacao.idOrigem);
			    System.out.println(movimentacao.idDestino);
			    System.out.println("----------------------------------------");
		}
		
		System.out.println("---------------------------------");
		
//		throw new IllegalArgumentException("Argumento Inválido");
		
	}
}

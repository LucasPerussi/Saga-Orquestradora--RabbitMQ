package com.listeners.consumers;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listeners.constantes.RabbitMQConstantes;
import com.listeners.dto.ClienteDTO;


@Component
public class AutoCadastroConsumer {
	
//	ao startar nosso consumidor, sera criado um canal de comunicacao com rabbit, que vai ficar ouvindo  e aguardando mensagens
	@RabbitListener(queues = RabbitMQConstantes.FILA_AUTO_CADASTRO)
	private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException, IllegalArgumentException {
		ClienteDTO cliDto = new ObjectMapper().readValue(mensagem, ClienteDTO.class);
		System.out.println("------------AUTO CADASTRO--------------------");
		System.out.println(cliDto.getCpf());
		System.out.println(cliDto.getEmail());
		System.out.println(cliDto.getNome());
		System.out.println(cliDto.getSalario());
		System.out.println(cliDto.getTelefone());
		System.out.println(cliDto.getRua());
		System.out.println(cliDto.getLogradouro());
		System.out.println(cliDto.getNumero());
		System.out.println(cliDto.getComplemento());
		System.out.println(cliDto.getCep());
		System.out.println(cliDto.getCidade());
		System.out.println(cliDto.getEstado());
		System.out.println("---------------------------------");
		
//		throw new IllegalArgumentException("Argumento Inválido");
		
	 
	}
}

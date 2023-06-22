package com.sagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagas.constantes.RabbitMQConstantes;
import com.sagas.dto.ClienteDTO;
import com.sagas.dto.precoDTO;
import com.sagas.service.RabbitMQService;

@RestController
@RequestMapping(value = "cliente")
public class ClienteController {
	

	@Autowired
	RabbitMQService rabbitMQService;
	
//	envia mensagem para a fila
	@PutMapping
	private ResponseEntity novoCliente(@RequestBody ClienteDTO clienteDTO) {
		System.out.println(clienteDTO.nome);
		this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_CLIENTE, clienteDTO);
		return new ResponseEntity(HttpStatus.OK);
	}

}


package com.producers.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producers.dto.ClienteDTO;
import com.producers.service.RabbitMQService;
import com.producers.uteis.RabbitMQConstantes;
import com.producers.uteis.CustomResponse;

@RestController
@RequestMapping(value = "cliente")
public class ClienteController {
	

	@Autowired
	RabbitMQService rabbitMQService;
	
//	envia mensagem para a fila
	@PutMapping
	private ResponseEntity<?> novoCliente(@RequestBody ClienteDTO clienteDTO) {
		System.out.println(clienteDTO.getNome());
		this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_CLIENTE, clienteDTO);
//		return new ResponseEntity<>(HttpStatus.OK);
//		String mensagem = "Mensagem adicional";
//		return ResponseEntity.ok(mensagem);
		CustomResponse response = new CustomResponse(HttpStatus.OK, "Sucesso!");
		return ResponseEntity.ok(response);
	}
	
	
	
	

}


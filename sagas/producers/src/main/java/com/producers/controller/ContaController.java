package com.producers.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producers.constantes.RabbitMQConstantes;
import com.producers.dto.ContaDTO;
import com.producers.service.RabbitMQService;
@RestController
@RequestMapping(value = "conta")
public class ContaController {
	

	@Autowired
	RabbitMQService rabbitMQService;
	
//	envia mensagem para a fila
	@PutMapping
	private ResponseEntity<?> novaConta(@RequestBody ContaDTO contaDTO) {
//		System.out.println(contaDTO);
		this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_CONTA, contaDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}


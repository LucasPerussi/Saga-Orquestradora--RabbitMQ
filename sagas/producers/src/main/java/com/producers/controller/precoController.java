package com.producers.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producers.constantes.RabbitMQConstantes;
import com.producers.dto.precoDTO;
import com.producers.service.RabbitMQService;

@RestController
@RequestMapping(value = "preco")
public class precoController {
	

	@Autowired
	RabbitMQService rabbitMQService;
	
//	envia mensagem para a fila
	@PutMapping
	private ResponseEntity<?> alterarPreco(@RequestBody precoDTO precoDTO) {
		System.out.println(precoDTO.codigoProduto);
		this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_PRECO, precoDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

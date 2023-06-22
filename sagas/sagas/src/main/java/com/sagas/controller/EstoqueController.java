package com.sagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagas.constantes.RabbitMQConstantes;
import com.sagas.dto.EstoqueDTO;
import com.sagas.service.RabbitMQService;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {
	
	
	@Autowired
	RabbitMQService rabbitMQService;
	
	
//	envia a mensagem para a fila
	@PutMapping
	private ResponseEntity alterarEstoque(@RequestBody EstoqueDTO estoqueDTO) {
		System.out.println(estoqueDTO.codigoProduto);
		this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoqueDTO);
		return new ResponseEntity(HttpStatus.OK);
		
	}

}

package com.producers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producers.dto.ClienteDTO;
import com.producers.service.RabbitMQService;
import com.producers.uteis.CustomResponse;
import com.producers.uteis.RabbitMQConstantes;
@RestController
@RequestMapping(value = "auto-cadastro")
public class AutoCadastroController {
	

	@Autowired
	RabbitMQService rabbitMQService;
	
//	envia mensagem para a fila
	@PostMapping
	private ResponseEntity<?> novaConta(@RequestBody ClienteDTO clienteDTO) {
//		ESPERA UM JSON IGUAL A CONTA
		this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_AUTO_CADASTRO, clienteDTO);
		CustomResponse response = new CustomResponse(HttpStatus.OK, "Sucesso!");
		return ResponseEntity.ok(response);
	}

}


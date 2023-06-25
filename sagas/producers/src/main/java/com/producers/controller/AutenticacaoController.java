package com.producers.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producers.dto.AutenticacaoDTO;
import com.producers.service.RabbitMQService;
import com.producers.uteis.CustomResponse;
import com.producers.uteis.RabbitMQConstantes;

@RestController
@RequestMapping(value = "autenticacao")
public class AutenticacaoController {
	

	@Autowired
	RabbitMQService rabbitMQService;
	
//	envia mensagem para a fila
	@PostMapping
	private ResponseEntity<?> Autenticacao(@RequestBody AutenticacaoDTO autenticacaoDTO) {
		System.out.println(autenticacaoDTO.getEmail());
		this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_AUTENTICACAO, autenticacaoDTO);
		CustomResponse response = new CustomResponse(HttpStatus.OK, "Sucesso!");
		return ResponseEntity.ok(response);
	}

}


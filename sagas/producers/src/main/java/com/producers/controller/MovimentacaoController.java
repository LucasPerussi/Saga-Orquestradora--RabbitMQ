package com.producers.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producers.dto.MovimentacaoDTO;
import com.producers.service.RabbitMQService;
import com.producers.uteis.CustomResponse;
import com.producers.uteis.RabbitMQConstantes;

@RestController
@RequestMapping(value = "transacao")
public class MovimentacaoController {
	

	@Autowired
	RabbitMQService rabbitMQService;
	
//	envia mensagem para a fila
	@PostMapping
	private ResponseEntity<?> novoGerente(@RequestBody MovimentacaoDTO movimentacaoDTO) {
//		System.out.println(gerenteDTO.codigoProduto);
		this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_MOVIMENTACAO, movimentacaoDTO);
		CustomResponse response = new CustomResponse(HttpStatus.OK, "Sucesso!");
		return ResponseEntity.ok(response);
	}

}

package com.producers.connection;
import jakarta.annotation.PostConstruct;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.stereotype.Component;

import com.producers.uteis.RabbitMQConstantes;


/*component diz que essa classe vai ser autogerenciada pelo spring */

@Component
public class RabbitMQConnection {
	private static final String NOME_EXCHANGE = "amq.direct";
	private AmqpAdmin amqpAdmin;
	
	public RabbitMQConnection(AmqpAdmin ampqAdmin) {
		this.amqpAdmin = ampqAdmin;
	}

	private Queue fila(String nomeFila) {
		return new Queue(nomeFila, true, false, false);
	}
	
	private DirectExchange trocaDireta() {
		return new DirectExchange(NOME_EXCHANGE);
		
	}
	
	private Binding relacionamento(Queue fila, DirectExchange troca) {
		return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
	}
	
//	post construct faz o spring executar a funcao anotada ao subir o app
	
	@PostConstruct
	private void adiciona() {
		Queue filaCliente = this.fila(RabbitMQConstantes.FILA_CLIENTE);
		Queue filaConta = this.fila(RabbitMQConstantes.FILA_CONTA);
		Queue filaGerente = this.fila(RabbitMQConstantes.FILA_GERENTE);
		Queue filaAutenticacao = this.fila(RabbitMQConstantes.FILA_AUTENTICACAO);
		Queue filaMovimentacao = this.fila(RabbitMQConstantes.FILA_MOVIMENTACAO);
		Queue filaLogout = this.fila(RabbitMQConstantes.FILA_LOGOUT);
		Queue filaRemoveGerente = this.fila(RabbitMQConstantes.FILA_REMOCAO_GERENTE);
		Queue filaAutoCadastro = this.fila(RabbitMQConstantes.FILA_AUTO_CADASTRO);
		
		DirectExchange troca =  this.trocaDireta();
		

		Binding ligacaoCliente = this.relacionamento(filaCliente, troca);
		Binding ligacaoConta = this.relacionamento(filaConta, troca);
		Binding ligacaoGerente = this.relacionamento(filaGerente, troca);
		Binding ligacaoAutenticacao = this.relacionamento(filaAutenticacao, troca);
		Binding ligacaoMovimentacao = this.relacionamento(filaMovimentacao, troca);
		Binding ligacaoLogout = this.relacionamento(filaLogout, troca);
		Binding ligacaoRemoveGerente = this.relacionamento(filaRemoveGerente, troca);
		Binding ligacaoAutoCadastro = this.relacionamento(filaAutoCadastro, troca);

		this.amqpAdmin.declareQueue(filaCliente);
		this.amqpAdmin.declareQueue(filaConta);
		this.amqpAdmin.declareQueue(filaGerente);
		this.amqpAdmin.declareQueue(filaAutenticacao);
		this.amqpAdmin.declareQueue(filaMovimentacao);
		this.amqpAdmin.declareQueue(filaLogout);
		this.amqpAdmin.declareQueue(filaRemoveGerente);
		this.amqpAdmin.declareQueue(filaAutoCadastro);
		
		this.amqpAdmin.declareExchange(troca);

		this.amqpAdmin.declareBinding(ligacaoCliente);
		this.amqpAdmin.declareBinding(ligacaoConta);
		this.amqpAdmin.declareBinding(ligacaoGerente);
		this.amqpAdmin.declareBinding(ligacaoAutenticacao);
		this.amqpAdmin.declareBinding(ligacaoMovimentacao);
		this.amqpAdmin.declareBinding(ligacaoLogout);
		this.amqpAdmin.declareBinding(ligacaoRemoveGerente);
		this.amqpAdmin.declareBinding(ligacaoAutoCadastro);
	}
	
}
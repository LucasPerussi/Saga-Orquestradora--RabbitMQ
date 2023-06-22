package com.listeners.config;

import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.FatalExceptionStrategy;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.DirectRabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ErrorHandler;

import com.listeners.consumers.CustomErrorStrategy;
import com.rabbitmq.client.AMQP.Basic.Return;


@Configuration
public class RabbitMQConfig {
	
	@Bean
	public RabbitListenerContainerFactory<DirectMessageListenerContainer> rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
		DirectRabbitListenerContainerFactory factory = new DirectRabbitListenerContainerFactory();
		
		factory.setConnectionFactory(connectionFactory);
		factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
		factory.setPrefetchCount(4);
		factory.setErrorHandler(ErrorHandler());
		
		return factory;
	}

	@Bean
	public ErrorHandler ErrorHandler() {
		return new ConditionalRejectingErrorHandler(CustomErrorStrategy());
	}
	
	@Bean
	public FatalExceptionStrategy CustomErrorStrategy() {
		return new CustomErrorStrategy();
	}

}

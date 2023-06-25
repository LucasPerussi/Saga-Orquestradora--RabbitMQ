package com.producers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ProducersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducersApplication.class, args);
	}

}

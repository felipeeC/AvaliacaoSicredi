package com.sicredi.avaliacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("com.sicredi.avaliacao")
@ComponentScan("com.sicredi.avaliacao")
@EnableJpaRepositories("com.sicredi.avaliacao")
public class AvaliacaoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AvaliacaoApplication.class, args);
		System.out.println("olá spring");
	}

}

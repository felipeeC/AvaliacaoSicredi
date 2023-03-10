package com.sicredi.avaliacao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan("com.sicredi.avaliacao")
@ComponentScan("com.sicredi.avaliacao")
@EnableJpaRepositories("com.sicredi.avaliacao")
@EnableSwagger2
public class AvaliacaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoApplication.class, args);
	}
}

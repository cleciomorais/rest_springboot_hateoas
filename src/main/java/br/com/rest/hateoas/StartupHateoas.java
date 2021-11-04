package br.com.rest.hateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class StartupHateoas {
	
	public static void main(String[] args) {
		SpringApplication.run(StartupHateoas.class, args);
	}

}

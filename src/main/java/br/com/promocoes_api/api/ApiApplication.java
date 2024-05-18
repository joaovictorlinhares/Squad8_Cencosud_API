package br.com.promocoes_api.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(
	info = @Info(
		title = "Squad 8 - Cencosud", 
		version = "1", 
		description = "Está API é fruto do desafio proposto ao Squad 8 pelo Cencosud, com o objetivo de auxiliar Clientes e Funcionários a localizar promoções e seções, além de facilitar as compras e o gerenciamento dentro dos estabelecimentos do Cencosud."
	)
)

public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}

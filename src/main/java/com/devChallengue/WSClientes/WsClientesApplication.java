package com.devChallengue.WSClientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.devChallengue.WSClientes")
public class WsClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsClientesApplication.class, args);
		System.out.println("Hola mundo Spring");

	}
}

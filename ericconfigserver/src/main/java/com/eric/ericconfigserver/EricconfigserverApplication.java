package com.eric.ericconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EricconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EricconfigserverApplication.class, args);
	}

}

package com.shortthirdman.medihub.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MediHubConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediHubConfigServerApplication.class, args);
	}

}

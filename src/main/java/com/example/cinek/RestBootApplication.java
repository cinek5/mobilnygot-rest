package com.example.cinek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class RestBootApplication {

	public static void main(String[] args) {
		SetupDatabaseMain.StartDbTcpServer();
		SpringApplication.run(RestBootApplication.class, args);
	}
}

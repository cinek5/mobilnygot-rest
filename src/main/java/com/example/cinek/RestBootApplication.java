package com.example.cinek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class RestBootApplication {

	public static void main(String[] args) {
		SetupDatabaseMain.startDbTcpServer();
		SpringApplication.run(RestBootApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void prepareDb() {
		SetupDatabaseMain.insertData();
	}
}

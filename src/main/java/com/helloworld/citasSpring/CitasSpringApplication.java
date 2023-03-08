package com.helloworld.citasSpring;

import com.helloworld.citasSpring.infra.console.ConsoleReader;
import com.helloworld.citasSpring.repository.impl.CitaRepositoryMemory;
import com.helloworld.citasSpring.service.impl.CitaServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitasSpringApplication {
	private static Logger logger = LogManager.getLogger(CitasSpringApplication.class);
	public static void main(String[] args) {

		logger.info("Aplicacion arrancada");
		SpringApplication.run(CitasSpringApplication.class, args);

		//ConsoleReader consoleReader = new ConsoleReader(new CitaServiceImpl(new CitaRepositoryMemory()));
		//consoleReader.init();
	}

}

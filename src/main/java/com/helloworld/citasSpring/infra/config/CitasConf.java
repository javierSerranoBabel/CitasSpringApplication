package com.helloworld.citasSpring.infra.config;

import com.helloworld.citasSpring.infra.console.ConsoleReader;
import com.helloworld.citasSpring.repository.CitaRepository;
import com.helloworld.citasSpring.repository.impl.CitaRepositoryMemory;
import com.helloworld.citasSpring.service.CitaService;
import com.helloworld.citasSpring.service.impl.CitaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CitasConf {
    @Bean
    CitaRepository getCitaRepository(){
        return new CitaRepositoryMemory();
    }

    @Bean
    CitaService getCitaService(){
        return new CitaServiceImpl(getCitaRepository());
    }

    @Bean
    ConsoleReader getConsoleReader(){
        return new ConsoleReader(getCitaService());
    }
}

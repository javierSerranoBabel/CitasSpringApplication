package com.helloworld.citasSpring.service.impl;

import com.helloworld.citasSpring.CitasSpringApplication;
import com.helloworld.citasSpring.domain.Cita;
import com.helloworld.citasSpring.repository.CitaRepository;
import com.helloworld.citasSpring.service.CitaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    private static Logger logger = LogManager.getLogger(CitasSpringApplication.class);
    private CitaRepository citaRepositoryMemory;
    private CitaRepository citaRepositorySQL;


    //Se puede omitir el cuerpo
    public CitaServiceImpl(@Qualifier("SQL") CitaRepository citaRepositorySQL,@Qualifier("Memory") CitaRepository citaRepositoryMemory) {
        this.citaRepositoryMemory = citaRepositoryMemory;
        this.citaRepositorySQL = citaRepositorySQL;
    }

    // if tenemos conexion sql si no memory
    public void alta(Cita cita){
        logger.info("Dando una cita de alta");
        logger.debug("Cita: " + cita.toString());
        try{
            citaRepositoryMemory.alta(cita);
        }catch(Exception e){
            logger.error(e.getMessage());
        }


    }
    public void baja(int indice){
        citaRepositoryMemory.baja(indice);
    }
    public List<Cita> listar(){
        return citaRepositoryMemory.listar();
    }
}

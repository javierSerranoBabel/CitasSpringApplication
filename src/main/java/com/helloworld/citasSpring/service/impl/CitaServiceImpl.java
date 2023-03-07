package com.helloworld.citasSpring.service.impl;

import com.helloworld.citasSpring.domain.Cita;
import com.helloworld.citasSpring.repository.CitaRepository;
import com.helloworld.citasSpring.service.CitaService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    private CitaRepository citaRepositoryMemory;
    private CitaRepository citaRepositorySQL;


    //Se puede omitir el cuerpo
    public CitaServiceImpl(@Qualifier("SQL") CitaRepository citaRepositorySQL,@Qualifier("Memory") CitaRepository citaRepositoryMemory) {
        this.citaRepositoryMemory = citaRepositoryMemory;
        this.citaRepositorySQL = citaRepositorySQL;
    }

    // if tenemos conexion sql si no memory
    public void alta(Cita cita){
        citaRepositoryMemory.alta(cita);
    }
    public void baja(int indice){
        citaRepositoryMemory.baja(indice);
    }
    public List<Cita> listar(){
        return citaRepositoryMemory.listar();
    }
}

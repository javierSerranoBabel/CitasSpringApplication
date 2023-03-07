package com.helloworld.citasSpring.repository.impl;

import com.helloworld.citasSpring.domain.Cita;
import com.helloworld.citasSpring.repository.CitaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SQL")
public class CitaRepositorySQL implements CitaRepository {
    @Override
    public void alta(Cita cita) {

    }

    @Override
    public void baja(int index) {

    }

    @Override
    public List<Cita> listar() {
        return null;
    }
}

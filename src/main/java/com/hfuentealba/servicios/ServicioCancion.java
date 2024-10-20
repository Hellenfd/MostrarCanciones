package com.hfuentealba.servicios;

import java.util.List;

import com.hfuentealba.modelos.Cancion;
import com.hfuentealba.repositorios.RepositorioCancion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioCancion {
    @Autowired
    private final RepositorioCancion repositorioCancion;

    public ServicioCancion(RepositorioCancion repositorioCancion) {
        this.repositorioCancion = repositorioCancion;
    }

    public List<Cancion> obtenerTodasLasCanciones() {
        return this.repositorioCancion.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
        return this.repositorioCancion.findById(id).orElse(null);
    }
}


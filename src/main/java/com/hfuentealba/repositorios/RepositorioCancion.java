package com.hfuentealba.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hfuentealba.modelos.Cancion;

@Repository
public interface RepositorioCancion extends CrudRepository<Cancion, Long> {
    List<Cancion> findAll();
}
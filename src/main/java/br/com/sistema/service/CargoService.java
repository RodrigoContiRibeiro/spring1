package br.com.sistema.service;

import br.com.sistema.models.Cargo;

import java.util.List;

public interface CargoService {
    public List<Cargo> findAll();
    public boolean save(Cargo cargo);
}

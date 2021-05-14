package br.com.sistema.service;

import br.com.sistema.models.Cargo;

import java.util.List;

public interface CargoService {
    public List<Cargo> findAll();
    public Cargo findById(Long id);
    public void deleteById(Long id);
    public Cargo findByNome(String   nome);
    public String validarCargo(Cargo cargo);
    public boolean save(Cargo cargo);
}

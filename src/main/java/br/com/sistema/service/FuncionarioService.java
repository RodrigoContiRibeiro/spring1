package br.com.sistema.service;

import br.com.sistema.models.Funcionario;

import java.util.List;

public interface FuncionarioService {
    public List<Funcionario> findAll();

    public Funcionario findById(Long id);

}

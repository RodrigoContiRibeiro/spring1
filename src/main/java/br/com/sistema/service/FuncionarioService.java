package br.com.sistema.service;

import br.com.sistema.models.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {
    //Criando e nomeando métodos que serão usados na implementação dessa interface
    public List<Funcionario> findAll();
    public Optional<Funcionario> findById(Long id);
    public String findByEmail(String email);

    public Funcionario save(Funcionario funcionario);
    public void deleteById(Long id);
}

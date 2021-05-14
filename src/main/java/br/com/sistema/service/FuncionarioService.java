package br.com.sistema.service;

import br.com.sistema.models.Funcionario;

import java.util.List;

public interface FuncionarioService {
    //Criando e nomeando métodos que serão usados na implementação dessa interface
    public List<Funcionario> findAll();
    public Funcionario findById(Long id);
    public Funcionario findByEmail(String email);
    public Funcionario findByTelefone(String telefone);
    public boolean save(Funcionario funcionario);
    public void deleteById(Long id);
    public String validarFuncionario(Funcionario funcionario);

}

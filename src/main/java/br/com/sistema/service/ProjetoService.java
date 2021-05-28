package br.com.sistema.service;

import br.com.sistema.models.Funcionario;
import br.com.sistema.models.Projeto;

import java.util.List;

public interface ProjetoService {
    public List<Projeto> findAll();
    public Projeto findById(Long id);
    public Projeto findByNome(String nome);

    public boolean save(Projeto projeto);

    public String validarProjeto(Projeto projeto);
}

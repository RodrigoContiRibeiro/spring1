package br.com.sistema.service;

import br.com.sistema.models.Funcionario;
import br.com.sistema.repository.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    FuncionarioRepo funcionarioRepo;

    public List<Funcionario> findAll() {
        return funcionarioRepo.findAll();
    }

    public Funcionario findById(Long id) {
        return null;

    }

}

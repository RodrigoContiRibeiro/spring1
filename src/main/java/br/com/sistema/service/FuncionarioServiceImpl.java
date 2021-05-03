package br.com.sistema.service;

import br.com.sistema.models.Funcionario;
import br.com.sistema.repository.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    //Implementação da interface para criar uma camada de serviço

    //Acesso ao repositório
    @Autowired
    FuncionarioRepo funcionarioRepo;

    //Sobrescrevendo os métodos da interface
    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepo.findAll();
    }

    @Override
    public Optional<Funcionario> findById(Long id) {
        return funcionarioRepo.findById(id);
    }

    @Override
    public String findByEmail(String email) {
        return funcionarioRepo.findByEmail(email);
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepo.save(funcionario);
    }

    @Override
    public void deleteById(Long id) {
        funcionarioRepo.deleteById(id);
    }


}

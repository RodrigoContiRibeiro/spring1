package br.com.sistema.service;

import br.com.sistema.models.Funcionario;
import br.com.sistema.repository.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    FuncionarioRepo funcionarioRepo;

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepo.findAll();
    }

    @Override
    public Optional<Funcionario> findById(Long id) {
        return funcionarioRepo.findById(id);
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepo.save(funcionario);
    }


/*      @Override
        public Funcionario save(Funcionario funcionario){
        return funcionario;
    }*/

}

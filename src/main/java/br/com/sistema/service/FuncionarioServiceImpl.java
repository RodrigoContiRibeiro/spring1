package br.com.sistema.service;

import br.com.sistema.models.Funcionario;
import br.com.sistema.repository.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    //Implementação da interface para criar uma camada de serviço

    //Acesso ao repositório
    @Autowired
    FuncionarioRepo funcionarioRepo;

    //Sobrescrevendo os métodos da interface
    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepo.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    @Override
    public Funcionario findById(Long id) {
        return funcionarioRepo.findById(id).orElse(new Funcionario());
    }

    @Override
    public Funcionario findByEmail(String email) {
        return funcionarioRepo.findByEmail(email);
    }

    @Override
    public Funcionario findByTelefone(String telefone) {
        return funcionarioRepo.findByTelefone(telefone);
    }

    @Override
    public boolean save(Funcionario funcionario) {
        try {
            if (funcionario != null) {
                funcionarioRepo.save(funcionario);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void deleteById(Long id) {
        funcionarioRepo.deleteById(id);
    }

    @Override
    public String validarFuncionario(Funcionario funcionario) {
        ArrayList<String> erros = new ArrayList<>();
        String erro = "";
        if (funcionario.getId() != null) { //Editando
            //Checando se o valor do input foi alterado, se foi ele verifica se esse novo valor
            //existe no banco de dados
            //Não mexa magia
            if (!findById(funcionario.getId()).getEmail().equals(funcionario.getEmail())) {
                if (findByEmail(funcionario.getEmail()) != null) {
                    erros.add("Email Já Cadastrado");
                }
            }
            if (!findById(funcionario.getId()).getTelefone().equals(funcionario.getTelefone())) {
                if (findByTelefone(funcionario.getTelefone()) != null) {
                    erros.add("Telefone Já Cadastrado");
                }
            }
        } else { //Novo
            if (findByEmail(funcionario.getEmail()) != null) {
                erros.add("Email Já Cadastrado");
            }
            if (findByTelefone(funcionario.getTelefone()) != null) {
                erros.add("Telefone Já Cadastrado");
            }
        }
        erro = StringUtils.join(erros, ", ");
        return erro;
    }
}

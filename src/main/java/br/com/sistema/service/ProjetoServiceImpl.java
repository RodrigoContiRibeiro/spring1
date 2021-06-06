package br.com.sistema.service;

import br.com.sistema.models.Projeto;
import br.com.sistema.repository.FuncionarioRepo;
import br.com.sistema.repository.ProjetoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetoServiceImpl implements ProjetoService {
    @Autowired
    ProjetoRepo projetoRepo;

    @Autowired
    FuncionarioRepo funcionarioRepo;

    @Override
    public List<Projeto> findAll() {
        return projetoRepo.findAll();
    }

    @Override
    public Projeto findById(Long id) {
        return projetoRepo.findById(id).get();
    }

    @Override
    public Projeto findByNome(String nome) {
        return projetoRepo.findByNome(nome);
    }

    @Override
    public void deleteById(Long id) {
        projetoRepo.deleteById(id);
    }

    @Override
    public boolean save(Projeto projeto) {
        try {
            if (projeto != null) {
                projetoRepo.save(projeto);
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
    public String validarProjeto(Projeto projeto) {
        ArrayList<String> erros = new ArrayList<>();
        String erro = "";
        if (projeto.getId() != null) { //Editando
            if (!findById(projeto.getId()).getNome().equals(projeto.getNome())) {
                if (findByNome(projeto.getNome()) != null) {
                    erros.add("Nome já cadastrado Editando");
                }
            }
        } else {
            if (findByNome(projeto.getNome()) != null) {
                erros.add("Nome já cadastrado Criando");
            }
        }
        erro = StringUtils.join(erros, ", ");
        return erro;
    }


}

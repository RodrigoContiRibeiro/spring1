package br.com.sistema.controller;

import br.com.sistema.models.Projeto;
import br.com.sistema.service.FuncionarioServiceImpl;
import br.com.sistema.service.ProjetoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProjetoController {
    @Autowired
    ProjetoServiceImpl projetoService;

    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @GetMapping("/projeto/list")
    public String list(Model model) {
        model.addAttribute("projetos", projetoService.findAll());
        return "projeto/list";
    }

    @GetMapping("/projeto/funcionarios/{id}")
    public String funcs(Model model, @PathVariable long id){
        model.addAttribute("funcionarios", funcionarioService.findByProjeto(id));
        System.out.println(funcionarioService.findByProjeto(id));
        return "funcionario/list";
    }

    @GetMapping("/projeto/add")
    public String add(Model model){
        model.addAttribute("projeto", new Projeto());
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "projeto/add";
    }

}

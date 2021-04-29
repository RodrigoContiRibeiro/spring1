package br.com.sistema.controller;

import br.com.sistema.models.Funcionario;
import br.com.sistema.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {
    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @GetMapping("/funcionario/list")
    public String list(Model model) {
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "funcionario/list";
    }

    @GetMapping("/funcionario/add")
    public String add(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario/add";
    }

    @PostMapping("/funcionario/save")
    public String save(Funcionario funcionario) {
        funcionarioService.save(funcionario);
        return "redirect:/funcionario/list";
    }

    @GetMapping("/funcionario/view/{id}")
    public String viewFuncionario(Model model, @PathVariable long id){
        model.addAttribute("funcionario", funcionarioService.findById(id));
        return "funcionario/view";
    }
}

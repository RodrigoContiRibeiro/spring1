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
    //Acessando o service
    @Autowired
    FuncionarioServiceImpl funcionarioService;

    //Manejando um Get para /funcionario/list e enviando todos as linhas da tabela
    @GetMapping("/funcionario/list")
    public String list(Model model) {
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "funcionario/list";
    }

    //Manejando um Get para /funcionario/add e instanciando um Funcionario para depois ser postado
    @GetMapping("/funcionario/add")
    public String add(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario/add";
    }

    //Manejando um Post para /funcionario/save para salvar na tabela
    @PostMapping("/funcionario/save")
    public String save(Model model, Funcionario funcionario) {
        String erro = funcionarioService.validarFuncionario(funcionario);
        if (!erro.equals("")) {
            model.addAttribute("funcionario", funcionario);
            model.addAttribute("erro", true);
            model.addAttribute("erroMsg", erro);
            return "funcionario/add";
        }
        if (funcionarioService.save(funcionario)) {
            return "redirect:/funcionario/list";
        } else {
            System.out.println("Não Salvou");
            model.addAttribute("funcionario", funcionario);
            return "funcionario/add";
        }
    }

    @PostMapping("/funcionario/update")
    public String update(Model model, Funcionario funcionario) {
        String erro = funcionarioService.validarFuncionario(funcionario);
        if (!erro.equals("")) {
            model.addAttribute("funcionario", funcionario);
            model.addAttribute("erro", true);
            model.addAttribute("erroMsg", erro);
            return "funcionario/edit";
        }
        if (funcionarioService.save(funcionario)) {
            return "redirect:/funcionario/list";
        } else {
            model.addAttribute("funcionario", funcionario);
            return "funcionario/edit";
        }
    }

    //Manejando um Get para /funcionario/{id} com um parâmetro dinâmico e usando dele para fazer um query na tabela
    @GetMapping("/funcionario/view/{id}")
    public String view(Model model, @PathVariable long id) {
        model.addAttribute("funcionario", funcionarioService.findById(id));
        return "funcionario/view";
    }

    @GetMapping("/funcionario/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("funcionario", funcionarioService.findById(id));
        return "funcionario/edit";
    }

    @GetMapping("/funcionario/delete/{id}")
    public String delete(@PathVariable long id) {
        try {
            funcionarioService.deleteById(id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return "redirect:/funcionario/list";
    }
}

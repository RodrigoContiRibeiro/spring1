package br.com.sistema.controller;

import br.com.sistema.models.Projeto;
import br.com.sistema.service.FuncionarioServiceImpl;
import br.com.sistema.service.ProjetoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String add(Model model) {
        model.addAttribute("projeto", new Projeto());
        model.addAttribute("gerentes", funcionarioService.findGerentes());
        model.addAttribute("funcionarios", funcionarioService.findNotGerentes());
        return "projeto/add";
    }

    @GetMapping("/projeto/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("projeto", projetoService.findById(id));
        model.addAttribute("gerentes", funcionarioService.findGerentes());
        model.addAttribute("funcionarios", funcionarioService.findNotGerentes());
        return "projeto/edit";
    }

    @PostMapping("/projeto/save")
    public String save(Model model, Projeto projeto) {
        String erro = projetoService.validarProjeto(projeto);
        if (!erro.equals("")) {
            model.addAttribute("projeto", projeto);
            model.addAttribute("gerentes", funcionarioService.findGerentes());
            model.addAttribute("funcionarios", funcionarioService.findNotGerentes());
            model.addAttribute("erro", true);
            model.addAttribute("erroMsg", erro);
            return "projeto/add";
        }
        if (projetoService.save(projeto)) {
            return "redirect:/projeto/list";
        } else {
            System.out.println("Não Salvou");
            model.addAttribute("projeto", projeto);
            model.addAttribute("gerentes", funcionarioService.findGerentes());
            model.addAttribute("funcionarios", funcionarioService.findNotGerentes());
            return "projeto/add";
        }
    }

    @PostMapping("/projeto/update")
    public String update(Model model, Projeto projeto) {
        String erro = projetoService.validarProjeto(projeto);
        if (!erro.equals("")) {
            model.addAttribute("projeto", projeto);
            model.addAttribute("gerentes", funcionarioService.findGerentes());
            model.addAttribute("funcionarios", funcionarioService.findNotGerentes());
            model.addAttribute("erro", true);
            model.addAttribute("erroMsg", erro);
            return "projeto/edit";
        }
        if (projetoService.save(projeto)) {
            return "redirect:/projeto/list";
        } else {
            System.out.println("Não Salvou");
            model.addAttribute("projeto", projeto);
            model.addAttribute("gerentes", funcionarioService.findGerentes());
            model.addAttribute("funcionarios", funcionarioService.findNotGerentes());
            return "projeto/edit";
        }
    }

    @GetMapping("/projeto/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            projetoService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/projeto/list";
    }
}

package br.com.sistema.controller;

import br.com.sistema.models.Cargo;
import br.com.sistema.service.CargoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CargoController {
    @Autowired
    CargoServiceImpl cargoService;

    @GetMapping("/cargo/list")
    public String list(Model model) {
        model.addAttribute("cargos", cargoService.findAll());
        return "cargo/list";
    }

    @GetMapping("/cargo/add")
    public String add(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "cargo/add";
    }

    @PostMapping("/cargo/save")
    public String save(Model model, Cargo cargo) {
        String erro = cargoService.validarCargo(cargo);
        if (!erro.equals("")) {
            model.addAttribute("cargo", cargo);
            model.addAttribute("erro", true);
            model.addAttribute("erroMsg", erro);
            return "cargo/add";
        }
        if (cargoService.save(cargo)) {
            return "redirect:/cargo/list";
        } else {
            model.addAttribute("cargo", cargo);
            model.addAttribute("erro", true);
            model.addAttribute("erroMsg", "Erro ao Salvar");
            return "cargo/add";
        }
    }

    @PostMapping("/cargo/update")
    public String update(Model model, Cargo cargo) {
        String erro = cargoService.validarCargo(cargo);
        if (!erro.equals("")) {
            model.addAttribute("cargo", cargo);
            model.addAttribute("erro", true);
            model.addAttribute("erroMsg", erro);
            return "cargo/edit";
        }
        if (cargoService.save(cargo)) {
            return "redirect:/cargo/list";
        } else {
            model.addAttribute("cargo", cargo);
            model.addAttribute("erro", true);
            model.addAttribute("erroMsg", "Erro ao Salvar");
            return "cargo/edit";
        }
    }

    @GetMapping("/cargo/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("cargo", cargoService.findById(id));
        return "/cargo/edit";
    }

    @GetMapping("/cargo/delete/{id}")
    public String delete(@PathVariable long id) {
        cargoService.deleteById(id);
        return "redirect:/cargo/list";
    }
}

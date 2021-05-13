package br.com.sistema.controller;

import br.com.sistema.models.Cargo;
import br.com.sistema.service.CargoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String save(Model model, /*String nome*/ Cargo cargo) {
        cargoService.save(cargo);
        model.addAttribute("cargo", cargo);
        return "redirect:/funcionario/list";
    }
}

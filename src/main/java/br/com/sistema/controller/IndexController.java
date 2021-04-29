package br.com.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //Mapeamento para uma requisição Get na raiz
    @GetMapping("/")
    public String index() {
        return "index";
    }
}

package br.univille.novostalentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.novostalentos.repository.CidadeRepository;

@Controller
@RequestMapping("/cidades")
public class CidadeController {
    
    @Autowired
    private CidadeRepository repositorio;

    @GetMapping
    public ModelAndView index(){

        return new ModelAndView("cidade/index");
    }
}

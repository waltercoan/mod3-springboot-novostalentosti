package br.univille.novostalentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/home","/"})
public class HomeController {

    private int contador;

    @GetMapping
    //@ResponseBody
    public ModelAndView index(){
        //return "eu nao acredito... java é lindo ❤";
        contador++;
        return new ModelAndView("home/index","valor",contador);
    }
}

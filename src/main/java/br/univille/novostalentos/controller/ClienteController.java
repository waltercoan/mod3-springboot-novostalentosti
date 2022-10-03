package br.univille.novostalentos.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.univille.novostalentos.entity.Cliente;
import br.univille.novostalentos.repository.ClienteRepository;
import br.univille.novostalentos.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){

        
        
        var listaClientes = service.getAll();

        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }
}

package br.univille.novostalentos.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.univille.novostalentos.entity.Cliente;
import br.univille.novostalentos.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    //esse codigo será removido - controlador nao deve chamar repositorio
    @Autowired
    private ClienteRepository repositorio;

    @GetMapping
    public ModelAndView index(){

        /*ArrayList<Cliente> listaClientes = 
            new ArrayList<>();
        
        var cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNome("Zezinho");
        cliente1.setEndereco("Rua lalalala 100");
        cliente1.setSexo("Masculino");

        listaClientes.add(cliente1);

        var cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNome("Luizinho");
        cliente2.setEndereco("Rua lelelelel 200");
        cliente2.setSexo("Masculino");

        listaClientes.add(cliente2);*/
        
        var listaClientes = repositorio.findAll();

        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }
}

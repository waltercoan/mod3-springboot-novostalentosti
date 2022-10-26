package br.univille.novostalentos.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.novostalentos.entity.ItemVenda;
import br.univille.novostalentos.entity.Venda;
import br.univille.novostalentos.service.ClienteService;
import br.univille.novostalentos.service.ProdutoService;
import br.univille.novostalentos.service.VendaService;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService service;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public ModelAndView index(){
        var listaVendas = service.getAll();
        return new ModelAndView("venda/index",
                    "listaVendas",listaVendas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novaVenda = new Venda();
        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("venda", novaVenda);
        dados.put("listaClientes", listaClientes);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemVenda());
        return new ModelAndView("venda/form",dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(@Valid Venda venda,
                            BindingResult bindingResult){
        service.save(venda);
        return new ModelAndView("redirect:/vendas");
    }

    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Venda venda, 
                ItemVenda novoItem){
        venda.getColItens().add(novoItem);

        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaClientes", listaClientes);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemVenda());
        return new ModelAndView("venda/form",dados);
    }
}

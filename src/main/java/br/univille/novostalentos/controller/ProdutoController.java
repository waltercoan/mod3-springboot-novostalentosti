package br.univille.novostalentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.novostalentos.entity.Produto;
import br.univille.novostalentos.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public ModelAndView index(){
        var listaProdutos = service.getAll();
        return new ModelAndView("produto/index", "listaProdutos",listaProdutos);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var produtoNovo = new Produto();
        return new ModelAndView("produto/form","produto",produtoNovo);
    }
    @PostMapping(params = "form")
    public ModelAndView save(Produto produto){

        service.save(produto);
        
        return new ModelAndView("redirect:/produtos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umProduto = service.findById(id);
        return new ModelAndView("produto/form","produto",umProduto);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/produtos");
    }
}   

package br.univille.novostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.novostalentos.entity.Produto;
import br.univille.novostalentos.repository.ProdutoRepository;
import br.univille.novostalentos.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;
    @Override
    public List<Produto> getAll() {
        
        return repositorio.findAll();
    }
    
}

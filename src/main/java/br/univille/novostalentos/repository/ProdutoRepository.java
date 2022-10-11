package br.univille.novostalentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.novostalentos.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    
}

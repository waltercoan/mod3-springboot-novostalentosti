package br.univille.novostalentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.novostalentos.entity.Cidade;

@Repository
public interface CidadeRepository 
        extends JpaRepository<Cidade,Long>{
    
}

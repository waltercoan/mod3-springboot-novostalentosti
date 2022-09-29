package br.univille.novostalentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.novostalentos.entity.Cliente;

@Repository
public interface ClienteRepository 
    extends JpaRepository<Cliente,Long>{
    /*select * from cliente where nome like '%zinho%' */
    List<Cliente> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
}

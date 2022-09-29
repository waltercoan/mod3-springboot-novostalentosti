package br.univille.novostalentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.novostalentos.entity.Cliente;

@Repository
public interface ClienteRepository 
    extends JpaRepository<Cliente,Long>{
    
}

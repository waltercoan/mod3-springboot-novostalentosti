package br.univille.novostalentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.novostalentos.entity.Venda;

@Repository
public interface VendaRepository 
    extends JpaRepository<Venda,Long> {
    
}

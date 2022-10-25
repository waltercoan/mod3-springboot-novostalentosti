package br.univille.novostalentos.service;

import java.util.List;
import br.univille.novostalentos.entity.Venda;

public interface VendaService {
    List<Venda> getAll();
    void save(Venda venda);
    Venda findById(long id);
}
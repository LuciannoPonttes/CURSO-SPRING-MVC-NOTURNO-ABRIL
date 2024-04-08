package com.impacta.cadastroTime.cadastroTime.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.impacta.cadastroTime.cadastroTime.model.Jogador;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, String> {

}

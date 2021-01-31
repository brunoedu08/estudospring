package com.turorial.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turorial.crud.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	/**
	 * 
	 * @param name
	 * @return
	 */
	Optional<Produto> findByNome(String nome);
	
}

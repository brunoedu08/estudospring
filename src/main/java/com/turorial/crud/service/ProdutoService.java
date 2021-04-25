package com.turorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turorial.crud.entity.Produto;
import com.turorial.crud.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> list() {
		return produtoRepository.findAll();
	}

	public Optional<Produto> getProdutoById(Integer id) {
		return produtoRepository.findById(id);
	}
	
	public Optional<Produto> getProdutoByName(String nome){
		return produtoRepository.findByNome(nome);
	}
	
	public void saveProduto(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public void deleteProdutoById (int id) {
		produtoRepository.deleteById(id);
	}
	
	public boolean existsById(Integer id) {
		return produtoRepository.existsById(id);
	}
}

package com.turorial.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.turorial.crud.dto.MensagemDTO;
import com.turorial.crud.dto.ProdutoDTO;
import com.turorial.crud.entity.Produto;
import com.turorial.crud.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;

	@GetMapping("/lista")
	public ResponseEntity<List<Produto>> list(){
		List<Produto> list = produtoService.list();
		
		return new ResponseEntity<List<Produto>>(list, HttpStatus.OK);
	}
	
	@GetMapping("find-{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id){
		if(!produtoService.existsById(id)) {
			return new ResponseEntity(new MensagemDTO("Não existe"), HttpStatus.NOT_FOUND);
		}
		
		Optional<Produto> produto = produtoService.getProdutoById(id);
		return new ResponseEntity(produto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addProduto (@RequestBody ProdutoDTO produtoDto) {
		Produto produto = new Produto();
		produto.setNome(produtoDto.getNome());
		produto.setValor(produtoDto.getValor());
		produtoService.saveProduto(produto);
		
		return new ResponseEntity(new MensagemDTO("Adicionado"), HttpStatus.OK);
	}
}

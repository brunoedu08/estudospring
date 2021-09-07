package com.turorial.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turorial.crud.dto.MensagemDTO;
import com.turorial.crud.dto.ProdutoDTO;
import com.turorial.crud.entity.Produto;
import com.turorial.crud.service.ProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*")
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
	
	@DeleteMapping(value = "/delete-{id}")
	public ResponseEntity<?> deleteProdutoByID(@PathVariable("id") Integer id){
		if(produtoService.existsById(id)) {
			produtoService.deleteProdutoById(id);
			return new ResponseEntity(new MensagemDTO("Produto deletado"), HttpStatus.OK);
		}else {
			return new ResponseEntity(new MensagemDTO("Não encontrado"), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/update-{id}")
	public ResponseEntity<?> updateProduto(@PathVariable("id") Integer id, @RequestBody ProdutoDTO produtoDTO){
		Optional<Produto> produto = produtoService.getProdutoById(id);
		produto.get().setId(id);
		produto.get().setNome(produtoDTO.getNome());
		produto.get().setValor(produtoDTO.getValor());
		
		if(produto.isPresent()) {
			produtoService.saveProduto(produto.get());
			return new ResponseEntity(new MensagemDTO("Produto atualizado"), HttpStatus.OK);			
		}else {
			return new ResponseEntity(new MensagemDTO("O id desse produto não existe"), HttpStatus.NOT_FOUND);
		}
		
	}
}

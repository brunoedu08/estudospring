package com.turorial.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	private String nome;
	private Integer valor;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	public Produto() {
		
	}
	
	public Produto(String nome, Integer valor, Long id) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public long getI() {
		return id;
	}
	public void setCodigo(long id) {
		this.id = id;
	}
}

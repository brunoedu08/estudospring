package com.turorial.crud.dto;

public class ProdutoDTO {
	private String nome;
	private float valor;
	
	public ProdutoDTO() {
		
	}

	public ProdutoDTO(String nome, float valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}

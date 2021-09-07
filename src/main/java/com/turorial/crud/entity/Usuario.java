package com.turorial.crud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	@Getter @Setter
	@NotNull
	@Id
	private String email;
	@Getter @Setter
	private String senha;
	
}


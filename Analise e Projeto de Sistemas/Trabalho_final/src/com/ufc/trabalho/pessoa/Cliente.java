package com.ufc.trabalho.pessoa;

import java.util.ArrayList;

import java.util.List;

import com.ufc.trabalho.entidades.Crud;
import com.ufc.trabalho.entidades.Pedido;

public  class Cliente{

	protected String nome;
	protected String endereco;
	protected String cidade;
	protected String estado;
	protected String cep;
	protected String telefone;
	protected String email;

	protected List<Pedido> pedidos = new ArrayList<>();


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public  List<Pedido> getPedidos() {
		return pedidos;
	}
	
	
		
	
	
	
	public  Cliente() {
		
	}
	
}

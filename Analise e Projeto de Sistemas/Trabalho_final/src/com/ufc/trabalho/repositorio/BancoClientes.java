package com.ufc.trabalho.repositorio;

import java.util.ArrayList;


import java.util.List;

import com.ufc.trabalho.pessoa.PessoaFisica;

public abstract class BancoClientes{

	private static List<PessoaFisica> clientes = new ArrayList<>();

	public static List<PessoaFisica> getClientes() {
		return clientes;
	}


}

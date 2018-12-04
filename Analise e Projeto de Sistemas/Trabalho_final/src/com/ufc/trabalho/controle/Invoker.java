package com.ufc.trabalho.controle;

import java.util.HashMap;


import java.util.Map;

import com.ufc.trabalho.repositorio.Item;
import com.ufc.trabalho.telas.Atualizar;
import com.ufc.trabalho.telas.CadastroCliente;
import com.ufc.trabalho.telas.Comprar;
import com.ufc.trabalho.telas.Menu;
import com.ufc.trabalho.telas.Remover;


// Controle de telas da aplicação

public class Invoker {

	public static Map<String,Command> telas = new HashMap<>(); 

	public static Map<String, Command> getTelas() {
		return telas;
	}

	static {
		telas.put("Menu",new Menu());
		telas.put("Cadastro", new CadastroCliente());
		telas.put("Remover", new Remover());
		telas.put("Atualizar", new Atualizar());	
		telas.put("Carregar",new Item() {});
		telas.put("Comprar", new Comprar());
	}

	public static void invoke(String comando) {
		telas.get(comando).execute();
	}



}

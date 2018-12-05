package com.ufc.trabalho.controle;


import com.ufc.trabalho.entidades.Item;
import com.ufc.trabalho.entidades.Pedido;
import com.ufc.trabalho.entidades.Perfume;
import com.ufc.trabalho.pessoa.Cliente;
import com.ufc.trabalho.pessoa.PessoaFisica;
import com.ufc.trabalho.repositorio.BancoClientes;
import com.ufc.trabalho.repositorio.BancoPerfumes;
import com.ufc.trabalho.telas.TratamentoDados;

public abstract class Fachada extends TratamentoDados {


	public static void iniciar() {
		Invoker.invoke("Menu");
	}

	/*
	 * Comandos MENU
	 * 
	 * */

	public static void cadastrar() {
		Invoker.invoke("Cadastro");
	}
	public static void comprar() {
		Invoker.invoke("Comprar");
	}

	/*
	 *  Banco Clientes
	 * 
	 * */

	public static void adicionarCliente(PessoaFisica e) {
		BancoClientes.getClientes().add(e);
	}
	public static void pesquisarCliente(String cpf) {
		System.out.println("cpf passado: "+cpf);
		int contador = 0;
		if(BancoClientes.getClientes().isEmpty()) {
			System.out.println("Não está no banco!");
			System.out.println("Vamos cadastrar agora !");
			Fachada.cadastrar();
		}

		for(PessoaFisica p: BancoClientes.getClientes()) {
		
			
			if(p.getCpf().equals(cpf)) {
				contador++;
				
				
			}
		
		}
		if(!(contador == 1)) {
//			System.out.println("cpf do vetor: "+p.getCpf()+"cpf parametro "+cpf);
			System.out.println("Não está no banco!");
			System.out.println("Vamos cadastrar agora !");
			Fachada.cadastrar();
		}
	}		
	

	public static PessoaFisica  pesquisarClienteObjeto(String cpf) {
		for(PessoaFisica p : BancoClientes.getClientes()) {
			if(p.getCpf().equals(cpf))
				return p;
		}
		return null;
	}


	/*
	 *  Banco Itens(Perfumes)
	 *  
	 * */


	public static void carregar() {
		BancoPerfumes.carregarPerfume();
	}

	public static Perfume pesquisarPerfumeObjeto(Integer codigo) {
		for(Perfume p: BancoPerfumes.getPerfumes()) {
			if(p.getCodigo()== codigo) {
				return p;
			}

		}
		return null;

	}

	public static void diminuirEstoque(Perfume escolhido,Integer quantidade) {
		//		Item.getPerfumes().remove(escolhido);

		if(quantidade > escolhido.getQuantidadeEstoque()) {
			while(quantidade > escolhido.getQuantidadeEstoque()) {

				System.err.println("quantidade insuficiente");
				quantidade = lerInteiro("Digite novamente");
				//			throw new IllegalArgumentException("quantidade insuficiente");
			}
		}else {

			escolhido.setQuantidadeEstoque(escolhido.getQuantidadeEstoque()-quantidade);
		} 
		if(escolhido.getQuantidadeEstoque() == 0) {
			escolhido.setEsgotado(true);
		}else if(escolhido.isEsgotado()) {
			System.err.println("Produto esgotado, não adicionado");
			return;
		}

	}

	public static void listarPerfumes() {
		System.out.println();
		System.out.println("Pequeno -> 30ml, Médio -> 50ml, Grande -> 120ml  ");
		System.out.println();
		
		BancoPerfumes.getPerfumes().forEach(a->{
			System.out.println();
			System.out.println(a);
		});
		
	}


	/*
	 * Banco de pedidos
	 * 
	 */


	public static void adicionarPedido(Cliente e, Pedido p) {
		//System.out.println(e);
		e.getPedidos().add(p);
	}
	public static void adicionarMaisProduto(Pedido criado, Perfume escolhido,Item i) {

		criado.adicionar(escolhido);
		criado.getItens().add(i);

	}

	public static void mostraPedido(Pedido e) {
		System.out.println(e);
	}

}

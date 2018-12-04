package com.ufc.trabalho.controle;


import com.ufc.trabalho.entidades.Pedido;
import com.ufc.trabalho.entidades.Perfume;
import com.ufc.trabalho.pessoa.Cliente;
import com.ufc.trabalho.pessoa.PessoaFisica;
import com.ufc.trabalho.repositorio.BancoClientes;
import com.ufc.trabalho.repositorio.Item;
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
	public static void remover() {
		Invoker.invoke("Remover");
	}
	public static void carregar() {
		Invoker.invoke("Carregar");
	}
	public static void atualizar() {
		Invoker.invoke("Atualizar");
	}
	public static void comprar() {
		Invoker.invoke("Comprar");
	}
	public static void listarItens() {
		Item.mostrarDados();
	}
	/*
	 *  Banco Clientes
	 * 
	 * */

	public static void adicionarCliente(PessoaFisica e) {
		BancoClientes.getClientes().add(e);
	}
	public static void pesquisarCliente(String cpf) {

		//		BancoClientes.getClientes().forEach(a->{
		//			
		//			if() {
		//				System.out.println("Não está no banco!");
		//				System.out.println("Vamos cadastrar agora !");
		//				Fachada.cadastrar();
		//
		//			}
		//		});
		for(PessoaFisica p: BancoClientes.getClientes()) {
			if(!p.getCpf().equals(cpf)) {
				System.out.println("Não está no banco!");
				System.out.println("Vamos cadastrar agora !");
				Fachada.cadastrar();
			}
		}
	}
	//		if(!BancoClientes.getClientes()) {
	//
	//
	//		}
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

	public static Perfume pesquisarPerfumeObjeto(Integer codigo) {
		for(Perfume p: Item.getPerfumes()) {
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
		}
		



	}

	/*
	 * Banco de pedidos
	 * 
	 */


	public static void adicionarPedido(Cliente e, Pedido p) {
		//System.out.println(e);
		e.getPedidos().add(p);
	}
	public static void adicionarMaisProduto(Pedido criado, Perfume escolhido) {

		criado.adicionar(escolhido);
	}


}

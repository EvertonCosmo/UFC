package com.ufc.trabalho.telas;



import com.ufc.trabalho.controle.Command;
import com.ufc.trabalho.controle.Fachada;
import com.ufc.trabalho.entidades.Pedido;
import com.ufc.trabalho.entidades.Perfume;
import com.ufc.trabalho.pagamento.Cartao;
import com.ufc.trabalho.pagamento.Dinheiro;
import com.ufc.trabalho.pessoa.Cliente;
import com.ufc.trabalho.pessoa.PessoaFisica;


public class Comprar extends TratamentoDados implements Command{

	@Override
	public void execute() {
		//		System.out.println(" \t\t\t\t ======= TELA COMPRAR ======== ");


		System.out.println();

		System.out.println("\t\t\t ###########  <(PRODUTOS)>  ###########");
		System.out.println();
		Fachada.listarItens();
		System.out.println();
		System.out.println();

		System.out.println("Adicionando ao carrinho ...");

		Integer codigo = lerInteiro("Digite o codigo correspondente: ");


		Perfume perfumeEscolhido = Fachada.pesquisarPerfumeObjeto(codigo) ;

		Integer quantidade = lerInteiro("Digite a quantidade: ");


		Fachada.diminuirEstoque(perfumeEscolhido, quantidade);

		System.out.println("EFETUAR PEDIDO ? (1 - S), (2 - N)" );
		Integer opcao = lerInteiro("opcao: ");



		switch(opcao) {

		case 1:	

			String cpf = lerString("Digite o cpf: ");
			Fachada.pesquisarCliente(cpf);
			String opca = lerString("Tu queres pagar com cartão ou dinheiro ? (C/D)");

			//cpf = lerString("Digite o cpf: ");
			
			if(opca.equalsIgnoreCase("c")) {
				String numeroCartao = lerString("Digite o número do cartao :");

				

				Cliente cliente = Fachada.pesquisarClienteObjeto(cpf);
				Pedido pedidoCriado = new Pedido(new Cartao(Integer.parseInt(numeroCartao), "Compra no cartão"), (PessoaFisica)cliente, perfumeEscolhido.getValor()*quantidade);

				//				Fachada.adicionarPedido( (PessoaFisica) cliente,new Pedido(new Cartao(Integer.parseInt(numeroCartao), "Compra no cartão"), perfumeEscolhido.getValor()*quantidade));
				Fachada.adicionarPedido(cliente,pedidoCriado);
				String opcaoAdicionar  = lerString("Tu queres adicionar mais itens ao pedido: (S/N)");
				do {

					if(opcaoAdicionar.equalsIgnoreCase("s")) {
						Integer codigoNovo = lerInteiro("Digite o codigo correspondente: ");

						Perfume perfumeEscolhidoNovo = Fachada.pesquisarPerfumeObjeto(codigo) ;

						Integer quantidadeNovo = lerInteiro("Digite a quantidade: ");
						Fachada.diminuirEstoque(perfumeEscolhidoNovo, quantidadeNovo);
						Cliente clienteExistente =Fachada.pesquisarClienteObjeto(cpf);
						Fachada.adicionarMaisProduto(pedidoCriado,perfumeEscolhidoNovo);
						opcaoAdicionar  = lerString("Tu queres adicionar mais itens ao pedido: (S/N)");

					}else{
						System.out.println("PEDIDO FINALIZADO COM SUCESSO :) ");
					}
					
				}while(opcaoAdicionar.equalsIgnoreCase("s"));
				
				System.out.println("PEDIDO FINALIZADO COM SUCESSO :) ");
				
			}else if(opca.equalsIgnoreCase("d")){
				System.out.println("Gerando boleto....");
				String numeroCartao = lerString("Digite o dinheiro :");


				Cliente cliente = Fachada.pesquisarClienteObjeto(cpf);
				Pedido pedidoCriado = new Pedido(new Dinheiro(Integer.parseInt(numeroCartao), "Compra a dinheiro"), (PessoaFisica)cliente, perfumeEscolhido.getValor()*quantidade);

				//				Fachada.adicionarPedido( (PessoaFisica) cliente,new Pedido(new Cartao(Integer.parseInt(numeroCartao), "Compra no cartão"), perfumeEscolhido.getValor()*quantidade));
				Fachada.adicionarPedido(cliente,pedidoCriado);
				String opcaoAdicionar  = lerString("Tu queres adicionar mais itens ao pedido: (S/N)");
				do {

					if(opcaoAdicionar.equalsIgnoreCase("s")) {
						Integer codigoNovo = lerInteiro("Digite o codigo correspondente: ");


						Perfume perfumeEscolhidoNovo = Fachada.pesquisarPerfumeObjeto(codigo) ;

						Integer quantidadeNovo = lerInteiro("Digite a quantidade: ");

						Fachada.diminuirEstoque(perfumeEscolhidoNovo, quantidadeNovo);

						Cliente clienteExistente =Fachada.pesquisarClienteObjeto(cpf);
						Fachada.adicionarMaisProduto(pedidoCriado,perfumeEscolhidoNovo);
						opcaoAdicionar  = lerString("Tu queres adicionar mais itens ao pedido: (S/N)");


					}else{
						System.out.println("PEDIDO FINALIZADO COM SUCESSO :) ");
					}
				}while(opcaoAdicionar.equalsIgnoreCase("s"));

				System.out.println("PEDIDO FINALIZADO COM SUCESSO :) ");
			}break;
		case 2: 
			System.out.println(":( ");
			Fachada.iniciar();
			break;
		default: 
			System.err.println("Valor inválido");break;
		}




	}

}

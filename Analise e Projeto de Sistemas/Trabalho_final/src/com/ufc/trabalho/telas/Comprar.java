package com.ufc.trabalho.telas;



import com.ufc.trabalho.controle.Command;



import com.ufc.trabalho.controle.Fachada;
import com.ufc.trabalho.entidades.Item;
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
		Fachada.listarPerfumes();
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

				Item item = new Item(perfumeEscolhido.getValor()*quantidade, perfumeEscolhido.getCodigo(),0.0);
				Pedido pedidoCriado = new Pedido(new Cartao(Integer.parseInt(numeroCartao), "Compra no cartão"),(PessoaFisica)cliente, perfumeEscolhido.getValor()*quantidade,item);

				item.setCodigoPedido(pedidoCriado.getCodigo());


				//				Fachada.adicionarPedido( (PessoaFisica) cliente,new Pedido(new Cartao(Integer.parseInt(numeroCartao), "Compra no cartão"), perfumeEscolhido.getValor()*quantidade));
				Fachada.adicionarPedido(cliente,pedidoCriado);

				String opcaoAdicionar  = lerString("Tu queres adicionar mais itens ao pedido: (S/N)");
				do {

					if(opcaoAdicionar.equalsIgnoreCase("s")) {
						Integer codigoNovo = lerInteiro("Digite o codigo correspondente: ");

						Perfume perfumeEscolhidoNovo = Fachada.pesquisarPerfumeObjeto(codigoNovo) ;

						Integer quantidadeNovo = lerInteiro("Digite a quantidade: ");

						Fachada.diminuirEstoque(perfumeEscolhidoNovo, quantidadeNovo);

						Item itemNovo = null;
						if(perfumeEscolhido.getCodigo() == perfumeEscolhidoNovo.getCodigo())
							Fachada.adicionarMaisProduto(pedidoCriado,perfumeEscolhidoNovo,item);
						else
							itemNovo= new Item(perfumeEscolhidoNovo.getValor()*quantidadeNovo, perfumeEscolhidoNovo.getCodigo(),0.0);
						Fachada.adicionarMaisProduto(pedidoCriado,perfumeEscolhidoNovo,itemNovo);
						opcaoAdicionar  = lerString("Tu queres adicionar mais itens ao pedido: (S/N)");

					}else{

						System.out.println("PEDIDO FINALIZADO COM SUCESSO :) ");
						System.out.println();
						System.out.println("##### ITENS DO PEDIDO ##### ");
						Fachada.mostraPedido(pedidoCriado);
						System.out.println();
						System.out.println("VALOR TOTAL:  "+pedidoCriado.getValor());
						System.out.println("#### ÁREA DE PAGAMENTO ###");

						if(pedidoCriado.getFormaPagamento().efetuarPagamento(pedidoCriado,pedidoCriado.getValor())) {
							try {
								processando();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println();

							System.out.println("PAGAMENTO CONCLUíDO, :)  ");
						}
						else {
							System.out.println();

							System.out.println("PAGAMENTO NÃO EFETUADO :(  ");
							System.out.println();
							Fachada.resetar();
						}

					}

				}while(opcaoAdicionar.equalsIgnoreCase("s"));



			}else if(opca.equalsIgnoreCase("d")){
				System.out.println("Pagamento em dinheiro....");

				Item item = new Item((perfumeEscolhido.getValor()*quantidade)-(5*quantidade), perfumeEscolhido.getCodigo(),5.00);
				Cliente cliente = Fachada.pesquisarClienteObjeto(cpf);


				Pedido pedidoCriado = new Pedido(new Dinheiro(numeroAleatorio(),"Compra a dinheiro"), (PessoaFisica)cliente, (perfumeEscolhido.getValor()*quantidade)-(5*quantidade),item);

				item.setCodigoPedido(pedidoCriado.getCodigo());

				//				Fachada.adicionarPedido( (PessoaFisica) cliente,new Pedido(new Cartao(Integer.parseInt(numeroCartao), "Compra no cartão"), perfumeEscolhido.getValor()*quantidade));
				Fachada.adicionarPedido(cliente,pedidoCriado);

				String opcaoAdicionar  = lerString("Tu queres adicionar mais itens ao pedido: (S/N)");
				do {

					if(opcaoAdicionar.equalsIgnoreCase("s")) {
						Integer codigoNovo = lerInteiro("Digite o codigo correspondente: ");

						Perfume perfumeEscolhidoNovo = Fachada.pesquisarPerfumeObjeto(codigoNovo) ;

						Integer quantidadeNovo = lerInteiro("Digite a quantidade: ");

						Fachada.diminuirEstoque(perfumeEscolhidoNovo, quantidadeNovo);
						//						Cliente clienteExistente =Fachada.pesquisarClienteObjeto(cpf);
						Item itemNovo = null ;
						if(perfumeEscolhido.getCodigo() == perfumeEscolhidoNovo.getCodigo())
							Fachada.adicionarMaisProduto(pedidoCriado,perfumeEscolhidoNovo,item);
						else
							itemNovo = new Item((perfumeEscolhidoNovo.getValor()*quantidade)-(5*quantidade), perfumeEscolhidoNovo.getCodigo(),5.00);
						Fachada.adicionarMaisProduto(pedidoCriado,perfumeEscolhidoNovo,itemNovo);
						opcaoAdicionar  = lerString("Tu queres adicionar mais itens ao pedido: (S/N)");

					}else {
						System.out.println("PEDIDO FINALIZADO COM SUCESSO :) ");
						System.out.println("##### ITENS DO PEDIDO ##### ");
						Fachada.mostraPedido(pedidoCriado);
						System.out.println();
						System.out.println("VALOR TOTAL:  "+pedidoCriado.getValor());
						Double valorPagamento = lerDouble("Digite o valor de pagamento: ");
						if(pedidoCriado.getFormaPagamento().efetuarPagamento(pedidoCriado,valorPagamento )) {
							try {
								processando();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println();

							System.out.println("PAGAMENTO CONCLUíDO, :)  ");
						}
						else {
							System.out.println();

							System.out.println("PAGAMENTO NÃO EFETUADO :(  ");
							System.out.println();
							Fachada.resetar();
						}
					}
				}while(opcaoAdicionar.equalsIgnoreCase("s"));


			}break;
		case 2: 
			System.err.println(":( , PEDIDO NÃO REALIZADO");
			break;
		default: 
			System.err.println("Valor inválido");break;
		}




	}
	private void processando() throws InterruptedException {
		System.out.print("processando ");
		System.out.print(".");

	
			Thread.sleep(1000);
		
		
		
		System.out.print(".");
	
			Thread.sleep(1000);
		
		
		
		
		System.out.print(".");
		
			Thread.sleep(1000);
		
	}
	

}

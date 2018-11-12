package com.cosmo.everton.ufc.questao1;

public class Main {

	public static void main(String[] args) {
		Item pao = new Item(101, "Pao", 1.40, 1);
		Item queijo = new Item(220, "Queijo",3.00, 2);
		Item biscoito = new Item(303, "Ovo",1.50, 2);
		Item carne = new Item(330, "carne", 10, 3);
		Item[] itens = {pao,queijo,biscoito,carne};
		
		Impressora samsung = new Impressora();
		
		CupomFiscal cupom = new CupomFiscal.CupomFiscalBuilder("Cosmo", "099323491")
				.cpfConsumidor("0010101001")
				.dinheiroRecebido(1000)
				.listaItem(itens)
				.criar();
		
//		CupomFiscal cupom2 = new CupomFiscal.CupomFiscalBuilder("Everton", "099323491")
//				.cpfConsumidor("0010101001")
//				.dinheiroRecebido(1000)
//				.listaItem(itens)
//				.criar();
//		
//		CupomFiscal[] cupons = {cupom,cupom2};
		
		samsung.imprimirNota(cupom);
	}
	
	
	

}

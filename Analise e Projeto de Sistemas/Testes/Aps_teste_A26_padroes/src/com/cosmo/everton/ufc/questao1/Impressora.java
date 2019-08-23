package com.cosmo.everton.ufc.questao1;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Calendar;


public class Impressora {
	private final static Impressora INSTANCE = new Impressora();  
	

	public static Impressora getInstance() {
		return INSTANCE;
	}
	
	public  void imprimirNota(CupomFiscal c) {
		Calendar hoje =  Calendar.getInstance();
		int mes = hoje.get(Calendar.MONTH)+1;
		double valorTotal = 0;
		System.out.println("\t SUPERMERCADO");
		System.out.println("CNPJ: "+c.getCnpj());
		System.out.println("Horário");
		System.out.printf(" %d/%02d/%d %02d:%02d:%02d %n",hoje.get(Calendar.DAY_OF_MONTH),mes,
				hoje.get(Calendar.YEAR),hoje.get(Calendar.HOUR),hoje.get(Calendar.MINUTE),hoje.get(Calendar.SECOND));
		System.out.println("----------------------------------------");
		System.out.println("CNPJ/CPF consumidor: "+c.getCpfConsumidor());
		System.out.println("----------------------------------------");
		System.out.println("\t CUPOM FISCAL ");
		System.out.println("ITEM \t CÓDIGO \t DESCRIÇÃO");
		System.out.println("\tQTDxUNITÁRIO \t       VALOR(R$)");
		System.out.println("----------------------------------------");
		ArrayList<Item> lista = new ArrayList<Item>(Arrays.asList(c.getListaItem()));
		
		
		
		for(int i=0;i<lista.size();i++) {
			
			System.out.println(i+1+"\t"+lista.get(i)+"\t \t     "+(lista.get(i).getValorUnitario()
					*lista.get(i).getQuantidade()));

			valorTotal += lista.get(i).calculoValorTotal();
			
		
		}
		System.out.println();
		System.out.println("TOTAL R$ \t\t    "+valorTotal);
		System.out.println("VALOR RECEBIDO R$ \t  "+c.getDinheiroRecebido());
		System.out.printf("TROCO R$ \t\t %f \n",c.getDinheiroRecebido() - valorTotal);
		System.out.println("----------------------------------------");
		
		
	}
	
	public void imprimirNota(CupomFiscal[] c) {
		for(int i=0; i<c.length; i++) {
			imprimirNota(c[i]);
			System.out.println();
		}
	}
}

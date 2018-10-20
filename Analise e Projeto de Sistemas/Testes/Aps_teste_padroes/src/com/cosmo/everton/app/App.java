package com.cosmo.everton.app;

import java.util.Calendar;

import java.util.Date;


import com.cosmo.everton.pessoa.PessoaFisica;
import com.cosmo.everton.pessoa.PessoaJuridica;
import com.cosmo.everton.repositorio.ColecaoPessoa;


public class App {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1999);
		c.set(Calendar.MONTH,04);
		c.set(Calendar.DAY_OF_MONTH, 29);

		Date da = c.getTime();

		c.set(Calendar.YEAR,1998);
		c.set(Calendar.MONTH,10);
		c.set(Calendar.DAY_OF_MONTH, 01);

		Date jd = c.getTime();


		ColecaoPessoa colecao = ColecaoPessoa.getInstance();
		
		PessoaFisica cosmo = new PessoaFisica("111.222.333-00", da, "Cosmo");
		PessoaFisica cosmo2 = new PessoaFisica("111.222.333-00", da, "Cosmo2");
		PessoaJuridica juridica = new PessoaJuridica("73.555.261/0001-41", jd, "Juridica");
		PessoaJuridica juridica2 = new PessoaJuridica("73.555.261/0001-41", jd, "Juridica2");
		
		
		colecao.inserir(cosmo);
		colecao.inserir(cosmo2);
		colecao.inserir(juridica);
		colecao.inserir(juridica2);
		
		System.out.println();
		
		colecao.imprimirDadosColecao();
		
		System.out.println("idade :"+cosmo.calcularIdade());
		
		System.out.println(cosmo.equals(cosmo2));
		
		System.out.println(juridica.equals(juridica2));
		
		System.out.println("Pesquisar: "+colecao.pesquisar(cosmo));
		
		
		
		
		


	}
}
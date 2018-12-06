package com.ufc.trabalho.repositorio;
import java.util.ArrayList;
import java.util.List;

import com.ufc.trabalho.entidades.Marcas;
import com.ufc.trabalho.entidades.Perfume;
import com.ufc.trabalho.pessoa.PessoaJuridica;

public abstract class BancoPerfumes {
	
	private static List<Perfume> perfumes = new ArrayList<Perfume>();
	
	public static List<Perfume> getPerfumes() {
		return perfumes;
	}

	public static void carregarPerfume() {
		perfumes.add(
				new Perfume.PerfumeBuilder()
				.AnoEdicao(2010)
				.codigo(01)
				.esgotado(false)
				.quantidadeEstoque(5)
				.genero("Masculino")
				.marca(Marcas.AZZARO)
				.titulo("Perfume 1")
				.importadora(new PessoaJuridica("Manoel","777-888-777-33","0012.0031.13001/1"))
				.tamanho("pequeno")
				.valor(200.00)
				.build()

				);

		perfumes.add(
				new Perfume.PerfumeBuilder()
				.AnoEdicao(2012)
				.codigo(02)
				.esgotado(false)
				.quantidadeEstoque(10)
				.genero("Feminino")
				.marca(Marcas.CAROLINA_HERRERA)
				.titulo("Perfume 2")
				.importadora(new PessoaJuridica ("Carolina","437-248-111-33","0012.1931.15401/2"))
				.tamanho("médio")
				.valor(500.00)
				.build()

				);
		perfumes.add(
				new Perfume.PerfumeBuilder()
				.AnoEdicao(2016)
				.codigo(03)
				.esgotado(true)
				.quantidadeEstoque(0)
				.genero("Masculino")
				.marca(Marcas.BOSS)
				.titulo("Perfume 3")
				.importadora(new PessoaJuridica ("Messias","437-248-111-33","0012.9931.15001/6"))
				.tamanho("grande")
				.valor(100.00)
				.build()
				);

		perfumes.add(
				new Perfume.PerfumeBuilder()
				.AnoEdicao(2014)
				.codigo(04)
				.esgotado(false)
				.quantidadeEstoque(2)
				.genero("Masculino")
				.marca(Marcas.FERRARI)
				.titulo("Perfume 4")
				.importadora(new PessoaJuridica("João","437-248-231-33","1212.9441.15191/4"))
				.tamanho("grande")
				.valor(550.00)
				.build()

				);
		perfumes.add(
				new Perfume.PerfumeBuilder()
				.AnoEdicao(2011)
				.codigo(05)
				.esgotado(false)
				.quantidadeEstoque(6)
				.genero("Masculino")
				.marca(Marcas.BORSARI)
				.titulo("Perfume 5")
				.importadora(new PessoaJuridica("Alberto","127-148-121-33","1212.9441.15191/4"))
				.tamanho("grande")
				.valor(150.00)
				.build()

				);


		perfumes.add(
				new Perfume.PerfumeBuilder()
				.AnoEdicao(2015)
				.codigo(06)
				.esgotado(false)
				.quantidadeEstoque(20)
				.genero("Masculino")
				.marca(Marcas.BIJAN)
				.titulo("Perfume 6")
				.importadora(new PessoaJuridica("Joana","137-148-931-99","3412.211.13191/4"))
				.tamanho("grande")
				.valor(850.00)
				.build()

				);
		perfumes.add(
				new Perfume.PerfumeBuilder()
				.AnoEdicao(2019)
				.codigo(07)
				.esgotado(false)
				.quantidadeEstoque(10)
				.genero("Feminino")
				.marca(Marcas.BELLE)
				.titulo("Perfume 7")
				.importadora(new PessoaJuridica("Luiza","017-123-101-00","1212.9341.95291/1"))
				.tamanho("pequeno")
				.valor(950.00)
				.build()

				);
		
	}
	public static void resetarPerfumes() {
		perfumes.clear();
		carregarPerfume();
	}
	
}

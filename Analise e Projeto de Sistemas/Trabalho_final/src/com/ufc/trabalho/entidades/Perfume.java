package com.ufc.trabalho.entidades;

import com.ufc.trabalho.pessoa.PessoaJuridica;

public class Perfume {
	
	private Integer codigo;
	private String titulo;
	private Marcas marca;
	private PessoaJuridica importadora;
	private Double valor;
	private  Integer quantidadeEstoque;
	private Integer anoEdicao;
	private  boolean esgotado;
	private String genero;
	private String tamanho;

	private Perfume(PerfumeBuilder builder){
		this.codigo = builder.codigo;
		this.titulo = builder.titulo;
		this.marca = builder.marca;
		this.importadora = builder.importadora;
		this.valor = builder.valor;
		this.setQuantidadeEstoque(builder.quantidadeEstoque); 
		this.anoEdicao = builder.anoEdicao;
		this.setEsgotado(builder.esgotado);
		this.genero = builder.genero;
		this.tamanho = builder.tamanho;
	}
	
	public Perfume() {}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ codigo=");
		builder.append(codigo);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", qtd estoque= ");
		builder.append(quantidadeEstoque);
		builder.append(" , esgotado= ");
		builder.append(esgotado);
		builder.append(" , marca=");
		builder.append(marca);
		builder.append(", importadora=");
		builder.append(importadora);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", anoEdicao=");
		builder.append(anoEdicao);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", tamanho=");
		builder.append(tamanho);
		builder.append(" ]");
		return builder.toString();
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Marcas getMarca() {
		return marca;
	}
	public void setMarca(Marcas marca) {
		this.marca = marca;
	}
	public PessoaJuridica getImportadora() {
		return importadora;
	}
	public void setImportadora(PessoaJuridica importadora) {
		this.importadora = importadora;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Integer getAnoEdicao() {
		return anoEdicao;
	}
	public void setAnoEdicao(Integer anoEdicao) {
		this.anoEdicao = anoEdicao;
	}
	public boolean isEsgotado() {
		return esgotado;
	}
	public void setEsgotado(boolean esgotado) {
		this.esgotado = esgotado;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	
public static class PerfumeBuilder{
	
	private Integer codigo;
	private String titulo;
	private Marcas marca;
	private PessoaJuridica importadora;
	private Double valor;
	private Integer quantidadeEstoque;
	private Integer anoEdicao;
	private boolean esgotado;
	private String genero;
	private String tamanho;
	
	public PerfumeBuilder() {
	
	}
	public PerfumeBuilder codigo(Integer codigo) {
		this.codigo = codigo;
		return this;
	}
	public PerfumeBuilder titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	public PerfumeBuilder marca(Marcas marca) {
		this.marca = marca;
		return this;
	}
	
	public PerfumeBuilder importadora(PessoaJuridica importadora) {
		this.importadora = importadora;
		return this;
	}
	public PerfumeBuilder valor(Double valor) {
		this.valor = valor;
		return this;
	}
	public PerfumeBuilder quantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
		return this;
	}
	public PerfumeBuilder AnoEdicao(Integer anoEdicao) {
		this.anoEdicao = anoEdicao;
		return this;
	}
	public PerfumeBuilder esgotado(boolean esgotado) {
		this.esgotado = esgotado;
		return this;
	}
	public PerfumeBuilder genero(String genero) {
		this.genero = genero;
		return this;
	}
	public PerfumeBuilder tamanho(String tamanho) {
		this.tamanho = tamanho;
		return this;
	}

	public Perfume build() {
		return new Perfume(this);
	}
	
	
	
}
	
	
}

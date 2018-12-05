package com.ufc.trabalho.entidades;

import java.util.ArrayList;
import java.util.List;

public class Item{

	private Integer codigo;
	private Integer codigoPedido; 
	private Double preco;
	private Double desconto;
	private static List<Perfume> perfumes = new ArrayList<>();	
	
	private static Integer quantidade = 0; 

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public static List<Perfume> getPerfumes() {
		return perfumes;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	public Item() {
		
	}
	public Item(Double preco,Integer codigo ,Integer codigoPedido,Double desconto) {
		this.preco = preco;
		this.codigo = codigo;
		this.codigoPedido = codigoPedido;
		this.desconto = desconto;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [codigo=");
		builder.append(codigo);
		builder.append(", CodigoPedido=");
		builder.append(codigoPedido);
		builder.append(", preco=");
		builder.append(preco);
		builder.append(", desconto=");
		builder.append(desconto);
		builder.append("]");
		return builder.toString();
	}

	
}


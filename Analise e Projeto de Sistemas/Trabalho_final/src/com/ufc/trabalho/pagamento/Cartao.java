package com.ufc.trabalho.pagamento;

import com.ufc.trabalho.entidades.Pedido;

public class Cartao implements FormaPagamento{
	private Integer codigo;
	private String descricao;
	
	
	public Cartao(Integer codigo, String descricao){
		setCodigo(codigo);
		setDescricao(descricao);
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	private void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public boolean pagar(Pedido pedido,Double valor) {
		if(valor.doubleValue() >= pedido.getValor().doubleValue()) {
			Double c = valor.doubleValue() - pedido.getValor().doubleValue();
			 System.out.printf("Seu troco é : %f %n",c.doubleValue());
			 return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cartao [codigo=");
		builder.append(codigo);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append("]");
		return builder.toString();
	}

	
}

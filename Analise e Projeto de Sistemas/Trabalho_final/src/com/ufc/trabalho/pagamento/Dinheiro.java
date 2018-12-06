package com.ufc.trabalho.pagamento;

import com.ufc.trabalho.entidades.Pedido;

public class Dinheiro implements FormaPagamento{
	private Integer codigo;
	private String descricao;
	
	public Dinheiro(Integer codigo,String descricao) {
		setDescricao(descricao);
		setCodigo(codigo);
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getCodigo() {
		return codigo;
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
			System.out.println("Pagamento não concluído :( ");
			return false;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dinheiro [codigo=");
		builder.append(codigo);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append("]");
		return builder.toString();
	}
	
	
}

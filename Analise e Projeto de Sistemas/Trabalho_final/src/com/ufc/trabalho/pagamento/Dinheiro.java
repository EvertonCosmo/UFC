package com.ufc.trabalho.pagamento;

import com.ufc.trabalho.entidades.Pedido;

public class Dinheiro implements FormaPagamento{
	private Integer codigo;
	private String descricao;
	
	public Dinheiro(String descricao) {
		this.codigo = codigo+1;
		setDescricao(descricao);
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
			 System.out.printf("Seu troco é : %f ",c.doubleValue());
			 return true;
		}
			System.out.println("Pagamento não concluído :( ");
			return false;
	}
}

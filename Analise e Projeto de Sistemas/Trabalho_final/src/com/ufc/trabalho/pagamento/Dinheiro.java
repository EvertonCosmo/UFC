package com.ufc.trabalho.pagamento;

import com.ufc.trabalho.entidades.Pedido;

public class Dinheiro implements FormaPagamento{
	private Integer codigo;
	private String descricao;
	
	public Dinheiro(Integer codigo,String descricao) {
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
	public void pagar(Pedido pedido,Double valor) {
		// pagamento em dinheiro
		
	}
}

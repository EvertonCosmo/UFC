package com.ufc.trabalho.pagamento;

import com.ufc.trabalho.entidades.Pedido;

public class StrategyContext {

	private FormaPagamento strategy;


	public StrategyContext(FormaPagamento strategy) {
		this.strategy = strategy;
	}

	public boolean efetuarPagamento( Pedido pedido,Double valor) {
		return strategy.pagar(pedido,valor);
	}

}

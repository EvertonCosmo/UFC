package com.ufc.trabalho.pagamento;

import com.ufc.trabalho.entidades.Pedido;

public class StrategyContext {

	private FormaPagamento strategy;


	public StrategyContext(FormaPagamento strategy) {
		this.strategy = strategy;
	}

	public void efetuarPagamento( Pedido pedido,Double valor) {
		strategy.pagar(pedido,valor);
	}

}

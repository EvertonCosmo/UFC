
package com.ufc.trabalho.pagamento;

import com.ufc.trabalho.entidades.Pedido;

public interface FormaPagamento {
	public boolean pagar(Pedido pedido,Double valor);
}

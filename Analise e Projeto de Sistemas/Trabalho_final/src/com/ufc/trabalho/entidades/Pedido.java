package com.ufc.trabalho.entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;



import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ufc.trabalho.pagamento.FormaPagamento;
import com.ufc.trabalho.pagamento.StrategyContext;
import com.ufc.trabalho.pessoa.PessoaFisica;


public class Pedido{

	private int codigo;
	private PessoaFisica clienteAssociado;
	private String dataPedido;
	private String dataPagamento;
	private String enderecoEntrega;
	private Double valor;
	private StrategyContext formaPagamento;
	private Calendar calendario = Calendar.getInstance();

	private List<Item> itens= new ArrayList<>();


	public List<Item> getItens() {
		return itens;
	}

		
	public Pedido(FormaPagamento pagamento, PessoaFisica cliente, Double valor,Item e) {
		this.formaPagamento = new StrategyContext(pagamento);
		this.clienteAssociado = cliente;
		this.valor = valor;
		this.itens.add(e);
		this.codigo ++;
		setEnderecoEntrega(cliente.getEndereco());
		// definindo data de pagamento automaticamente, daqui 15 dias da data atual
		calendario.add(Calendar.DAY_OF_MONTH,15);
		Date data = calendario.getTime();
		SimpleDateFormat formatar  = new SimpleDateFormat("dd/MM/yyyy");
		String dataPagamento = formatar.format(data);
		setDataPagamento(dataPagamento);
		
		calendario.add(Calendar.DAY_OF_MONTH,-15);
		Date dataNovo = calendario.getTime();
		String dataPedido = formatar.format(dataNovo);
		setDataPedido(dataPedido);
		

	}

	public StrategyContext getFormaPagamento() {
		return formaPagamento;
	}

	public List<Item> geItens() {
		return itens;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public PessoaFisica getClienteAssociado() {
		return clienteAssociado;
	}
	public void setClienteAssociado(PessoaFisica clienteAssociado) {
		this.clienteAssociado = clienteAssociado;
	}
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String  dataPedido) {
		this.dataPedido = dataPedido;
	}
	public String getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}
	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void adicionar(Object obj) {
		if(obj == null)
			return;
		if(obj instanceof Item) {
			itens.add((Item) obj);
		}
		return;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [codigo=");
		builder.append(codigo);
		builder.append(", clienteAssociado=");
		builder.append(clienteAssociado);
		builder.append(", dataPedido=");
		builder.append(dataPedido);
		builder.append(", dataPagamento=");
		builder.append(dataPagamento);
		builder.append(", enderecoEntrega=");
		builder.append(enderecoEntrega);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", formaPagamento=");
		builder.append(formaPagamento);
		builder.append(", itens=");
		builder.append(itens);
		builder.append("]");
		return builder.toString();
	}






}

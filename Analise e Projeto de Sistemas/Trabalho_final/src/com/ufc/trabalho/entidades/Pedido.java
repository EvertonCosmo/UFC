package com.ufc.trabalho.entidades;

import java.util.ArrayList;



import java.util.Calendar;
import java.util.List;

import com.ufc.trabalho.pagamento.FormaPagamento;
import com.ufc.trabalho.pagamento.StrategyContext;
import com.ufc.trabalho.pessoa.PessoaFisica;
import com.ufc.trabalho.repositorio.Item;


 public class Pedido implements Crud{

	private int codigo;
	private PessoaFisica clienteAssociado;
	private Calendar dataPedido;
	private Calendar dataPagamento;
	private String enderecoEntrega;
	private Double valor;
	private StrategyContext formaPagamento;

	private List<Item> itens= new ArrayList<>();


	public Pedido(FormaPagamento pagamento, PessoaFisica cliente, Double valor) {
		this.formaPagamento = new StrategyContext(pagamento);
		formaPagamento.efetuarPagamento(this, valor);
		this.clienteAssociado = cliente;
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
	public Calendar getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Calendar getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Calendar dataPagamento) {
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




	@Override
	public void adicionar(Object obj) {
		if(obj == null)
			return;
		if(obj instanceof Item) {
			itens.add((Item) obj);
		}
		return;
	}

	@Override
	public void remover(Integer codigo) {
		itens.forEach(a->{
			if(a.getCodigo() ==codigo )
				itens.remove(a);
		});


	}

	@Override
	public Object pesquisar(Object obj) {
		if(obj == null)
			return null;
		if(obj instanceof Perfume) {
			for (Item item : itens) {
				if(item.equals(obj)) {
					return item;
				}
			}
		}
		return null;
	}

	
	public void mostrarDados() {
		if(itens.isEmpty())
			return;
		itens.forEach(System.out::println);
	}

	
	@Override
	public void atualizar() {
		// TODO Auto-generated method stub

	}




}

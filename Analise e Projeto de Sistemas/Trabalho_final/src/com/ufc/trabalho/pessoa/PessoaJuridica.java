package com.ufc.trabalho.pessoa;

public class PessoaJuridica extends Cliente{

	protected String cnpj;
	protected String cpf;
		
	public String getCnpj() {
		return cnpj;
	}
	public String getCpf() {
		return cpf;
	}
	

	public PessoaJuridica(String nome,String cpf, String cnpj) {
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
	}
	
	public PessoaJuridica() {
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
//		builder.append("nome=");
		builder.append("[ ");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", cnpj=");
		builder.append(cnpj);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}

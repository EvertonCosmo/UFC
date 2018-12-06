package com.ufc.trabalho.pessoa;

public class PessoaFisica extends Cliente{ 

	private String cpf;

	public  String getCpf() {
		return cpf;
	}

	private PessoaFisica(PessoaFisicaBuilder builder) {
		this.cep = builder.cep;
		this.cidade = builder.cidade;
		this.cpf = builder.cpf;
		this.email = builder.email;
		this.endereco = builder.endereco;
		this.estado = builder.estado;
		this.nome = builder.nome;
		this.pedidos = builder.pedidos;
		this.telefone = builder.telefone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PessoaFisica [cpf=");
		builder.append(cpf);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append("]");
		return builder.toString();
	}

	public PessoaFisica() {}

	public static class PessoaFisicaBuilder extends Cliente{

		private String cpf;

		public PessoaFisicaBuilder(String nome, String cpf) {
			this.cpf = cpf;
			setNome(nome);
		} 

		public String getCpf() {
			return cpf;
		}

		public PessoaFisicaBuilder() {

		}

		public PessoaFisicaBuilder endereco(String endereco) {
			this.endereco = endereco;
			return this;
		}
		public PessoaFisicaBuilder cidade(String cidade) {
			this.cidade = cidade;
			return this;
		}
		public PessoaFisicaBuilder estado(String estado) {
			this.estado = estado;
			return this;
		}
		public PessoaFisicaBuilder cep(String cep) {
			this.cep = cep;
			return this;
		}
		public PessoaFisicaBuilder telefone(String telefone) {
			this.telefone = telefone;
			return this;
		}
		
		public PessoaFisicaBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		
		public PessoaFisica build(){
			return new PessoaFisica(this);
		}

		@Override
		public boolean equals(Object obj) {
			PessoaFisica p;
			if(obj instanceof Cliente) { 
				p = (PessoaFisica) obj;
				return this.getCpf().equals(p.getCpf());
			}else {
				return false;
			}

		}
	}

}


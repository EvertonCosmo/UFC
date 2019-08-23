package com.cosmo.everton.ufc.questao1;



public class CupomFiscal {

	private String nomeLoja;
	private String cnpj;
	private String cpfConsumidor;
	private String cnpjConsumidor;
	private double dinheiroRecebido;
	private Item listaItem[];


	private  CupomFiscal(CupomFiscalBuilder builder) {

		this.nomeLoja = builder.nomeLoja;
		this.cpfConsumidor = builder.cpfConsumidor;
		this.cnpjConsumidor = builder.cnpjConsumidor;
		this.dinheiroRecebido = builder.dinheiroRecebido;
		this.listaItem = builder.listaItem;
		this.cnpj = builder.cnpj;

	}



	public String getNomeLoja() {
		return nomeLoja;
	}



	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getCpfConsumidor() {
		return cpfConsumidor;
	}



	public void setCpfConsumidor(String cpfConsumidor) {
		this.cpfConsumidor = cpfConsumidor;
	}



	public String getCnpjConsumidor() {
		return cnpjConsumidor;
	}



	public void setCnpjConsumidor(String cnpjConsumidor) {
		this.cnpjConsumidor = cnpjConsumidor;
	}



	public double getDinheiroRecebido() {
		return dinheiroRecebido;
	}



	public void setDinheiroRecebido(double dinheiroRecebido) {
		this.dinheiroRecebido = dinheiroRecebido;
	}
	
	public Item[] getListaItem() {
		return listaItem;
	}


	public static class CupomFiscalBuilder{


		private String nomeLoja;
		private String cnpj;
		private String cpfConsumidor;
		private String cnpjConsumidor;
		private double dinheiroRecebido;
		private Item listaItem[];


		public CupomFiscalBuilder (String nome,String cnpj) {
			this.nomeLoja = nome; 
			this.cnpj = cnpj;

		}
		public CupomFiscalBuilder cnpjConsumidor(String cnpjConsumidor) {
			this.cnpjConsumidor = cnpjConsumidor;
			return this;
		}

		public CupomFiscalBuilder cpfConsumidor(String cpfConsumidor) {
			this.cpfConsumidor = cpfConsumidor; 
			return this;
		}

		public CupomFiscalBuilder dinheiroRecebido(double dinheiroRecebido) {
			this.dinheiroRecebido = dinheiroRecebido; 
			return this;
		}
		public CupomFiscalBuilder listaItem(Item listaItem[]) {
			this.listaItem = listaItem;
			return this;
		}

		public CupomFiscal criar() {
			return new CupomFiscal(this);
		}

	}

}

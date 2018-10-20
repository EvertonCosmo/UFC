package com.cosmo.everton.pessoa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PessoaJuridica extends Pessoa{

	private String cnpj;
	private Date datacriacao;




	public PessoaJuridica(String cnpj, Date datacriacao,String nome) {
		this.cnpj = cnpj;
		if(!validarDocumento()) {

			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("cnpj inválido,objeto não adicionado");
			}

		}

		super.setNome(nome);
		this.cnpj = cnpj;
		this.datacriacao = datacriacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDatacriacao() {
		return datacriacao;
	}



	@Override
	public String toString() {
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(datacriacao);

		StringBuilder builder = new StringBuilder();
		builder.append("PessoaJuridica [cnpj=");
		builder.append(cnpj);
		builder.append(", datacriacao=");
		builder.append(dataFormatada);
		builder.append(", Nome=");
		builder.append(getNome());
		builder.append("]");
		return builder.toString();
	}

	public void setDatacriacao(Date datacriacao) {
		this.datacriacao = datacriacao;
	}

	@Override
	public boolean equals(Object obj) {
		PessoaJuridica p; 
		if(obj instanceof PessoaJuridica) { 
			p = (PessoaJuridica)obj;
			return this.getCnpj().equals(p.getCnpj());	
		}else {
			return false;
		}
	}


	@Override
	public boolean validarDocumento() {
		Pattern padrao =  Pattern.compile("^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$");
		if(this.cnpj.length() == 18) {
			try {
				Matcher matcher = padrao.matcher(this.cnpj);
				return matcher.matches();
			}catch(Exception e) {
				return false;
			}


		}

		return false;
	}


	@SuppressWarnings("deprecation")
	/* descontinuado o uso da classe Date, mas como estava no pdf
	 * optei por usar 
	 */
	@Override
	public int calcularIdade() {

		Calendar data = Calendar.getInstance();
		Date dataAtual = data.getTime();

		return dataAtual.getYear() - datacriacao.getYear();

	}
}

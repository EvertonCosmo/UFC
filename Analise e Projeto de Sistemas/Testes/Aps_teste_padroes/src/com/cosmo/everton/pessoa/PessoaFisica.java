package com.cosmo.everton.pessoa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PessoaFisica extends Pessoa{

	private String cpf;
	private Date dataNascimento;


	public PessoaFisica(String cpf, Date dataNascimento,String nome) {
		this.cpf = cpf;

		if(!validarDocumento()) {

			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("cpf inválido,objeto não adicionado");


			}

		}else {

			super.setNome(nome);
			this.cpf = cpf;
			this.dataNascimento = dataNascimento;
		}


	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	@Override
	public boolean equals(Object obj) {
		PessoaFisica p;
		if(obj instanceof PessoaFisica) { 
			p= (PessoaFisica) obj;
			return this.getCpf().equals(p.getCpf());
		}else {
			return false;
		}


	}



	@Override
	public  boolean validarDocumento() {
		Pattern padrao =  Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");

		if(this.cpf.length() == 14) {
			Matcher matcher = padrao.matcher(this.cpf);
			return matcher.matches();
		}


		return false;

	}







	@Override
	public String toString() {

		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento);

		StringBuilder builder = new StringBuilder();
		builder.append("PessoaFisica [cpf=");
		builder.append(cpf);
		builder.append(", dataNascimento=");
		builder.append(dataFormatada);
		builder.append(", Nome=");
		builder.append(getNome());
		builder.append("]");
		return builder.toString();

	}



	@SuppressWarnings("deprecation")
	/* descontinuado o uso da classe Date, mas como estava no pdf
	 * optei por usar 
	 */
	@Override
	public int calcularIdade() {
		Calendar data = Calendar.getInstance();
		Date dataAtual = data.getTime();

		if(dataNascimento == null) {
			System.out.println("não foi possível calcular a idade");
			return -1;
		}

		return dataAtual.getYear() - dataNascimento.getYear();
	}



}

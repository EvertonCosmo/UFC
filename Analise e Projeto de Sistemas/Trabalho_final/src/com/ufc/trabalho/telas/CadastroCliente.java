package com.ufc.trabalho.telas;

import com.ufc.trabalho.controle.Command;
import com.ufc.trabalho.controle.Fachada;
import com.ufc.trabalho.pessoa.PessoaFisica;

public class CadastroCliente extends TratamentoDados implements Command{

	@Override
	public void execute() {
		System.out.println("TELA CADASTRO");
		System.out.println();
		String nome =lerString("Digite seu nome: ");
		String cpf = lerString("Digite o cpf: ");
		String cidade = lerString("Cidade: ");
		String endereco = lerString("Logradouro: ");
		String cep = lerString("Cep: ");
		String estado = lerString("Estado: ");
		String telefone = lerString("Telefone");
		String email = lerString("Email");
		
		Fachada.adicionarCliente(
				new PessoaFisica.PessoaFisicaBuilder(nome,cpf)
				.cidade(cidade)
				.cep(cep)
				.estado(estado)
				.telefone(telefone)
				. email(email)
				.endereco(endereco)
				.build()
				);
				
		System.out.println("Cadastrado com sucesso !");
	}

	public void  cadastro() {
		
	}
}

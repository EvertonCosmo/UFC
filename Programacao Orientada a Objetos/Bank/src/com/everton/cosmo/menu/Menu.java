package com.everton.cosmo.menu;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;



import com.cosmo.everton.entitys.Account;
import com.cosmo.everton.repository.Bank;

public class Menu extends TreatmentInput{
	private static Scanner scan = new Scanner(System.in);
	
	public static void menuInitial() throws ParseException, IOException {
		//clearScreen();
		System.out.println(systemName()); 
		int op=0;
		do {
			System.out.println("||=======================================||");
			System.out.println("||       === BANK SYSTEM ====            ||");
			System.out.println("|| (1) -> ADICIONAR CONTAS               ||");
			System.out.println("|| (2) -> SACAR                          ||");
			System.out.println("|| (3) -> DEPOSITAR                      ||");
			System.out.println("|| (4) -> REALIZAR TRANSFERÊNCIAS        ||");
			System.out.println("|| (5) -> EMITIR SALDO                   ||");
			System.out.println("|| (6) -> EMITIR EXTRATO                 ||");
			System.out.println("|| (7) -> EXCLUIR CONTAS                 ||");
			System.out.println("|| (8) -> LISTAR CONTAS                  ||");
			System.out.println("|| (9) -> EXIT                           ||");
			System.out.println("||=======================================||");
			System.out.print(">>");

			try {
				op = scan.nextInt();

			}catch (InputMismatchException e) {
				System.out.println("Digite somente números");
				System.exit(0);
			}



			switch(op) {
			case 1:
				int number = readDataInteger("Digite o número da conta: ");

				Account d = Bank.searchAccount(number); // Search Account 

				if(d == null) {
					
					String name = readDataString("Digite o nome do titular da conta: ");
					
					while(containsNumber(name)) {
						
						System.out.println("apenas letras no nome do titular");
						name = readDataString("Digite o nome do titular da conta: ");
					}

					double balance = parseDouble(readDataString("Digite o saldo da conta: "));

					String special = readDataString("Conta especial ? (S or N): ");

					if(special.length() == 1) {

						if(special.charAt(0) == 'S' || special.charAt(0) == 's' || special.charAt(0) =='N' || special.charAt(0) =='n') {

							Bank.createAccount(new Account(number, name, balance, true, special, parseDouble(readDataString("Digite o limite da conta: "))));
							break;

						}else {
							System.err.println("Valor inválido. digite (S) ou (N)");
						}
					}


				}else {
					System.err.println("Já existe uma conta com esse número");
				}
				break;


			case 2:

				if(Bank.getAccounts().isEmpty()) {
					System.err.println("Não existem contas cadastradas ainda");
					menuInitial();
				}


				Account c = Bank.searchAccount(readDataInteger("Digite o número da conta sacar ")); 

				if(c == null) {
					System.err.println("erro! conta não encontrada ");
					menuInitial();
					
				}else if(!c.isStatus()) {
					System.err.println("Conta removida/desativada, impossível movimentar");
					menuInitial();
				}

				Bank.draw(c, parseDouble(readDataString("Valor: ")));
				break;

			case 3:

				if(Bank.getAccounts().isEmpty()) {
					System.out.println("Não existem contas cadastradas ainda");
					menuInitial();
				}
				// Search account for action(Draw or deposit) 
				Account account = Bank.searchAccount(readDataInteger("Digite o número da conta sacar ")); 

				if(account == null) {
					System.err.println("erro! conta não encontrada ");
					menuInitial();
				}else if(!account.isStatus()) {
					System.err.println("Conta removida/desativada, impossível movimentar");
					menuInitial();
				}

				Bank.draw(account, parseDouble(readDataString("Valor: ")));
				break;
			case 4:

				if(Bank.getAccounts().isEmpty()) {
					System.err.println("Não existem contas cadastradas ainda");
					menuInitial();
				}

				int numberAccount = readDataInteger("Digite o número da conta de origem");
				Account c1 = Bank.searchAccount(numberAccount);

				if(c1 == null) {
					System.err.println("conta de origem não existe");
					menuInitial();
				}
				else 
					if(!c1.isStatus()) {
						System.err.println("Conta removida/desativa, impossível movimentar");
						menuInitial();
					}
				int numberAccount2 = readDataInteger("Digite o número da conta de destino");
				Account c2 = Bank.searchAccount(numberAccount2);

				if(c2 == null) {
					System.err.println("conta de destino não existe");
					menuInitial();
				}
				else 
					if(!c2.isStatus()) {
						System.err.println("Conta removida/desativa, impossível movimentar");
						menuInitial();
					}

				if(c1 == c2) {
					System.err.println("Operação impossível com a mesma conta !"); // 
					menuInitial();
				}

				//double valueTransfer = ;

				Bank.transferValue(c1, c2, parseDouble(readDataString("Valor: ")));
				
				break;


			case 5:

				if(Bank.getAccounts().isEmpty()) {
					System.err.println("Não existem contas cadastradas ainda");
					menuInitial();
				}

				Bank.balanceIssue(readDataInteger("Digite o número da conta para emitir saldo "));

				break;

			case 6:

				if(Bank.getAccounts().isEmpty()) {
					System.err.println("Não existem contas cadastradas ainda");
					menuInitial();
				}
				
				Bank.ExtractIssue(readDataInteger("Digite o número da conta para emitir extrato "));
				break;

			case 7:

				if(Bank.getAccounts().isEmpty()) {
					System.err.println("Não existem contas cadastradas ainda");
					menuInitial();
				}
				
				Bank.removeAccount(readDataInteger("Digite o número da conta para remover "));
				break;
			case 8:

				Bank.showAccounts();break;

			case 9:

				System.exit(0);
			default:

				System.err.println("Erro!, valor indisponível\n");Menu.menuInitial();

			}
		}while(op !=0);

		scan.close();
	}
}



// tratamento de entradas




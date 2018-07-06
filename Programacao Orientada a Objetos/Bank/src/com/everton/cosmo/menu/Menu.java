package com.everton.cosmo.menu;


import java.util.InputMismatchException;
import java.util.Scanner;



import com.cosmo.everton.entitys.Account;
import com.cosmo.everton.repository.Bank;

public class Menu {
	private static Scanner scan = new Scanner(System.in);

	public static void menuInitial() {
		int op=0;
		do {
			System.out.println("=== BANK SYSTEM ====");
			System.out.println("1 -> ADICIONAR CONTAS ");
			System.out.println("2 -> BUSCAR CONTAS E REALIZAR SAQUES/DEPÓSITOS");
			System.out.println("3 -> REALIZAR TRANSFERÊNCIAS");
			System.out.println("4 -> VER SALDOS E EXTRATOS");
			System.out.println("5 -> EXCLUIR CONTAS");
			System.out.println("6 -> LISTAR CONTAS ATIVAS E INATIVAS");
			System.out.println("7 -> EXIT");
			System.out.println(">>");

			try {
				op = scan.nextInt();

			}catch (InputMismatchException e) {
				System.out.println("Digite somente números");
				System.exit(0);
			}



			switch(op) {
			case 1:
				int number = readDataInteger("Digite o número da conta: ");

				Account d = Bank.searchAccount(number);
				if(d == null) {


					String name = readDataString("Digite o nome do titular da conta: ");
					while(containsNumber(name)) {
						System.out.println("apenas letras no nome do titular");
						name = readDataString("Digite o nome do titular da conta: ");
					}

					double balance = readDataDouble("Digite o saldo da conta: ");



					//boolean status = readDataBoolean("Digite o status da conta(ativa ou inativa) true = ativa \\ false = inativa");

					boolean special = readDataBoolean("Conta especial ? (true ou false): ");

					double limit = readDataDouble("Digite o limite da conta: ");

					Bank.createAccount(new Account(number, name, balance, true, special, limit));

				}else {
					System.out.println("Já existe uma conta com esse número");
				}
				break;


			case 2:
				if(Bank.getAccounts().isEmpty()) {
					System.out.println("Não existem contas cadastradas ainda");
					menuInitial();
				}

				int numberDraworDeposit = readDataInteger("Digite o número da conta para depositar ou sacar ");


				Account c = Bank.searchAccount(numberDraworDeposit); // Search account for action(Draw or deposit) 

				if(c == null) {
					System.out.println("erro! conta não encontrada ");
					menuInitial();
				}else if(!c.isStatus()) {
					System.out.println("Conta removida/desativada, impossível movimentar");
					menuInitial();
				}


				System.out.println("Saque[1],Depositar[2]: ");

				int valueRead = readDataInteger("Digite: ");

				switch(valueRead) {
				case 1:
					double valueDoubleDraw = readDataInteger("valor a sacar");
					Bank.draw(c, valueDoubleDraw);
					break;
				case 2:
					double valueDoubleDeposit = readDataDouble("valor a depositar");
					Bank.deposit(c, valueDoubleDeposit);
					break;
				default:	
					System.out.println("opção inválida");
				}

				break;
			case 3:

				if(Bank.getAccounts().isEmpty()) {
					System.out.println("Não existem contas cadastradas ainda");
					menuInitial();
				}

				int numberAccount = readDataInteger("Digite o número da conta de origem");

				int numberAccount2 = readDataInteger("Digite o número da conta de destino");

				if(numberAccount == numberAccount2) {
					System.out.println("Operação impossível com a mesma conta !"); // 
					return;
				}
				Account c1 = Bank.searchAccount(numberAccount);

				if(c1 == null) 
					System.out.println("conta de origem não existe");
				else 
					if(!c1.isStatus()) {
						System.out.println("Conta removida/desativa, impossível movimentar");
						menuInitial();
					}

				Account c2 = Bank.searchAccount(numberAccount2);

				if(c2 == null)
					System.out.println("conta de destino não existe");
				else 
					if(!c2.isStatus()) {
						System.out.println("Conta removida/desativa, impossível movimentar");
						menuInitial();
					}


				double valueTransfer = readDataDouble("valor: ");

				Bank.transferValue(c1, c2, valueTransfer);



				break;


			case 4:
				if(Bank.getAccounts().isEmpty()) {
					System.out.println("Não existem contas cadastradas ainda");
					menuInitial();
				}

				int numberIssue = readDataInteger("Digite o número da conta para emitir saldo e extrato ");

				Bank.balanceIssue(numberIssue);


				break;

			case 5:
				if(Bank.getAccounts().isEmpty()) {
					System.out.println("Não existem contas cadastradas ainda");
					menuInitial();
				}


				int numberRemove = readDataInteger("Digite o número da conta para remover ");

				Bank.removeAccount(numberRemove);
				break;

			case 6: Bank.showAccounts();break;

			case 7: System.exit(0);

			default:
				System.out.println("Erro!, valor indisponível");Menu.menuInitial();

			}
		}while(op !=0);

		scan.close();
	}




	// tratamento de entradas



	public static int readDataInteger(String message) {
		System.out.println(message);
		int value = -1;
		try {
			value =scan.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("valor inválido. Digite outro");
		}
		scan.nextLine();
		while(value == -1)
			value = readDataInteger(message);
		return value;
	}


	public static boolean containsNumber(String s) {

		boolean value=true;
		for (int i = 0; i < s.length(); i++) {
			if(!Character.isDigit(s.charAt(i))) {
				value = false;
			}else {
				value = true;
			}
		}
		return value;
	}
	public static String readDataString (String message) {
		System.out.println(message);
		return scan.nextLine();
	}

	public static double readDataDouble(String message) {
		System.out.println(message);
		double value = -1.0;
		try {
			
			value = scan.nextDouble();
		
		}catch(InputMismatchException e) {
			System.out.println("valor inválido. Digite outro");
		}
		
		scan.nextLine();
		
		while(value == -1.0)
			value = readDataInteger(message);
		return value;
	}


	public static boolean readDataBoolean(String message) {
		System.out.println(message);
		return scan.nextBoolean();

	}
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
}
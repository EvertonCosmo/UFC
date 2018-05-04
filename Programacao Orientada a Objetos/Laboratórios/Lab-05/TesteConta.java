class TestaConta{
    public static void main(String args[]){

            Conta  continha = new Conta();
            Banco banquinho = new Banco();

            TesteAtualizacao ta = new TesteAtualizacao(0.10);

            Conta cp = new ContaPoupanca(); // 0

            Conta cc = new ContaCorrente();//1

            //Conta cosmo = new ContaCorrente();//2


             cp.saldo = 100;
             cc.saldo=300;
             cc.sacar(100);

             cp.depositar(500); //Conta poupanca, deposita menos 0.10

            // System.out.println(continha.getSaldo());
            //  continha.sacar(50);
            //  System.out.println(continha.getSaldo());
            //  continha.depositar(50);
            //  System.out.println(continha.getSaldo());

            // cp.depositar(30);
            // System.out.println("Conta Poupança: "+ cp.getSaldo());
            banquinho.adiciona(cp);//Conta0
            banquinho.adiciona(cc);//Conta1
            //banquinho.adiciona(cosmo);//Conta2
            //ID's 
          

           System.out.println("Quantidade de contas: "+ banquinho.getQuantidadeDeContas());
           System.out.println("ContaCP: "+banquinho.getConta(0).saldo);//Conta0
           System.out.println("ContaCC: "+banquinho.getConta(1).saldo);//Conta1

          // System.out.println("NumeroConta: "+banquinho.getNumeroConta());

            //cc.
            //ta.roda(cp);

    }
}
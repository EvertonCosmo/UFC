public class Banco{
    private Conta contas[] = new Conta[100];
    private int quantidadeDeContas=0;


    public void adiciona(Conta c ){    

            contas[quantidadeDeContas++] = c;
             
    }
        //OK

    public Conta getConta(int x){//X -> Número da conta

          return contas[x];
    }

    public int getQuantidadeDeContas(){
            return quantidadeDeContas;
    }


}
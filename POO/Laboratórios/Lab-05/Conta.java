public class Conta{

    protected  double saldo;


    // Conta(double saldo) {
    //     this.saldo = saldo;
    // }

     double getSaldo(){
        return saldo;
    }

    public void depositar(double quantia){
        saldo = saldo + quantia;
        

    }
    public void sacar(double quantia){
        //verificação de sacar

        this.saldo = saldo - quantia; 

    }
    //de acordo com taxa percentual 
    public void atualizarSaldo(double percentual ){
        saldo = saldo + (saldo * (percentual/100));
    }
}


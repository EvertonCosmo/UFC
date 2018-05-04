public class ContaPoupanca extends Conta{

@Override 
    public void atualizarSaldo(double taxa){
        super.atualizarSaldo(3*taxa);
      //  saldo = saldo + (saldo *(3*(taxa/100)));
    }
@Override
    public void  depositar(double quantia){
        super.depositar(quantia-0.10);
      //  saldo  = (saldo + quantia) - 0.10;
        
       
        
    }


}
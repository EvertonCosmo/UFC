public class ContaCorrente extends Conta{

   
@Override 
    public void atualizarSaldo(double taxa){
        super.atualizarSaldo(2*taxa);
        //saldo = saldo + saldo *(2*(taxa/100));
    }

}
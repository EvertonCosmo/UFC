public class ContaCorrenteEsp extends ContaCorrente{
// Corrente Especial
    ContaCorrenteEsp(double saldo){
        super(saldo);
        this.saldo = saldo;

    }

    @Override
    public void sacar(double quantia){
        this.saldo = saldo - quantia;
        this.saldo = saldo - quantia*(0.1/100);
    }

   

    
}
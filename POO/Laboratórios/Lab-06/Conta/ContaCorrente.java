class ContaCorrente{
    
    protected double saldo;
    
   ContaCorrente(double saldo){
        this.saldo = saldo;
   }
    public void depositar(double quantia){
    
        this.saldo = saldo + quantia;

    }
    public void sacar(double quantia){

        this.saldo = saldo - quantia;
        this.saldo = saldo - quantia*(0.5/100);
        
    }


    public double getSaldo(){
        return saldo;
    }
}
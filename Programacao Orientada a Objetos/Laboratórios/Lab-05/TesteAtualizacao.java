public class TesteAtualizacao{

    private double saldoTotal=0;
    private double selic;

    public TesteAtualizacao(double selic){
        this.selic = selic;
    }
    public void roda(Conta c ){
        System.out.println(c.getSaldo());
        c.atualizarSaldo(selic);
        System.out.println(c.getSaldo());
        saldoTotal += c.getSaldo();
    }

    public double getSaldoTotal(){
        return saldoTotal;
    }

}
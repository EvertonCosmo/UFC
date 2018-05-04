class Main{
    public static void main(String[] args){
        
        ContaCorrente cc = new ContaCorrente(400.0);
        ContaCorrente ce = new ContaCorrenteEsp(400.0);

        cc.sacar(200.0);
        ce.sacar(200.0);

        System.out.println("CC " + cc.getSaldo());
        System.out.println("CE "+ce.getSaldo());
    }
}
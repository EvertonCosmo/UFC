class Cliente extends Pessoa implements Imprimivel{
    private int codigo;

  
    Cliente(String nome, Data nascimento, int codigo){
        super(nome,nascimento);
        this.codigo =codigo;
    }
    @Override
    public String toString() {
        return "codigo: "+ codigo;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Cliente){
            Cliente p = (Cliente) o;
             return this.codigo == p.codigo;
        }
        return false;
    }

    @Override
    public void imprimeDados() {
       System.out.println("CLIENTE");
       System.out.println("Nome: "+super.nome);
       System.out.println("Nascimento: "+super.nascimento.formatar());
       System.out.println("Codigo Cliente: "+this.codigo);
       System.out.println();
       
    }
    

    
}
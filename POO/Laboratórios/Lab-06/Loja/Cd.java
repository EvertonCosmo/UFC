class Cd extends Produto {
    private int faixas;


    Cd(String nome, double preco, int numFaixas,int codBarra){
        super(nome,preco,codBarra);
        this.faixas = numFaixas;
    }
    @Override
    public String toString() {
  
        // return "nome: "+ nome+ " Preco: " +super.preco+" numero faixas: " +faixas;
        return "preco: "+super.preco;
    }
 
}
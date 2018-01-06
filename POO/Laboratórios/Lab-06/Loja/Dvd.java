 class Dvd extends Produto{
    private int duracao;
    Dvd(String nome, double preco, int duracao,int codBarra){
        super(nome,preco,codBarra);
        this.duracao = duracao;
        
    }
    
    @Override
    public String toString() {
        
        // return "nome: "+ nome + " preco: " +preco +" Duração : " +duracao;
        return "preco: "+super.preco;
    }
    

}
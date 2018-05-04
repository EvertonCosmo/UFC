class Livro extends Produto {
    private String autor;

    Livro(String nome, double preco, String autor,int codBarra){
        super(nome,preco,codBarra);
        this.autor = autor;
    }
    
    @Override
    public String toString() {
       
        // return "nome: "+ nome+ " Preco: " +super.preco + " autor: "+autor;
        return "preco: "+super.preco;
    }
  
    
}
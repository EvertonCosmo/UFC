abstract class Produto implements Comparable{
    protected String nome;
    protected double preco;
    protected int codBarra;
    
    Produto(String nome, double preco,int codBarra){
        this.nome = nome;
        this.preco = preco;
        this.codBarra = codBarra;
    }
   
   


     //POR NOME
    // public int compareTo(Object o) {
    //     if(o instanceof Produto){
    //         Produto p = (Produto)o;
    //         // return this.nome.compareTo(((Produto)o).nome);
    //         if(this.nome.equals(p.nome)){ //Se nomes iguais return 1;   
    //             return 1;
    //         }
    //     }
    //     return 0;
    // }
    @Override
    public int compareTo(Object o) {
        return this.toString().compareTo(o.toString());
    }
    
    //POR PREÇO
  // @Override
    // public int compareTo(Object o) {
    //     if(o instanceof Produto){
    //         Produto p = (Produto)o;
    //         if(this.preco == p.preco){
    //             return 1;
    //         }
            
    //     }
        
        
    

}
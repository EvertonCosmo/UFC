 class Loja{

    public static void main(String[] args) {
        CadastroProdutos cad = new CadastroProdutos();
       
        Cd cdezinho = new Cd("cesley",4,3,2);
        Cd cd = new Cd("wesley",2,4,3);
        Dvd dv = new Dvd("Pablo",3,1,22);
        Livro livrao = new Livro("Cronicas", 5, "H.C", 13);
        Dvd dvd = new Dvd("Calypson", 1, 10, 14);

        cad.adiciona(dvd);
        cad.adiciona(dv);
        cad.adiciona(cd);
        cad.adiciona(cdezinho);
        cad.adiciona(livrao);
        

        System.out.println(cad.equals(cd));
        
        System.out.println("Busca: "+buscar(cad.getQtdProdutos(),cad.getProdutos(),cd));

        cad.imprimir();
        System.out.println();
        System.out.println("Valor Comparable: " +cd.compareTo(cdezinho));
        
            
        System.out.println();
        //System.out.println(geraVetor());
       
        //cad.imprimirVetor();

       
        System.out.println();
        System.out.println("=======ORDENAR=======");
        cad.ordenar();
       
        

        
        
    }

    private static int buscar(int qtd,Produto produtos[], Produto o){
        

            for(int i=0; i<qtd; i++){
                if(o instanceof Dvd){
                    Dvd p = (Dvd) o;
                    if(produtos[i].codBarra == p.codBarra){
                        return i;    
                    }
                    
                }
                else if(o instanceof Cd){
                    Cd p = (Cd) o;
                    if(produtos[i].codBarra == p.codBarra){
                        return i;    
                    }

                }else if(o instanceof Livro){
                    Livro p = (Livro) o;
                    if(produtos[i].codBarra == p.codBarra){
                        return i;    
                    }
                }
            }
            
            System.out.println("Não encontrado ");
            return -1;
    }

   



}
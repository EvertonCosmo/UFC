public class Item {
    private Parte parte;
    private int quantidade;
    
    Item(int quantidade, Parte parte){
        this.quantidade = quantidade;
    }
   public double calculaValor(Object o){

    if(o instanceof Motor){
        Motor p = (Motor) o;
        return  p.valor * (0.7*p.getPotencia()+0.003*p.getRpm());
    }else if(o instanceof Parafuso){
        Parafuso p = (Parafuso) o; 
        return p.valor *(3.14*(p.getDiametro()/2)*(p.getDiametro()/2)*p.getComprimento());
    }
    
        return 0;

    }
    

    @Override
    public String toString() {
        return "Quantidade: "+quantidade;
    }

    
}
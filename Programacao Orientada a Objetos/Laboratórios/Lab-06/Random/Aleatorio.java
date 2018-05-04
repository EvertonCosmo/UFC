
class Aleatorio{
    
    private java.util.Random rand = new java.util.Random();
    private static final int VALOR_MAXIMO_DEFAULT = 10;
    private int aleatorio;
    private static int valorMaximo;
    
    Aleatorio(int valorMaximo){
        
        this.valorMaximo = valorMaximo;
        aleatorio = rand.nextInt(valorMaximo);
        
        
    }

   Aleatorio(){
      this(VALOR_MAXIMO_DEFAULT);
   }    
   
   public int getAleatorio() {
       return aleatorio;
   }

   public  int renovar(){
     return aleatorio = rand.nextInt(valorMaximo);
      

    }
   
  
}

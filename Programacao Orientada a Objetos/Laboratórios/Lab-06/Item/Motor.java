public class Motor extends Parte{
    private float potencia;
    private float corrente;
    private int rpm;

    Motor(int cod,  String nome, float valor,float potencia, float corrente,int rpm){
       super(cod,nome,valor);
       this.potencia = potencia;
       this.corrente = corrente;
       this.rpm = rpm;
    }
    
    
     public float getPotencia() {
         return potencia;
     }
    
     public float getCorrente() {
         return corrente;
     }
     
     public int getRpm() {
         return rpm;
     }
   
}
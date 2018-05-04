public class Main{
    public static void main(String[] args) {
        Aleatorio l1 = new Aleatorio(10); 

       System.out.println("Imprimindo 10");

       for(int i=0; i<10; i++){
            Aleatorio l = new Aleatorio(10); 
            System.out.println(l.getAleatorio());
       }


        System.out.println();
        System.out.println(l1.getAleatorio());
        System.out.println(l1.renovar());
  
       
    }

}

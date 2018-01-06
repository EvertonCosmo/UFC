public class TestaItem{
    public static void main(String[] args) {
        Parte p = new Parte(1,"parteT",0);

        Parte motor = new Motor(12,"MotorA",400,500,2,200);
        Item item = new Item(2,motor);
        Parte parafuso = new Parafuso(13,"Dragão dos parafusos",10,30,2);

        System.out.println(item);
        System.out.println(motor);
        System.out.println(parafuso);

        System.out.println(item.calculaValor(parafuso));
        System.out.println(item.calculaValor(motor));

        System.out.println();

        

    }
}
public class Gerente extends Funcionario{
    private String area;
    
   Gerente(String nome, Data nascimento,String area,float salario){
       super(nome,nascimento,salario);
       this.area = area;
   }
   @Override
   public String toString() {
       return "area: " +area;
   }

   @Override    
   public boolean equals(Object o) {
       if(o instanceof Gerente){
           Gerente p = (Gerente) o;
            return this.area.equals(p.area);
       }
       return false;
   }



    @Override
    public void imprimeDados(){
        System.out.println("GERENTE");
        System.out.println("nome: "+super.nome);
        System.out.println("Data Nascimento: "+super.nascimento.formatar());
        System.out.println("Salário: "+super.getSalario());
        System.out.println("Area: "+ area);
        System.out.println();
    }
   
    @Override
    public float calculaImposto() {
        return super.getSalario() * 0.05f;
    }

}
public abstract class Pessoa implements Imprimivel{
    String nome;
    Data nascimento;
  
   Pessoa(String nome, Data nascimento){
        this.nome = nome;
        this.nascimento=nascimento;
   }
    @Override
    public void imprimeDados(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Data: "+this.nascimento.formatar());

    }

}
class Funcionario extends Pessoa implements Imprimivel{
    private float salario;

    Funcionario(String nome, Data nascimento, float salario){
        super(nome,nascimento);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Salario: " + salario;
    }

    public float calculaImposto() {
        return salario *0.03f;
        
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Funcionario){
            Funcionario p = (Funcionario) o;
             return this.salario == p.salario;
        }
        return false;
    }

    @Override
    public void  imprimeDados() {
        System.out.println("FUNCIONARIO");
        System.out.println("nome: "+super.nome);
        System.out.println("Data Nascimento: "+super.nascimento.formatar());
        System.out.println("Salário: "+salario);
        System.out.println();

        

    }
      
        

}
class Main{

 public static void main(String[] args) {

   
  
  // DATA
    Data date = new Data();;

    date.setDia(31);
    date.setMes(2);
    date.setAno(2012);


   Empresa emp = new Empresa();

   Funcionario f = new Funcionario("Cosmo");
   Funcionario f1 = new Funcionario("CosmoA");
   Funcionario f2 = new Funcionario("CosmoB");
   Funcionario f3 = new Funcionario("CosmoC");

   //Atribuir a empresa
    emp.adiciona(f);
    emp.adiciona(f1);

    
    f.setDepartamento("A");
    f.setSalario(2.450);
    f.setRg("37748829-12");
    f.setStatus(true);
    

    //STATUS
  //  f1.status=true;
  //  f.status=true;
  //  f2.status=false;

    System.out.println("Identificador: "+f.getIdentificador());
  //System.out.println("Funcionarios ativos: "+emp.funcionariosAtivos());

    System.out.println("Identificador: "+f1.getIdentificador());


    System.out.println("Identificador: "+f2.getIdentificador());

  
    System.out.println("Identificador: "+f3.getIdentificador());

    System.out.println();

    f.setdtInicio(date);//Passando data de inicio do tipo DATA

    System.out.println("<<<INFORMAÇÕES>>>");
    System.out.println();
    f.mostrar();


    // emp.setNome("Empresa");
    // System.out.println(emp.getNome());

    System.out.println();
     if(date.validarData()){
        System.out.println("DATA OK!");
    }else{
      System.out.println("DATA INVALIDA");
    }
  
  System.out.println("DATA BOOLEAN: "+date.validarData()); //TRUE = DATA CERTA, FALSE=DATA INVALIDA
 }


}

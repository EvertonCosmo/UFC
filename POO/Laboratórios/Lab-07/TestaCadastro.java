public class TestaCadastro{
    public static void main(String[] args) {
        //Datas
        Data date = new Data(12,4,1885);
        Data date1 = new Data(15,5,1895);
        Data date2 = new Data(17,12,1995);
        Data date3 = new Data(20,2,2000);
        Data date4 = new Data(29,4,1999);

        Pessoa cliente0 = new Cliente("Vitor",date,2);
        Pessoa funcionario0=new Funcionario("José",date1,900);
        Pessoa funcionario1=new Funcionario("Jos",date1,900);
        Pessoa gerente0 = new Gerente("Cosmo",date2,"N/A",2000);
        Pessoa gerente1 = new Gerente("Everton Cosmo",date2,"N/A",2000);
        Pessoa cliente1 = new Cliente("JV",date,3);

        

        CadastroPessoas cad = new CadastroPessoas();
        
       
        //cadastrando pessoas
        cad.CadastraPessoa(cliente0);
        cad.CadastraPessoa(funcionario0);
        cad.CadastraPessoa(gerente0);

        cad.CadastraPessoa(cliente1);
        cad.CadastraPessoa(funcionario1);
        cad.CadastraPessoa(gerente1);
        

    

        

        

    
        cad.imprimeCadastro();
        //toString()
        System.out.println("==toString()==");
        System.out.println("Cliente: "+cliente0);
        System.out.println("Funcionario: "+funcionario0);
        System.out.println("Gerente: "+gerente0);

        System.out.println("==Equals()==");

        System.out.println("Funcionario: "+funcionario0.equals(funcionario1));
        System.out.println("Gerente: "+gerente0.equals(gerente1));
        System.out.println("Cliente: "+cliente0.equals(cliente1));
        
    

    }
}
 class CadastroPessoas{
    private int qtdAtual;

    private Pessoa[] pessoas = new Pessoa[10];


    public void CadastraPessoa(Pessoa pessoa){
        this.pessoas[qtdAtual++] = pessoa;
        
    }
    

    public void imprimeCadastro(){

        for(int i=0; i<qtdAtual; i++){
            
            //System.out.println("Cadastrado " + i +  " "  +pessoas[i]);
            pessoas[i].imprimeDados();
            
        }

    }


}
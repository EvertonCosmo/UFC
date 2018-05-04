class Empresa{

	private String cnpj;
	private String nome;

	private Funcionario[] empregados= new Funcionario[10];

	private int qtdEmpregados=0;

	//GET & SET

	public String getCnpj(){
		return cnpj;
	}
	public void setCnpj(String cnpj){
		this.cnpj=cnpj;
	}

	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}


	/*END GET & SET*/
	int registroFuncionarios(){
		int j=0;

			for(int i=0; i<empregados.length; i++){
				if(empregados[i] != null){

						j++;

				}

			}

			return j;

	}

void adiciona(Funcionario empregado){
		empregados[qtdEmpregados++] = empregado;
		
		
}


int funcionariosAtivos(){
	int ativo=0;

	for(int i=0; i<qtdEmpregados; i++){

				if(	empregados[i].getStatus() == true)
					ativo++;


}

		return ativo;

	}
}

class Funcionario {
	private String nome;
	private String departamento;
	private double salario;
	private Data dtInicio;
	private String rg;
	private boolean status;
	//INT
	private static int identificador=1;

	Funcionario(String nome){
		this.setNome(nome);
	}
	public int getIdentificador(){
			return identificador++;		
	}

	//Nome
	public void setNome(String nome){
		this.nome = nome;
	}

	public String getNome(){
			return nome;
	}
	//Departamento 
	public void setDepartamento(String departamento){
		this.departamento = departamento;
	}

	public String getDepartamento(){
			return departamento;
	}
	//Sálario

	public void setSalario(double salario){
		this.salario = salario;
	}

	public double getSalario(){
			return salario;
	}


	//Data 

	public void setdtInicio(Data dtInicio){
		this.dtInicio = dtInicio;
	}

	public Data getdtInicio(){
			return dtInicio;
	}


	//RG


	public void setRg(String rg){
		this.rg = rg;
	}

	public String getRg(){
			return rg;
	}
	//Status
	public void setStatus(boolean status){
			this.status = status;
	} 
	public boolean getStatus(){
			return status;
	}



	void recebeAumento(double aumento) {
		salario += aumento;
	}

	double calculaGanhoAnual() {
		return 12 * salario;
	}

	void demitir() {
		status = false;
	}

	void transferir(String departamento) {
		this.departamento = departamento;
	}

	void mostrar() {
		System.out.println("Nome: " + nome);
		System.out.println("Departamento: " + departamento);
		System.out.println("Salário: " + salario);
		System.out.println("Data de Início: " + dtInicio.formatar());
		System.out.println("RG: " + rg);
		System.out.println("Status: " + status);
	}
}

class Data {
	private int dia;
	private int mes;
	private int ano;

	//GET & SET

	public int getDia(){
			return dia;
	}
	public void setDia(int dia){
		this.dia = dia;
	}

	public int getMes(){
		return mes;
	}
	public void setMes(int mes){
		this.mes = mes;
	}

	public int getAno(){
		return ano;

	}
	public void setAno(int ano){
		this.ano=ano;
	}


	String formatar() {
		return dia + "/" + mes + "/" + ano;
	}
	

	

	public boolean validarData(){

			if(dia > 31 || mes > 12){

					return false;

			}

			

			//Meses  30 dias 
			// 4  6  9 11

			//meses 31 dias
			// 1 3 5 7 8 10 12 --> Anos com 31 dias

			//Fevereiro




			//
			if(dia <= 30){
				if((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)){
					return true;
				}
			}
			if(dia <= 31){
				if((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)){
					return true;
				}
			}



			if(mes == 2){ //FEVEREIRO

				if(anoBissexto(ano)){ //Bissexto

						if(dia > 29){

							return false;

						}else if(dia <= 29){

							return true;
						}

				}else{
					if(dia > 28){

							return false;

						}else if(dia <= 28){

							return true;
						}
				}
				}



				
				return false;




			}
			
			

		

	public boolean anoBissexto(int ano){
			return (((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0 ));  
	}
}

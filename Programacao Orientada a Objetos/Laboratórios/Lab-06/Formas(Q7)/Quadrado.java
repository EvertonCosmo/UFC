class Quadrado extends Quadrilateros implements Forma{
	
	public Quadrado(double lado){
		super(lado,lado,lado,lado);
	}



	@Override
	public double calcularPerimetro(){
		return base1+base2+altura1+altura2;
	}

	@Override
	public double calcularArea(){
		return base1* altura1;
	}

	@Override
	public String toString(){
		return "Base Quadrado:" + base1+"\n"+"Altura Quadrado:"+altura1; 
	}

}
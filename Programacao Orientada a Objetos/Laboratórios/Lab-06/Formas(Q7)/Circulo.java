class Circulo implements Forma{
	double raio;


	public Circulo(double raio){
		this.raio = raio;
	}

	@Override
	public double calcularPerimetro(){
		return 2*raio*3.14;
	}

	@Override
	public double calcularArea(){
		return 3.14*(raio*raio);
	}

	@Override
	public String toString(){
		return "Raio:" + raio;
	}
}
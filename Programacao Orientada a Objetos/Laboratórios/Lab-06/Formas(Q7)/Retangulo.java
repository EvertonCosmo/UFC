class Retangulo extends Quadrilateros implements Forma{

	public Retangulo(double base, double altura){
		super(base,altura,base,altura);
	}

	@Override
	public double calcularPerimetro(){
		return 2*(base1 +altura1);
	}

	@Override
	public double calcularArea(){
		return base1* altura1;
	}

	@Override
	public String toString(){
		return "Base Retangulo"+ base1+"\n" +"Altura Retangulo"+ altura1;
	}

}
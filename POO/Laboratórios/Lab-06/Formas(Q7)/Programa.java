class Programa{
	public static void main(String [] args){
		

		Forma quadrado = new Quadrado(2);
		Forma retangulo = new Retangulo(2,2);
		Forma circulo = new Circulo(2);


		
		System.out.println("==Circulo==");
		System.out.println("Perimetro" + circulo.calcularPerimetro());
		System.out.println("Area" + circulo.calcularArea());


		System.out.println("==Quadrado==");


		System.out.println("Perimetro :" + quadrado.calcularPerimetro());
		System.out.println("Area :" + quadrado.calcularArea());
		
		System.out.println("==Retangulo==");
		System.out.println("Perimetro: " + retangulo.calcularPerimetro());
		System.out.println("Area: " + retangulo.calcularArea());
		
		

		Forma geometricas[] = new Forma[10];
		
		geometricas[0] = quadrado;
		geometricas[1] = retangulo;
		geometricas[2] = circulo;

		System.out.println();

		for (int i=0;i<3;i++){
			System.out.println("Area:");
			System.out.println(geometricas[i].calcularArea());
			System.out.println(); 
			System.out.println(geometricas[i].toString());
			System.out.println("O perimetro:");
			System.out.println(geometricas[i].calcularPerimetro());	

			
		}

		
		

		

	}
}


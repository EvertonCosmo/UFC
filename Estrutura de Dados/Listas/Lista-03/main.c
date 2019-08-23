#include <stdio.h>
#include <stdlib.h>
#include "lista.h"
int main(){
	Lista* m = cria();
	Lista* menor = cria();
	Lista* maior = cria();
	Lista* retirado = cria();
	Lista* l = cria();
	Lista* impares = cria();
	Lista* n = cria();
	Lista* soma = cria();
	
	
	m = insere(m,5);
	m = insere(m,4);
	m = insere(m,3);
	m = insere(m,2);
	m = insere(m,1);


	n = insere(n,5);
	n = insere(n,10);
	n = insere(n,6);
	n = insere(n,12);
	n = insere(n,18);

	 printf("Impressão da lista \n");
	 imprimir(m);
	 printf("\n");
	  printf("\n 	Número de células da lista: %d\n",numCelula(m));
	  //Menor valor 
	  printf("\nMenor valor");
	  menor = celulaMinima(m);
	   imprimir(menor);

	//  printf("\t maior valor");
	//  maior = celulaMaior(m);
	//  imprimir(maior);
	//  printf("\n");

	 
	 // printf("\n Retirado\n");
	 // retirado = retiraMaior(m);
	 // imprimir(retirado);
	 

//	 imprimir(m);
	// impares = listaImpar(m,NULL);
	 //imprimir(impares);
	 //imprimir(m);
	 // impares = Uniao(m,n);
	 printf("\n");

	  octal(0);
	   printf("\n");
	  // printf("Soma dos Impares");
	  // soma = somaImpares(m);
	  // imprimir(soma);
	 // printf("%d\n",hexadecimal(20) );
	 libera(m);
	 libera(menor);
	 libera(maior);
	 libera(retirado);
	 libera(impares);
	 libera(l);
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"
#include "operacoes.h"


void mostra_Menu();
void multiplicacao_lista();
void soma_listas();
void comparar_listas();
void quadrado_lista();
void impressao_listas();
void fatorial_lista();
void exponenciacao_lista();

int main(){

	
	Lista* m = cria();
	Lista* n = cria();
	

	int i=0;
	int op = 0;
	char* valor =(char*)malloc(sizeof(char));
	char* valor2 =(char*)malloc(sizeof(char));

	printf("valor 1: \n");
	scanf("%s",valor);


	for(; i < strlen(valor); i++){
		m = ler_numero(m,valor[i]);
	}

	/*------------------------------*/
	printf("valor 2: \n");

	scanf("%s",valor2);

	for(i=0; i < strlen(valor2); i++){
		n = ler_numero(n,valor2[i]);
	}

	free(valor);
	free(valor2);

	while(1){
		mostra_Menu();
		scanf("%d",&op);

		if(op == 7){
			
			libera(m);
			libera(n);
			
			break;
		}

		switch(op){
			case 1: 
				soma_listas(m,n);break;
			case 2: 
				comparar_listas(m,n);break;
			case 3: 
				quadrado_lista(m,n);break;
			case 4: 
				multiplicacao_lista(m,n);break;
			case 5: 
				fatorial_lista(m);break;
			case 6: 
				exponenciacao_lista(m,n);break;

		}

	}

	
	return 0;
}

void mostra_Menu(){
	
	

	printf("\n ==== BigInt === \n");
	printf("\n");
	printf("(1) ->  SOMAR AS LISTAS \n");
	printf("(2) ->  COMPARAR AS LISTAS  \n");
	printf("(3) ->  QUADRADO (n²)  \n");
	printf("(4) ->  MULTIPLICAÇÃO \n" );
	printf("(5) ->  FATORIAL \n" );
	printf("(6) ->  EXPONENCIAÇÃO \n" );
	printf("(7) ->  ENCERRAR APLICAÇÃO \n" );

	printf(">> ");
	

	

	
}
/* ====== FUNÇÕES DO MENU ======*/

void soma_listas(Lista* m, Lista* n){
	Lista* sum = cria();
	impressao_listas(m,n);
	printf("\n == SOMA === \n");
	sum = adicao(m,n);
	imprimir(sum);
	libera(sum);
}

void comparar_listas(Lista* m, Lista* n){
	
	impressao_listas(m,n);
	printf("\n == Comparacao === \n");
	int cmp = comparacao(m,n);
	printf("valor %d \n",cmp );


	
}
void quadrado_lista(Lista* m, Lista* n){
	Lista* quad = cria();
	impressao_listas(m,n);
	printf("\n == Quadrado === \n");
	quad = quadrado(m);
	imprimir(quad);
	libera(quad);
	
}
void multiplicacao_lista(Lista* m, Lista* n){
	Lista* mult = cria();
	impressao_listas(m,n);
	printf("\n == Multiplicação === \n");
	mult = multiplicacao(m,n);
	imprimir(mult);
	libera(mult);
	
}
void fatorial_lista(Lista* m){
	Lista* fat = cria();
	imprimir(m);
	printf("\n == Fatorial === \n");
	fat = fatorial(m);
	imprimir(fat);
	libera(fat);
}

void exponenciacao_lista(Lista* m){
	int segundo_valor = 0;
	Lista* expo = cria();
	printf("Digite um segundo valor para a exponenciacao: ");
	scanf("%d",&segundo_valor);
	imprimir(m);

	expo = exponenciacao(m,segundo_valor);
	imprimir(expo);
	libera(expo);
}

void impressao_listas(Lista* m, Lista* n){
	// Impressao das listas
	printf("LISTA 1 :");
	imprimir(m);
	printf("LISTA 2 :");
	imprimir(n);
}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "pilha.h"


#define N 50 


struct pilha{
	int n;
	char carac[N];
};

Pilha* pilha_cria(){
	Pilha* p = (Pilha*)malloc(sizeof(Pilha));
	p -> n = 0;
	return p;
	
}

// Empilha, fazer a função de pilha cheia
void pilha_push(Pilha* p,char v){
	if(pilha_cheia(p)){
		printf("pilha cheia.\n");
		exit(1);
	}

	p->carac[p->n] = v;
	p->n++;
}

// Desempilha
char pilha_pop(Pilha* p){
	char v ; 

	if(pilha_vazia(p)){
		printf("pilha vazia. \n");
		exit(1);
	}
	v = p->carac[p->n-1];
	p->n--;
	return v;

}

// Verifica pilha vazia 
int pilha_vazia(Pilha* p){
	return (p->n == 0);
}

int pilha_cheia(Pilha* p){
	return (p->n == N);
}

// libera a pilha 
void pilha_libera(Pilha* p){
	free(p);
}

char lista_primeiro(Pilha* p){
	return p->carac[p->n-1];
}

// Impressão

void pilha_imprime(Pilha* p){
	int i; 
	for(i=p->n-1;i>=0;i--){

		printf("%c\n",p->carac[i]);
	}
}
void pilha_imprime_inversa(Pilha* p){
	
	int i; 
	
	for(i=0; i < p -> n; i++){
		printf("%c\n",p->carac[i] );
	}


}
void palindrome(Pilha* p){
	char contraria[N];
	int cont = 0;
	int tam = 0;
	int j;
	int i;
	tam = strlen(p->carac);
	j = tam;
	tam++;
	j--;

	for(i=0;i<tam;i++){
		contraria[i] = p->carac[j];
		j--;
	}
	tam--;
	for(i=0; i<tam; i++){
		if(p->carac[i] != contraria[i]){
			cont = 1;
		}
	}
	if(cont == 1){
		printf("não é palindromo\n");
	}else{
		printf("palindromo\n");
	}
}
void pilha_elimina(Pilha* p,char c){
	// Pilha* aux;
	

}



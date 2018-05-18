#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"




struct pilha{
	Lista* topo;
};


Pilha* pilha_cria(){
	Pilha* p = (Pilha*)malloc(sizeof(Pilha));
	p -> topo = lista_cria();
	return p;
}

void pilha_push(Pilha* p, char v){
	p->topo = lista_insere(p->topo,v);

}

char pilha_pop(Pilha* p){
	char v;
	if(lista_vazia(p->topo)){
		printf("Pilha vazia\n");
		exit(1);
	}
	v = lista_primeiro_elemento(p->topo);
	p -> topo = lista_rm_primeiro(p->topo);
	return v;
}


int pilha_vazia(Pilha* p){
	return lista_vazia(p->topo);
}


void pilha_libera(Pilha* p){
	Lista* c = p-> topo;

	while(!lista_vazia(c)){
		Lista* t = acessa_proximo(c);
		free(c);
		c = t;

	}

	free(p);
}


char lista_primeiro(Pilha* p){
	return lista_primeiro_elemento(p->topo);
	
}



 // Impressão

void pilha_imprime(Pilha* p){
	Pilha* aux;
	aux = pilha_cria();

	while(!pilha_vazia(p)){
		char x = pilha_pop(p);
		pilha_push(aux,x);
		printf("%c ",x );
	}
	while(!pilha_vazia(aux)){
		pilha_push(p,pilha_pop(aux));
	}

	printf("\n");

}

void pilha_imprime_inversa(Pilha* p){
	Pilha* aux;

	aux = pilha_cria();

	while(!pilha_vazia(p)){

		char x = pilha_pop(p);
		pilha_push(aux,x);

	
	}

	while(!pilha_vazia(aux)){
		char x = pilha_pop(aux);

		pilha_push(p,x);

		printf("%c",x );

	}

	printf("\n");

}
void palindrome(Pilha* p){
	
}
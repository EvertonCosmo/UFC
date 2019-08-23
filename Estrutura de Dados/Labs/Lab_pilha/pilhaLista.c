#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "pilha.h"
#define MAX 50

struct lista{
	char v;
	struct lista *prox;
};

struct pilha{
	Lista *topo;
};

Pilha *pilha_cria(){
	Pilha *p;
	p = (Pilha*) malloc(sizeof(Pilha));
	p->topo = NULL;
	return p;
}

void pilha_push(Pilha *p, char v){
	Lista *l;
	l = (Lista*) malloc(sizeof(Lista));

    l->v = v;
    l->prox = p->topo;
    p->topo = l; 

}

char pilha_pop(Pilha *p){
	if(pilha_vazia(p)){
		printf("Erro!! Pilha vazia\n");
		exit(1);
	}

    char aux;
    aux = p->topo -> v;
    
	Lista *l = p->topo;

	p->topo = p->topo->prox;
	free(l);

	return aux;
}

int pilha_vazia(Pilha *p){
	return p->topo == NULL;
}

void pilha_libera(Pilha *p){
	Lista *aux = p->topo;

	while(aux != NULL){
		Lista *l = aux;
		aux = aux->prox;
		free(l);
	}

	free(p);
}

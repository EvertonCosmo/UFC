#include <stdio.h>
#include <stdlib.h>
#include "lista.h"



struct lista{
	char x;
	struct lista* prox;
};

Lista* lista_cria(){
	return NULL;
}

Lista* acessa_proximo(Lista* l){
	return l->prox;
}

Lista* lista_insere(Lista* l, char v){
	Lista* novo = (Lista*)malloc(sizeof(Lista));
	novo -> x = v;
	novo -> prox = l;
	return novo;
}

void lista_libera(Lista* l){

	while(l != NULL){
		Lista* aux =l;
		l = l->prox;
		free(aux);
	}

}

char lista_primeiro_elemento(Lista* l){
	if(lista_vazia(l)){
		printf("ERRO, lista vazia \n");
		exit(1);
	}

	return l -> x;
}

Lista* lista_rm_primeiro(Lista* l){
	Lista* p = l->prox;
	free(l);
	return p;
}

int lista_vazia(Lista* l){
	if(l == NULL){
		return 1;
	}else{
		return 0;
	}
}


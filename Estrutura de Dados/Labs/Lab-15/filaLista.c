#include <stdio.h>
#include <stdlib.h>
#include "lista.h"
#include "filaLista.h"

struct fila
{
	struct lista *ini;
	struct lista *fim;
};

Fila* fila_cria(){
	Fila *f = (Fila*)malloc(sizeof(Fila));
	f->ini = lista_cria();
	f->fim = lista_cria();

	return f;
}



void fila_insere(Fila *f, char v){
	

	Lista *aux = lista_insere(lista_cria(), v);

	setProx(f->fim, aux);

	if(lista_vazia(f->fim)){
		f->ini = aux;
	}
	else{
		
		setProx(f->fim, aux);
	}
	
	f->fim = aux;
}

char fila_retira(Fila *f){

	if(fila_vazia(f)){
		exit(1);
	}

	char aux = Lista_retorna_inicio(f->ini);

	f->ini = lista_remove_inicio(f->ini);

	return aux;
}

int fila_vazia(Fila *f){
	return lista_vazia(f->ini);
}

void fila_libera(Fila *f){
	lista_libera(f->ini);
	free(f);
}
void imprime_fila(Fila* f){
	Lista* v = f->ini;

	while(v !=NULL){
		printf("%c\n",Lista_retorna_inicio(v));
		v = acessa_proximo(v);
	}
}
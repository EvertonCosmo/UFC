
#include <stdio.h>
#include <stdlib.h>
#include "lista.h"

struct lista{ 
	struct lista* prox;
	struct lista* ant;
	char caractere;
};

Lista* cria(){
	return NULL;
}

Lista* insere(Lista* a, char n){
	Lista* b;
	Lista* aux = a;
	if(a == NULL){
		b = (Lista*)malloc(sizeof(Lista));
		b->prox = NULL;
		b->ant = NULL;
		b->caractere = n;
		return b;
	}
	while(aux->prox != NULL){
		aux = aux->prox;
	}
	b = (Lista*)malloc(sizeof(Lista));
	aux->prox = b;
	b->caractere = n;
	b->ant = aux;
	b->prox = NULL;
	return a;	
}

Lista* ad0noFinal(Lista* aux, int i){
	int x;
	for (x = 0; x < i; x++)
	{
		aux = insere(aux,'0');
	}
	return aux;
}

Lista* insere_inicio(Lista* a, char n){
	Lista* b;
	if(a == NULL){
		b = (Lista*)malloc(sizeof(Lista));
		b->prox = NULL;
		b->ant = NULL;
		b->caractere = n;
		return b;
	}
	if(a->ant == NULL){
		b = (Lista*)malloc(sizeof(Lista));
		b->prox = a;
		b->ant = NULL;
		a->ant = b;
		b->caractere = n;
		return b;
	}
}

void retiraUmNo(Lista* l){
	Lista* aux = l;
	if(l == NULL){
		return;
	}
	else if((l->ant==NULL)&&(l->prox==NULL)){
		free(l);
		l=NULL;
		return;
	}
	else if(aux->ant == NULL){
		l= l->prox;
		l->ant = NULL;
		free(aux);
		return;
	}
	else if(aux->prox == NULL){
		l=l->ant;
		l->prox = NULL;
		free(aux);
		return;
	}
	else{
		l=l->ant;
		l->prox = aux->prox;
		free(aux);
		aux=l->prox;
		aux->ant = l;
	}
	return;
}

Lista* busca(Lista* l,char c){
	if(l == NULL){
		return NULL;
	}

	Lista* p = l;
	while(p != NULL){
		if(p->caractere == c){
			return p;
		}
		p = p -> prox;
	}
	return NULL;
}

void libera(Lista* l){
	while(l->prox != NULL){	
		l = l->prox;
		free(l->ant);
	}
	free(l);
}

void imprimir(Lista* l){
	Lista* p = l;

	for(;p!=NULL; p = p -> prox){
		printf("%c",p->caractere);
	}

	printf("\n \n");

}
int vazia(Lista* l){
	if(l == NULL){
		return 1;
	}
	return 0;
}
int tamanho_lista(Lista* l){
	int i = 0;
	while(l != NULL){
		l = l ->prox;
		i++;
	}
	return i;
}

// Adicionada dia 10 - abril 
char get_caractere(Lista* l){
	return l -> caractere;
}
Lista* get_proximo(Lista* l){
	return l->prox;
}
Lista* get_anterior(Lista* l){
	return l->ant;
}

void imprime_inversa(Lista* l){
	Lista* p = l;

	while(p->prox != NULL){
		p = p -> prox;
	}

	Lista* aux = p;

	for(;aux != NULL; aux = aux -> ant){
		printf("%c", aux -> caractere);
	}
	printf("\n\n");
}


Lista* ultimo_elemento(Lista* a){
	if(a == NULL){
		return NULL;
	}

	while(a->prox!=NULL){
		a = a->prox;
	}
	return a;
}



void set_caractere(Lista* l, char a){
	l->caractere = a;
}

Lista* eliminar_zeros(Lista* l){
	Lista* p = l;
	while((p->prox != NULL)&&(p->caractere == '0')){
		Lista* temp = p;
		p = p -> prox;
		free(temp);
	}
	return p;
}
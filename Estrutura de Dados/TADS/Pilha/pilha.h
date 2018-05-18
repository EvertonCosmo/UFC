#include "lista.h"



typedef struct pilha Pilha;
// typedef struct lista Lista;



Pilha* pilha_cria();

// Empilha 
void pilha_push(Pilha* p,char v);

// Desempilha
char pilha_pop(Pilha* p);

// Verifica pilha vazia 
int pilha_vazia(Pilha* p);

int pilha_cheia(Pilha* p);

// libera a pilha
void pilha_libera(Pilha* p);

void pilha_imprime(Pilha* p);

char lista_primeiro(Pilha* p);

// char lista_primeiro(Pilha* p);

void pilha_imprime_inversa(Pilha* p);

void palindrome(Pilha* p);

void pilha_elimina(Pilha* p,char c);
#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"
#define N 50

struct pilha{
    int topo;
    float vet[N];
};

Pilha* pilha_cria(){
    Pilha* p = (Pilha*)malloc(sizeof(Pilha*));

    if(p != NULL){
        p->topo = 0;
    }
    return p;

}
void pilha_push(Pilha* p,float v){

    if(p->topo == N){
        printf("Capacidade estourou!\n");
        exit(1);
    }
    p->vet[p->topo] = v;
    p->topo++;
}
float pilha_pop(Pilha* p){
    if(pilha_vazia(p)){
        printf("Pilha vazia.\n");
        exit(1);
    }
    float v;

    v = p->vet[p->topo-1];
    p->topo--;
    return v;
}
int pilha_vazia(Pilha* p){
    return (p-> topo == 0);
}


void pilha_libera(Pilha* p){
    free(p);
}
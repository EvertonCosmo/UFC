#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"
#define MAX 50 


int main(){

    Pilha *l;
    int i=0;
    char string[MAX];
    l = pilha_cria();
    
    printf("Digite um nome: ");
    scanf("%s",string);

    while(string[i] != '\0'){
        pilha_push(l,string[i]);
        i++;   
    }

    while(!pilha_vazia(l)){
        printf("%c\n", pilha_pop(l));
    }
    
    pilha_libera(l);
    return 0;
}
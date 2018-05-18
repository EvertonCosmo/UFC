#include "pilha.h"
#include <stdio.h>
#include <stdlib.h>

// #include "lista.h"
#define N 50

int main(){
	Pilha* l;
	int i = 0;
	char string[N];

	
	l = pilha_cria();

	printf("Digite um nome: ");
	scanf("%s",string);

	while(string[i] != '\0'){
		pilha_push(l,string[i]);
		i++;
	}
	// while(!pilha_vazia(l)){
 //        printf("%c\n", pilha_pop(l));
 //    }
	// printf("valor retirado %c\n",pilha_pop(l));
    // printf("oi\n");
    // printf("Topo da lista: %c \n",lista_primeiro(l) );

    pilha_imprime(l);

    printf("Imprimindo inversa \n");
    
	pilha_imprime_inversa(l);

	printf("Eliminando valor\n");

	pilha_elimina(l,'o');


	pilha_imprime(l);

	printf("IMPRIMINDO SE PALINDROMO OU NÃO \n");


	palindrome(l);

    pilha_libera(l);

    return 0;

		
		
		
		


}
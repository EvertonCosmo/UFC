#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"
// #include "lista.h"

#define N 50
int main(){

	Pilha* duracell = pilha_cria();
	char string[N];

	int i=0;

	printf("Digite um nome: ");
	scanf("%s",string);

	while(string[i] != '\0'){

		pilha_push(duracell,string[i]);
		i++;
	}
	// printf("valor retirado %c\n",pilha_pop(duracell));
	pilha_imprime(duracell);
	
	printf("Imprimindo reversa\n");

	pilha_imprime_inversa(duracell);

	palindrome(duracell);
	
	pilha_libera(duracell);
}

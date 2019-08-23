#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

void concatena(Pilha* p1, Pilha* p2){
	Pilha* p3 = pilha_cria();

	while(!pilha_vazia(p2)){
		pilha_push(p1,pilha_pop(p2));
	}
	
	/*while(!pilha_vazia(p3)){
		pilha_push(p1,pilha_pop(p3));
	}

*/
 pilha_libera(p2);
}

int main(){
	Pilha* duracell = pilha_cria();
	Pilha* duracell2 = pilha_cria();

	pilha_push(duracell,'1');
	pilha_push(duracell,'4');
	pilha_push(duracell,'2');

	pilha_push(duracell2,'9');
	pilha_push(duracell2,'3');
	pilha_push(duracell2,'7');


	printf("DURACELL\n");
	pilha_imprime(duracell);
	printf("DURACELL2\n");
	pilha_imprime(duracell2);

	concatena(duracell,duracell2);

	pilha_imprime(duracell);
	printf("INVERSA\n");
	pilha_imprime_inversa(duracell);
}

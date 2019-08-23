#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"
#include "pilha.h"
#include "filaLista.h"


int ehNumero(char c){
	if(c>='0' && c <= '9')
		return 1;
	return 0;
}

Lista* ordena(Lista* l){

	Pilha* duracell = pilha_cria();
	Fila* filinha = fila_cria();
	Lista* list = lista_cria();

	while(!lista_vazia(l)){
		// pilha_push(duracell,lista_primeiro_elemento(l));
		if(ehNumero(Lista_retorna_inicio(l))){
			 pilha_push(duracell,Lista_retorna_inicio(l));
			 // printf("number  %c\n",Lista_retorna_inicio(l) );
		}else{

			 fila_insere(filinha,Lista_retorna_inicio(l));
			// printf("char %c\n",Lista_retorna_inicio(l) );
		}

		// printf("imprimindo o inicio\n");
		// printf("value > %c\n\n",Lista_retorna_inicio(l));
		l = acessa_proximo(l);
		
	}

	// printf("imprimindo PILHA\n");
	pilha_imprime(duracell);
	// printf("imprimindo fila\n");
	imprime_fila(filinha);
	lista_libera(l);

	// Números 



	while(!pilha_vazia(duracell)){
		//Fila* filinha2 = fila_cria();
		char c = pilha_pop(duracell);
		// printf("valor de pop : %c\n",c);
		fila_insere(filinha,c);//pilha_pop(duracell));
		

	}
	pilha_libera(duracell);

	while(!fila_vazia(filinha)){
		char c  = fila_retira(filinha);
		// printf("valor de retira fila : %c\n",c );
		list = lista_insere(list,c);

	}
	
return list;

	
	
}
int main(){
	Lista* lista = lista_cria();
	Lista* ordenada = lista_cria();

	char string[] = "w8t7e5a1";
	int i = 0;

	for(i;i < strlen(string); i++){
		lista = lista_insere(lista,string[i]);
	}

	imprime(lista);
	ordenada = ordena(lista);

	imprime(ordenada);



}

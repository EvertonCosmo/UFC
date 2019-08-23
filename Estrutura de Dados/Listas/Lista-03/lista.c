 /* lista.c */
#include <stdlib.h>
#include <stdio.h>
#include "lista.h"

struct  lista{
	int valor;
	struct lista* prox;
};

Lista* cria(void){
	return NULL;
}

Lista* insere(Lista* l,int num){
	Lista* novo = (Lista*)malloc(sizeof(Lista));

	novo -> valor = num;
	novo -> prox = l;

	return novo;

}

// Lista* retira(Lista* l,int num){
// 	Lista* anterior=NULL;
// 	Lista* c=l;
	
	
// 	while(c->valor != num && c != NULL){
// 		anterior = c;
// 		c=	c -> prox;
		

// 	}
	
// 	if(anterior == NULL){
// 		c= c -> prox;
		
// 	}else{
// 		anterior->prox =c->prox;
// 	}
	
// 	if(c==NULL){
// 		return l;
// 	}
// 	free(c);
	
// 	return l;
// }

Lista* retira(Lista* l, int v){
	Lista* ant=NULL;
	Lista* atual=l;
	while(atual->valor!=v && atual->prox!=NULL){
		ant=atual;
		atual = atual->prox;
	}
	if(atual==NULL)
		return l;
	else if(ant==NULL){
		l = l->prox;
		free(atual);
		return l;
	}else{
		ant->prox = atual->prox;
		free(atual);
		return l;
	}
}

int impar(int num){
	if(num % 2 == 1){
		return 1;
	}else{
		return 0;
	}
}

Lista* busca(Lista* l,int v){
	Lista* novo = l;
	
	while(novo != NULL){
		if(novo -> valor  == v){
		
			return novo;
		}
			novo  = novo -> prox;
				
	}
	return NULL;
	
	
}


void libera(Lista* l){
	Lista* aux = l;
	Lista* c = l;
	while(aux != NULL){
		 c = aux ->prox;
		free(aux);

		aux = c;
		
	}
}

int vazia(Lista* l){

	if(l==NULL){
		return 1;
		
	}else{
		return 0;
	}

}
void imprimir(Lista* l){

	Lista* aux =l;
	
	while(aux != NULL){
		
		
		printf("[%d] ",aux->valor);
		aux = aux -> prox;

	}
}
void imprimeNo(Lista* l){
	printf("%d\n",l->valor );
}
// Questão 1
Lista* celulaMinima(Lista* l){
		Lista* menor = (Lista*)malloc(sizeof(Lista));
		menor -> valor = l -> valor;
		Lista* aux = l;
		while(aux != NULL){
			if(aux->valor < menor->valor ){
				menor->valor = aux->valor;
				
			}
			aux = aux->prox;

		}

		return menor;
}
Lista* celulaMaior(Lista* l){
		Lista* maior = (Lista*)malloc(sizeof(Lista));
		maior -> valor = l -> valor;
		Lista* aux = l;

		while(aux != NULL){
			if(aux->valor > maior->valor ){
				maior->valor = aux->valor;
				
			}
			aux = aux->prox;

		}

		return maior;
}
// Questão 2 
Lista* retiraMaior(Lista* l){
	Lista* aux  = l;
	Lista* maior = cria();
	maior = celulaMaior(aux);
	


	 

	return retira(aux,maior->valor);
}

// Questão 3
int numCelula(Lista* l){
	int cont = 0;
	while(l !=NULL){
		cont++;
		l = l->prox;
	}
	return cont;
}

Lista* listaImpar(Lista* l,Lista* l2){
	// l2 impar
	// l  par

	if(l == NULL){
		return NULL;
	}
	if(l->valor % 2 == 0){
		l2 = l;
		
	}

	listaImpar(l->prox, l2);
		
	// l2 = listaImpar(c->prox,l2);

	return l;
}

// Lista* listaImpar(Lista* l, Lista* l2){
// 	Lista* impar;
// 	Lista* par;
// 	Lista* atual;
// 	Lista* l_aux = l;

// 	while(l_aux != NULL){
// 		if(l_aux ->valor % 2 == 0){
// 			par = l;
// 			printf("par: %d \n",par->valor);
// 		}else{
// 			impar = l_aux;
// 		}
// 		l_aux = atual;
// 	}
	
// return impar;
	
// }
Lista* Uniao(Lista* l1, Lista* l2){
	Lista* n1 = l1;
	Lista* n2 = l2;
	Lista* n3; 
	Lista* retirado;
	// if(n1 == NULL || n2 == NULL){
	// 	return NULL;
	// }

	while(n1 != NULL && n2 != NULL){
		if(busca(n1,n2->valor) == (busca(n2, n1->valor))){
			retirado = retira(n1,n2->valor);
			
		}else{
			n3 = insere(n3,n1->valor);
			n3 = insere(n3,n2->valor);
		}
		n1 = n1->prox;
		n2 = n2 ->prox;
	}
	
		return n3;

		
}

void hexadecimal(int n){
	int rest = 0;
	int divisao = 0;
	if(n == 0){
		return ;
	}
	rest = n % 16;
	divisao = n / 16;
	
	hexadecimal(divisao);
	printf("%d",rest);
	// return ;
}

void octal(int n){
    int resto = 0;
    
    if(n == 0){
    
    	return ;
    
    }
    resto = n % 8; 
    octal(n/8);
    printf("%d ",resto);
   
   
}

Lista* somaImpares(Lista* l){
	//Lista* novo; 
	Lista* n1 = l;
	Lista* aux=l;
	Lista* soma = cria();
	int s = 0;
	
	while(n1 != NULL){
		if(n1->valor % 2 == 1){
			s = s + n1 ->valor;
		}
		n1 = n1 -> prox;
	}
	soma = insere(soma,s);
	n1 = aux;	
	aux = aux->prox;
	
	soma = somaImpares(n1);
	// libera(aux);
	return soma;
}


#include "operacoes.h"
#include <stdio.h>
#include <stdlib.h>

int toInt(char a){
	if(a == '0') return 0;
	if(a == '1') return 1;
	if(a == '2') return 2;
	if(a == '3') return 3;
	if(a == '4') return 4;
	if(a == '5') return 5;
	if(a == '6') return 6;
	if(a == '7') return 7;
	if(a == '8') return 8;
	if(a == '9') return 9;
}

char toChar(int x){
	if (x == 0) return '0';
	if (x == 1) return '1';
	if (x == 2) return '2';
	if (x == 3) return '3';
	if (x == 4) return '4';
	if (x == 5) return '5';
	if (x == 6) return '6';
	if (x == 7) return '7';
	if (x == 8) return '8';
	if (x == 9) return '9';

}

Lista* ler_numero(Lista* l, char v){
	return 	l  = insere(l,v);
}


Lista* adicao(Lista* n1, Lista* n2){
	Lista* auxA = ultimo_elemento(n1);
	Lista* auxB = ultimo_elemento(n2);
	Lista* auxC = cria();
	int numA = 0, numB = 0, soma = 0, mod = 0;

	while((auxA != NULL)&&(auxB != NULL)){
		numA = toInt(get_caractere(auxA));
		numB = toInt(get_caractere(auxB));
		soma += (numA+numB);

		if(soma <= 9){
			auxC = insere_inicio(auxC, toChar(soma));
			soma=0;
		}
		else{
			mod = soma%10;
			auxC = insere_inicio(auxC, toChar(mod));
			soma = soma/10;
		}
			auxA=get_anterior(auxA);
			auxB=get_anterior(auxB); 
	}
	if(auxA!=NULL){
		while(auxA!=NULL){
			if(soma==0){
				auxC = insere_inicio(auxC, get_caractere(auxA));
				auxA = get_anterior(auxA);
			}else{
				numA = toInt(get_caractere(auxA));
				soma = (soma + numA);
				if(soma <= 9){
					auxC = insere_inicio(auxC, toChar(soma));
					soma=0;
				}
				if(soma > 9){
					mod= soma%10;
					auxC = insere_inicio(auxC, toChar(mod));
					soma = soma/10;
				}
				auxA = get_anterior(auxA);
				if((auxA==NULL)&&(soma != 0)){
					auxC = insere_inicio(auxC, toChar(soma));
					soma=0;
				}
			}
		}
	}


	else if(auxB!=NULL){
		while(auxB!=NULL){
			if(soma==0){
				auxC = insere_inicio(auxC, get_caractere(auxB));
				auxB = get_anterior(auxB);
			}else{
				numB = toInt(get_caractere(auxB));
				soma += numB;
				if(soma <= 9){
					auxC = insere_inicio(auxC, toChar(soma));
					soma=0;
				}
				if(soma > 9){
					mod = soma%10;
					auxC = insere_inicio(auxC, toChar(mod));
					soma = soma/10;
				}
				auxB = get_anterior(auxB);
				if((auxB==NULL)&&(soma != 0)){
					auxC = insere_inicio(auxC, toChar(soma));
					soma=0;
				}
			}
		}
	}
	if(((auxA==NULL)&&(auxB==NULL))&&(soma != 0)){
		auxC = insere_inicio(auxC, toChar(soma));
		soma=0;
	}
	return auxC;
}

Lista* auxmultiplicacao(Lista* n1, Lista* n2){
	Lista* auxA;
	Lista* auxB;
	Lista* mult;
	Lista* atual;
	Lista* aux1;

	int i = 0;
	auxB = ultimo_elemento(n2);
		while(auxB!=NULL){
			int carry = 0;
			mult = cria();
			auxA = ultimo_elemento(n1);
			while(auxA!=NULL){	 	
				int multp = toInt(get_caractere(auxA)) * toInt(get_caractere(auxB)) + carry;
				mult = insere_inicio(mult ,toChar(multp % 10));
			 	carry = multp / 10;
			 	auxA = get_anterior(auxA);
			}
			if(carry > 0){
			 	mult = insere_inicio(mult,toChar(carry));
			}

			if(i>=1){
				aux1 = atual;
				atual = ad0noFinal(mult, i);
				atual = adicao(atual,aux1);
				libera(aux1);
			}
			if(i==0){
				atual = mult;
			}
		auxB = get_anterior(auxB);
		i++;
	}		
	return atual;
}


Lista* multiplicacao(Lista* n1, Lista* n2){
	Lista* atual;
	if(tamanho_lista(n1)>=tamanho_lista(n2)){
		atual=auxmultiplicacao(n1,n2);
	}
	else{
		atual=auxmultiplicacao(n2,n1);;
	}
	return atual;
}

Lista* quadrado(Lista* n1){
	Lista* e2 = n1;
	e2 = multiplicacao(e2,e2);
	return e2;
}

int comparacao(Lista* a, Lista* b){
	Lista *auxA = a, *auxB = b;
	int i = 0, j = 0;
	if(tamanho_lista(auxA) > tamanho_lista(auxB)){
		return 1;
	}
	if(tamanho_lista(auxA) < tamanho_lista(auxB)){
		return -1;
	}

	else if(tamanho_lista(auxA) == tamanho_lista(auxB)){
		auxA = ultimo_elemento(a), auxB = ultimo_elemento(b);
		while((auxA != NULL)&&(auxB != NULL)){
			i++;
			if((toInt(get_caractere(auxA)))==(toInt(get_caractere(auxB))))
				j++;
			auxA = get_anterior(auxA);
			auxB = get_anterior(auxB);
		}
		if(i==j){
			return 0;
		}
		i = j = 0;

		auxA = a, auxB = b;
		while((auxA != NULL)&&(auxB != NULL)){
			i++;
			if((toInt(get_caractere(auxA)))>=(toInt(get_caractere(auxB))))
				j++;
			auxA = get_proximo(auxA);
			auxB = get_proximo(auxB);
		}
		if(i==j){
			return 1;
		}
		i = j = 0;

		auxA = a, auxB = b;
		while((auxA != NULL)&&(auxB != NULL)){
			i++;
			if((toInt(get_caractere(auxA)))<=(toInt(get_caractere(auxB))))
				j++;
			auxA = get_proximo(auxA);
			auxB = get_proximo(auxB);
		}
		if(i==j){
			return -1;
		}
	}
}

Lista* fatorial(Lista* n1){
	Lista* auxA = n1, *auxC = cria(), *auxB = cria(), *rest = cria(),* lib;
	auxC = insere_inicio(auxC,'1');
	auxB = insere_inicio(auxB,'0');
	rest = insere_inicio(rest,'1');
	int i = 0;
	while((comparacao(auxA,auxB))!=0){
		lib = auxB;
		auxB = adicao(auxB,auxC);
		libera(lib);
		lib = rest;
		rest = multiplicacao(rest, auxB);
		libera(lib);
		i++;
	}
	return rest;
}

Lista* exponenciacao(Lista* n1,int num){
	Lista* aux1 = n1, *expon = cria();
	expon = insere(expon,'1');
	int i = 0;
	for(; i < num; i++){
		aux1 = expon;
		expon = multiplicacao(expon, n1);
		libera(aux1);
	}
	return expon;
}
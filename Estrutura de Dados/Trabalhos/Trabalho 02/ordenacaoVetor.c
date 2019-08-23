#include <stdlib.h>
#include "ordenacaoVetor.h"

#define troca(a,b)	a = b+a; b = a-b; a = a-b;

/*Essa é a melhor implementação? Daria para tornar essa implementação mais eficiente? Tente responder essas poerguntas no relátório*/
void selectionSort(int n, int *v){
	int i, j, min, x;
	for(i=0;i<n-1;i++){
		min = i;
		for(j=i+1;j<n; j++){
			if(v[j] < v[min]) min =j;
		}
		x = v[i];
		v[i] = v[min];
		v[min] = x;
	}
}

/*Essa é a melhor implementação? Daria para tornar essa implementação mais eficiente? Tente responder essas poerguntas no relátório*/
void bubbleSort(int n, int *v){
	int i, j, aux,k;
	k=n-1;
	for(i=0;i<n;i++){
		for(j=0;j<k; j++){
			if(v[j] > v[j+1]){
				aux = v[j];
				v[j] = v[j+1];
				v[j+1] = aux;
			}
		}
		k--;
	}
}

/*Essa é a melhor implementação? Daria para tornar essa implementação mais eficiente? Tente responder essas poerguntas no relátório*/
void insertionSort(int n, int *v){
	int i, j, x;
	for(j=1;j<n;j++){
		x = v[j];
		for(i=j-1;i>=0 && v[i] > x; i--){
			v[i+1] = v[i];
		}
		v[i+1] = x;
	}
}


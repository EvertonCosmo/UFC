#include <stdio.h>
#include <stdlib.h>
#include "ordenacaoVetor.h"
#include "bench.h"

#define BENCH 1
#define MAX 131080

static void vetorAleatorio(int* v, unsigned int len)
{
    unsigned int i =0;
    for(i=0;i<len;i++)
    {
        v[i]=rand();
    }
}

int testa(int n, int *v){
	int i;
	int r = v[0];
	for(i=1;i<n;i++){
		if(r > v[i]) return 0;
		r = v[i];
	}
	return 1;
}

int main(){
	int i,k=0,S=0,B=0,I=0,H=0,M=0,Q=0;

	int *v = (int*)malloc(MAX*sizeof(int));

	for(i=128;i<MAX;i = i*8){

		printf("-----Vetores de tamanho %d------\n", i);

		vetorAleatorio(v,i);
		BENCH_FUNCTION(selectionSort,i,v);
		S+=testa(i,v);

		vetorAleatorio(v,i);
		BENCH_FUNCTION(bubbleSort,i,v);
		B+=testa(i,v);
		
		vetorAleatorio(v,i);
		BENCH_FUNCTION(insertionSort,i,v);
		I+=testa(i,v);
				
		k++;
		
		printf("-------------------------------\n");		
			
	}

	printf("Seleção Vetor Interativo: [%s]\n", S==k?"Yes":"No");
	printf("Bolha Vetor Interativo: [%s]\n", B==k?"Yes":"No");
	printf("Inserção Vetor Interativo: [%s]\n", I==k?"Yes":"No");

	free(v);
	return 0;
	
}

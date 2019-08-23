#include <stdio.h>
#include <stdlib.h>
#define troca(A,B) int x = A; A=B; B=x; 

static void constroiHeap(int m, int *v){
	int k;
	for(k=1; k < m; k++){
		int f = k+1;

	while(f>1 && v[f/2] < v[f]){

			troca(v[f/2], v[f]);
			f /= 2;
	}
	}
}
static void constroiHeapMin(int m, int *v){
	int k;
	for(k=1; k < m; k++){
		int f = k+1;

	while(f > 1 && v[f/2] > v[f]){

			troca(v[f], v[f/2]);
			f /= 2;
	}
	}
}


static void peneira(int m, int *v) {
	int f = 2;
		while (f <= m) {
			if (f < m && v[f] < v[f+1])
						 ++f;
			if (v[f/2] >= v[f]) 
			     	break;
			troca (v[f/2], v[f]);
			f *= 2;
					}
}

static void peneiraMin(int m, int *v) {
	int f = 2;
		while (f <= m) {
			if (f < m && v[f] > v[f+1])
						 ++f;
			if (v[f/2] <= v[f]) 
			     	break;
			troca (v[f], v[f/2]);
			f *= 2;
					}
}
//HeapSort
void heapsortMin(int n, int *v){
	int m;
	constroiHeapMin(n,v);
	for(m=n; m >= 2; --m){
		troca(v[1],v[m]);
		peneiraMin(m-1,v);
	}
}

void heapsortMax(int n, int *v){
	int m;
	constroiHeap(n,v);
	for(m=n; m >= 2; --m){
		troca(v[1],v[m]);
		peneira(m-1,v);
	}
}

int main(){
	int vetor[11]={0,5,7,8,1,3,9,10,2,4,6};
	int i=1;

	printf("Vetor ORIGINAL\n");
	for(i; i<11; i++){

		printf("vetor: %d\n",vetor[i]);
	}
	printf("\n");
	// constroiHeap(11,vetor);

	for(i=0; i<11; i++){

		printf("constroiHeap: %d\n",vetor[i]);
	}
	printf("\n");
	constroiHeap(11,vetor);
	heapsortMax(11,vetor);

	printf("===HEAPMAX===\n\n");

	for(i=1; i<  12; i++){

		printf("HEAP_MAX: %d\n",vetor[i]);
	}
	printf("\n");
	printf("===HEAPMIN===\n\n");
	
	//constroiHeapMin(11,vetor);
	heapsortMin(11,vetor);
		for(i=1; i<  11; i++){

		printf("Vetor_MIN: %d\n",vetor[i]);
	}

	



}
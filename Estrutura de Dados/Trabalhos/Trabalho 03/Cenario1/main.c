#include <stdio.h>
#include <stdlib.h>
#include <sys/resource.h>
//#include "quicksort.h"
#include "sort.h"
#define MAX 4


static void vetorAleatorio(int* v, unsigned int len){
	
    unsigned int i =0;
    
    for(i=0;i<len;i++){
        v[i]=rand();
    }
}

int main(int argc, char* argv[]){
   
    unsigned long long int numcomp = 0;
	unsigned long long int numcopy = 0;
	
	
	int *v = (int*)malloc(MAX*sizeof(int));
	
	
	
	  vetorAleatorio(v, MAX);
	
	//heapSort(v, MAX,&comp,&copy); QUESTAO 2 
	quickSort(0, MAX,v,&comp,&copy); // QUESTAO 14
	
	printf("Number of comp: %llu, Number of copys: %llu\n",numcomp,numcopy);
	
	printf("RESPOSTA 2 -> A resposta é sim com o HEAPSORT ");
	
	free(v);
	

	return 0;







}

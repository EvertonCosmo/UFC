#include <stdio.h>
#include <stdlib.h>
#include <sys/resource.h>
#include "sort.h"
#define MAX 1000
#define SEEK 1

static void vetorAleatorio(int* v, unsigned int len){
	srand(SEEK);
    unsigned int i =0;
    
    for(i=0;i<len;i++){
        v[i]=rand();
    }
}




int main(){
	
	unsigned long long int numcomp = 0;
	unsigned long long int numcopy = 0;
	
	int *v = (int*)malloc(MAX*sizeof(int));
	
	struct rusage resources;
	int rc;

	double utime, stime, total_time;
	
	printf("Ordenando ...\n");

	vetorAleatorio(v,MAX);



	
	
 	quickSort(0,MAX-1,v,&numcomp,&numcopy);
	//bubbleSort(v,MAX,&numcomp,&numcopy);
	//mergeSort(MAX,v,&numcomp,&numcopy);
	//heapSort(v,MAX,&numcomp,&numcopy);
	//insertionSort(v,MAX,&numcomp,&numcopy);
	//selectionSort(v,MAX,&numcomp,&numcopy);
	
		if((rc == getrusage(RUSAGE_SELF, &resources)) != 0){
			perror("getrusage status");
			}

	utime = (double) resources.ru_utime.tv_sec + 1.e-6 * (double) resources.ru_utime.tv_usec;
	stime = (double) resources.ru_stime.tv_sec + 1.e-6 * (double) resources.ru_stime.tv_usec;

	total_time = utime + stime;


	printf("user time: %.5f, System time %.3f, Total Time: %.3f\n",utime,stime,total_time );
	printf("Number of comp: %llu, Number of copys: %llu\n",numcomp,numcopy);
	printf("\n\n");

	
	return 0;
}

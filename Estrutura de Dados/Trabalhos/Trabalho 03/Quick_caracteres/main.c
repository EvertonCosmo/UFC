#include <stdio.h>
#include <stdlib.h>
#include <sys/resource.h>
#include "quicksort.h"
#define MAX 1000000
#define SEEK 1

static void vetorAleatorio(char* v, unsigned int len){
	srand(SEEK);
    unsigned int i =0;
    
    for(i=0;i<len;i++){
        v[i]= "ABCDEFGHIJKLMNOPQRSTUVWXYZ"[random()%26];
    }
}

int main(int argc, char* argv[]){
   
    unsigned long long int numcomp = 0;
	unsigned long long int numcopy = 0;
	
	char *v = (char*)malloc(MAX*sizeof(char));
	
	struct rusage resources;
	int rc;

	double utime, stime, total_time;
	
	 
    FILE* file;
  
   
   
    file = fopen("arquivo.txt","w");
      if ( file == NULL){
           printf( "Error  !\n" );
           exit(1);
     }
	
	  vetorAleatorio(v, MAX);
	
	
	
		quickSort(0,MAX-1,v,&numcomp);
	
    if((rc == getrusage(RUSAGE_SELF, &resources)) != 0){
   		    perror("getrusage status");
		}

	utime = (double) resources.ru_utime.tv_sec + 1.e-6 * (double) resources.ru_utime.tv_usec;
	stime = (double) resources.ru_stime.tv_sec + 1.e-6 * (double) resources.ru_stime.tv_usec;

	total_time = utime + stime;


	printf("user time: %.5f, System time %.3f, Total Time: %.3f\n",utime,stime,total_time );
	printf("Number of comp: %llu",numcomp);
	
	fprintf(file,"TAM: %d SEEK: %d \nuser time: %.5f, System time %.3f, Total Time: %.3f\nNumber of comp: %llu\n",MAX,SEEK,utime,stime,total_time,numcomp );
	printf("\n\n");

	fclose(file);
	
	free(v);
	
	return 0;







}

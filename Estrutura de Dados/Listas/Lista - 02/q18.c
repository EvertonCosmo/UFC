#include <stdio.h>
#include <stdlib.h>

int somaVetor(int* v,int n){
    if(n == 1){
        return *v;
    }      
    
     
     
    return v[n-1] + somaVetor(v,n-1);
    
   
   
}

int main(){
	int vetor[]= {1,2,3,4,5};
	
	printf("Soma : %d\n",somaVetor(vetor,5));

}

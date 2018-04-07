#include <stdio.h>
#include <stdlib.h>

int somaVetor(int* v,int n){
    if(n == 1){
        return *v;
    }      
    
     
     
    return v[n-1] + somaVetor(v,n-1);
    
   
   
}

int mediaVetor(int* v,int n){
    return somaVetor(v,n)/n;  
   
    

}
int main(){
    int vetor[] = {2,2,2,2,2};
    printf("soma : %d\n",somaVetor(vetor,5));
    printf("media: %d\n",mediaVetor(vetor,5));
}

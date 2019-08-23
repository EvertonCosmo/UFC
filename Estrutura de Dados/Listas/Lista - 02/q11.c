#include <stdio.h>
#include <stdlib.h>


int VetSom(int *v,int n,int x){
    int i= 0;
    if(n == 1 || x == 0){
        return 0;
    }
    
   	for(i; i < n; i++){
   	    if(x == v[0]+ v[i]){
   	            return 1;
   	    }
   	}
   
   
   
   	VetSom(v,n-1,x);
}

int main(){
    int vetor1[] = {1,5,9,5};
    int x = 6;
    int tam = 4;
    //VetSom(vetor1,tam,x);
    if(VetSom(vetor1,tam,x)){
        printf("existem valores que somados são iguais a %d \n",x);
    }else {
        printf("não há\n");
    }
    
    
        
}

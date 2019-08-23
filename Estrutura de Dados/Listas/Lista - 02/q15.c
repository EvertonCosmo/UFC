#include <stdio.h>
#include <stdlib.h>

void inverte(int* v,int n){
    if( n < 1){
    		return;
    	}else{
    		int aux = v[0];
    		v[0] = v[n-1];
    		v[n-1] = aux;
    		inverte(v+1,n-2);
    	

}

int main(){
    int vetor[] = {2,3,4,5};
    int i=0;
    for(i;i<4;i++){
        printf("vetor: %d\t",vetor[i]);
        
    }
    printf("\n\n");
    printf("vetor invertido\n");
    inverte(vetor,4);
    printf("\n\n\n");
    for(i=0; i<4; i++){
            printf("vetor: %d\t",vetor[i]);
    
    }
    printf("\n");
    return 0;
}

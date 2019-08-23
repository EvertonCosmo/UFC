#include <stdio.h>
#include <stdlib.h>


int pertence(int* v, int x,int n){
   
    if(n == 1){
        if(*v == x){
            return 1;
        }else{
            return 0;
        }
    }
    
    
    
    if(v[0] == x){
        return 1;
    }else {
        pertence(v+1,x,n-1);
    
    }
}




int main(){
    int vetor[] = {8,3,4,18,3,22};
    int valor = 67;
    
    
    printf("o valor %d pertence ? %d ",valor,pertence(vetor,valor,6));
    

}

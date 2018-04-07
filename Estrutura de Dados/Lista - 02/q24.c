#include <stdio.h>
#include <stdlib.h>

int fat(int x){
    if(x == 1 || x == 0){
        return 1;
    }
    return x *  fat(x-1);
    
}

int fatQua(int n){
        
        return fat(2*n) / fat(n);
        
}


int main(){

    int n = 2;
    printf("Quadruplo fatorial : %d\n",fatQua(n));


}

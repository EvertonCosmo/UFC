#include <stdio.h>
#include <stdlib.h>

int fat(int x){
    if(x == 1 || x == 0){
        return 1;
    }
    return x *  fat(x-1);
    
}
int main(){
    printf("%d\n",fat(20));
    
}

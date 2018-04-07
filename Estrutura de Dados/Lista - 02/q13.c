#include <stdio.h>
#include <stdlib.h>

int soma(int x){
    if(x < 10 && x>(-10)){
        return x;
    }
    
    return x%10 + soma(x/10);
}
int main(){
    
    printf("%d\n",soma(-999));
    
}   

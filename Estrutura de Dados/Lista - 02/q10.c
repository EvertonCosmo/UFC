#include <stdio.h>
#include <stdlib.h>

int multRussa(int a, int b){
    if(a == 1){
        return b;
    }
    //int result = a/2;
    
    if(a % 2 != 0){
        return b + multRussa(a/2,b*2);
   }else{
        multRussa(a/2,b*2);
    }
     
}

int main(){
	   printf("retorno: %d\n",multRussa(27,82));
}

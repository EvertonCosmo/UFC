#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int hiperfatorial(int n){
        if(n==0)
            return 1;
        return pow(n,n) * hiperfatorial(n-1);
}

int main(){
    int num = 4;
    printf("o hiperfatorial %d é %d\n",num,hiperfatorial(num));    

}

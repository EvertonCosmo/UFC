#include<stdio.h>
#include <stdlib.h>
#include <math.h>

int fatexpo(int n){
	if(n == 1){
		return 1;
	}	
	
	return pow(n,fatexpo(n-1)); 
}

int main(){
	int num = 4;
	
	printf("o fatorial exponencial de %d é %d ",num,fatexpo(num));

}



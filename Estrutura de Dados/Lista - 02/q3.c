#include <stdio.h>
#include <stdlib.h>

int imprimePares(int n){
	if(n < 0){
		return 0;
	}
	2 + imprimePares(n-2);
	printf("%d\n",n); 
	
}

int main(){
	imprimePares(10);
}
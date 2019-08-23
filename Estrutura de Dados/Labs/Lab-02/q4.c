#include <stdio.h>
#include <stdlib.h>

int binario(int n){
	if(n < 2){
		return n;
	}
	return 10 * binario(n/2) + (n % 2); 
}

int main(){
	int numero = binario(2);

	printf("%d\n",numero);
}
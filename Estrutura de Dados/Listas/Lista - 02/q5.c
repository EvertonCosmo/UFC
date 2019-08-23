#include <stdio.h>
#include <stdlib.h>

int potencia(int n,int k){
	if(n == 0){
		return 1;

	}
	if(k == 0){
		return 0;
	}

	return k * potencia(n-1,k);

}


int main(){

	int k = 0;
	int n = 0;

	printf("valor de k: \n");
	scanf("%d",&k);

	printf("valor de n: \n");
	scanf("%d",&n);
	
	printf("Potenciação de k^n: %d\n",potencia(n,k));
}
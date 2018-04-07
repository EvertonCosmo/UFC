#include <stdio.h>
#include <stdlib.h>

void imprimeNaturais(int n){
	if(n < 0){
		return;
	}
	
	imprimeNaturais(n-1);
	printf("%d\n",n );
}
int main(){
	imprimeNaturais(30);
}
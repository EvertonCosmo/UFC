#include <stdio.h>
#include <stdlib.h>

void imprimeNaturaisDesc(int n){
	if(n < 0){
		return;
	}
	printf("%d\n",n );
	imprimeNaturaisDesc(n-1);
	
}
int main(){
	imprimeNaturaisDesc(30);
}
#include <stdio.h>
#include <stdlib.h>


void inverterString(char* v,int n){
	if( n < 0){
		return;
	}else{
		int aux = v[0];
		v[0] = v[n-1];
		v[n-1] = aux;
		inverterString(v+1,n-2);
	}
}

int main(){
	char c[]= "Everton";
	inverterString(c,8);
	int i;
	for(i=0; i<7; i++){
		printf("%c",c[i] );
	}
	printf("\n");
}

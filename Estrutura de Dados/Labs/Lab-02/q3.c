#include <stdio.h>
#include <stdlib.h>

int multiRec(int a,int b){
	if(a == 0 || b ==0){
		return 0;
	}else{
		return a + multiRec(a,b-1);
	}
}
int main(){
	int resultado = multiRec(2,3);
	printf("%d\n",resultado);
}
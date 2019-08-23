#include <stdio.h>
#include <stdlib.h>

int fatDuplo(int n){
	//if(n == 0)
	//	return 0;
	
	if(n == 1){
		return 1;
	}
	if(n % 2 == 1){
		 return n * fatDuplo(n-1);
	}
	
	fatDuplo(n-1);
	

}




int main(){
	int num = 11;
	
	printf("o fatorial duplo de %d é : %d \n",num,fatDuplo(num));
	//fatDuplo(5);

}

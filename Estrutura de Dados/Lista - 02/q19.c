#include <stdio.h>
#include <stdlib.h>


int soma(int n){
	if(n == 0){
	
		return 0;
	}
	printf("%d\n",n);
	
	return n + soma(n-1);
	
	
	
	
}
int main(){
	int num = 10;
	printf("soma do valor %d até 1: %d\n",num,soma(num));
	//soma(num);

}

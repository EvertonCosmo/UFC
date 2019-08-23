#include <stdio.h>
#include <stdlib.h>

int ImprimeParesDesc(int n){
	if(n < 0)
		return 0;
	if(n % 2 == 0){
		printf("%d\n",n);
		
		
	}
		
	ImprimeParesDesc(n-1);
}
int main(){
	ImprimeParesDesc(50);
}
#include <stdio.h>
#include <stdlib.h>

int testaPrimo(int n){
	int i;
	if(n <= 1){
		return 0;
	}	
	for(i=2; i <n; i++){
		if(n % i == 0){
			// printf("resto de %d por %d = %d\n",n,i,n%i );
			return 0;
		}

	}
	return 1;


}
void primos(int n){
	if(n < 1){
		return ;
	}

	if(testaPrimo(n)){
		printf("%d\n",n);
	}
	primos(n-1);
	

}
int main(){
	primos(11);
}
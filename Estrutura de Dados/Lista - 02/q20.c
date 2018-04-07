#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int palindrome(char* str, int n){
	if(n <= 1){
		return 1;
	}

	if(str[0] != str[n-1]){
		return  0;
			
	}

	//str[n-1] = '\0';
	palindrome(str+1,n-1);

	return 1;
}
int main(){
	char cosmo[] ="como";

	printf("Valor : %d\n",palindrome(cosmo,strlen(cosmo)));


}
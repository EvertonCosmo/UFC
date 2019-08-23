#include <stdio.h>
#include <stdlib.h>


int multRec(int n1, int n2){
	if(n1 == 0 || n2 ==0)
		return 0;

	return n1 + multRec(n1,n2-1);
}

int main(){
	int n1 = 10;
	int n2 = 2;
	printf("%d por %d = %d\n ",n1,n2,multRec(n1,n2));
}

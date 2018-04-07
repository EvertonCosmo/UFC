#include <stdio.h>
#include <stdlib.h>
int fat(int x){
    if(x == 1 || x == 0){
        return 1;
    }
    return x *  fat(x-1);
    
}

int superFat(int n){
	if(n == 0){
		return 1;
	}
	return fat(n) * superFat(n-1);

}


int main(){
	int num = 4;
	printf("superfat de %d é %d\n ",num,superFat(num));

}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// int menorElemento(int* v, int tam){
// 	int i;
// 	int aux = v[0];
	
// 	for(i=1; i<tam; i++){
// 		if(v[i] < aux){
// 			aux = v[i];

// 		}
// 		// printf("%d\n",v[i] );
// 	}
	
// 	printf("%d\n",aux );
// 	return 0;
// }
int menorElementoRec(int* v, int n){
	int i;
	if(n == 1){
		return *v;
	}

	int menor = 0;
	
 	menor = menorElementoRec(v, n-1);
 	

 	if(menor < v[n-1]){
 	
 		return menor;
 	}
 	return v[n-1];
	
	
	// if(v[n] < menor){
	// 	menor = v[n];
		
	// }
		

	

	
	// menorElementoRec(v,n-1);

	// return menor;
	
	

	

	//menorElementoRec(v,n+1);

}

int main(){
	int i=0;
	int v[] = {-10,7,0,11,38};
	for(i=0; i<5; i++){
		printf("v[%d] = %d\t",i,v[i] );
	}
	printf("\n");
	int resultado = menorElementoRec(v,5);
	// printf("d\n",menorElemento(v,strlen(v)));	
	printf("\nMENOR: %d\n",resultado );
}

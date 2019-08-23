#include <stdio.h>
#include <stdlib.h>
#include "sort.h"


/*BUBBLE SORT */

void bubbleSort(int* v, int n,unsigned long long int* comp,unsigned long long int* copy){//vetor e seu tamanho;

int i, aux,continua;

	do{

		continua=0;
		
		for(i=0; i<n-1; i++){ //vai até a penúltima posição do vetor
		     ++*comp; 
		
		    if(v[i] > v[i+1]){
		        
		        aux = v[i];
		        v[i] = v[i+1];
		        v[i+1]=aux;
		        
		        ++(*copy);
		        continua=i;
		    }

		}
		
	}while(continua!=0);

}

/* INSERTION SORT */

void insertionSort(int* v, int n,unsigned long long int* comp,unsigned long long int* copy){
    int i,j,aux;
    for(i=0; i<n; i++){
     
        aux = v[i];
        for(j=i; (j>0)&&(aux < v[j-1]); j--){//Voltando os indice j e copiando os elementos para frente 
               *comp++;
               *copy++;
            v[j] = v[j-1];
        }
        v[j] = aux;
        *copy++;
        

    }
}

/* SELECTION SORT */

void selectionSort(int* v, int n,unsigned long long int* comp,unsigned long long int* copy){
    int i, j, menor, troca;

    for(i=0; i<n; i++){

        menor = i;

        for(j=i+1; j < n;j++){
            ++*comp;
            if(v[j] < v[menor]){
                ++*copy;
                menor = j;
            }
        }
        if(i != menor){
            ++*copy;
            troca = v[i];
            v[i] = v[menor];
            v[menor] = troca;
        }
    }
}

/* HEAP SORT */

static void criaHeap(int *vet, int i, int f,unsigned long long int* comp,unsigned long long int* copy ) {
    int aux = vet[i]; //Posição PAI

    int j = i*2+1; //filho


    while(j <= f ){
        ++*comp;
        if(j < f){
            ++*comp;
            if(vet[j] < vet[j+1]){ /*Pai tem dois filhos. Quem é o maior*/
                ++*comp;
                j=j+1;
            }
        }
        if(aux < vet[j] ){ /*FILHO maior que o PAI?*/
            ++*comp;
            
            vet[i] = vet[j];//FILHO se torna PAI
            ++*copy;
            
            i = j;
            ++*copy;
            
            j = 2 * i +1;   //Repetir o processo
        }else{
            ++*copy;
            j = f + 1;
        }
    }
    ++*copy;
    vet[i] = aux; //Antigo PAI ocupa lugar do último filho analisado 

}
    

void heapSort(int* v, int n,unsigned long long int* comp,unsigned long long int* copy) {
    int i, aux;
    /*Cria heap apartir dos dados*/
    for(i=(n-1)/2; i>=0; i--){
        criaHeap(v,i , n-1,comp,copy);
    }   


    for(i=n-1; i >= 1; i--){
        
        ++*copy;
        /*Pega o maior elemento da heap
        e coloca na posição correspondente no array*/
        aux = v[0];
        ++*copy;
        v[0] = v[i];
        ++*copy;
        v[i] = aux;

        criaHeap(v,0,i-1,comp,copy); //Reconstruir heap
    }

}




/* QUICK SORT */

static int separa(int p, int r, int *v,unsigned long long int* comp,unsigned long long int* copy){
    int c, j,k,t;
    c = v[r];
    j = p;
    
    for(k=p; k<r; k++){
        ++*comp;
        if(v[k] <= c){
            ++*copy;
            t = v[j];
            ++*copy;
            v[j]=v[k];
             ++*copy;
            v[k] = t;
            j++;
        }
    }
    
    v[r] = v[j];
     ++*copy;
    v[j]=c;
     ++*copy;
    return j;
        
}

void quickSort(int p, int r,int* v,unsigned long long int* comp,unsigned long long int* copy) {
    int  j;

    if(p<r){
        j= separa(p,r,v,comp,copy);
        quickSort(p,j-1,v,comp,copy);
        quickSort(j+1,r,v,comp,copy);
    }

}

/* MERGE SORT */


static void intercala(int p, int q, int r, int* v,unsigned long long int* comp,unsigned long long int* copy){
	int i,j,k, *w;
	
	w = (int*)malloc((r-p)*sizeof(int));
	
	i=p; j=q;
	k=0;
	
	while(i<q && j<r){
	  ++*comp;
	  
		if(v[i] <= v[j]){
			w[k++]= v[i++];
			++*copy;
			}
		else{
			w[k++] = v[j++]; 
			++*copy;
	    }
	}
	
	while(i<q){ 
	    
	    w[k++]=v[i++];
	    ++*copy;
	}
	
	while(j<r) {
	    
	    w[k++]=v[j++];
	    ++*copy;
	}
	for(i=p; i<r;i++){
	     v[i]=w[i-p];
	     ++*copy;
	}
	
	free(w);


}

void mergeSort(int n, int *v,unsigned long long int* comp,unsigned long long int* copy){
	int p,r, b=1;
	
	while(b<n){
	    ++*comp;
		p =0;
		
		while(p+b<n){
		    ++*comp;
			r = p+2*b;
			
			if(r > n){
				r = n;
				++*copy;
			}
			intercala(p,p+b,r,v,comp,copy);
			
			p = p +2*b;
			
			++*copy;
		}
		++*copy;
		b = 2*b;
	}
}



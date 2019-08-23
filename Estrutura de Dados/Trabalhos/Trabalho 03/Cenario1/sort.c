#include <stdio.h>
#include <stdlib.h>
#include "sort.h"





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
            
            v[j]=v[k];
             
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



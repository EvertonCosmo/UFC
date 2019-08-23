

#include <stdlib.h>
#include "quicksort.h"

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

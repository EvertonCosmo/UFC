#include <stdio.h>
#include <stdlib.h>


int frequencia(char* str,char c){
      if(str[0] == '\0'){
        return 0;
      }
      if(str[0] == c){
        return 1 + frequencia(str+1,c);
      }
      return frequencia(str+1,c);
}

int main(){
    char str[] = "everton cosmo ";
    char c = 'o';
    int f = frequencia(str,c);
    printf("Número de ocorrencia : %d\n",f);
    
    
    
}
   

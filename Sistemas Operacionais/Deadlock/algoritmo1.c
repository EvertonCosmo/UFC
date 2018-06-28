/*
    Deadlock Detection Algorithm
    Created By: Pirate and modify
*/


#include<stdio.h>
#include<stdlib.h>

//int max[100][100];
int **max;
int **alloc;
int **need;
int *avail;
//int alloc[100][100];
//int need[100][100];
//int avail[100];
int n,r;
void input(char*);
void show();
void cal();
int toInt(char);

FILE *file;


int main(int argc, char* argv[]){ 

        int ch1; // number of processos
        int ch2; // number of resources instances
        char ch3;
          
        
        if ( argc != 2 ){
              printf( "usage: %s missing file.txt \n",argv[0] );
              }
              
          else{
                 printf("********** Deadlock Detection Algo ************\n");
          
             file = fopen( argv[1], "r" );
  
              
              if ( file == NULL){
                  printf( "Error  !\n" );
              }
              
              else { 
                  char x;
                  printf("file successfully read %s \n",argv[1]);
                  
                  
                  
                  fscanf(file,"%d %d \n",&ch1, &ch2);
                  n = ch1; 
                  r  = ch2;
                   
                 
                    input(argv[1]); // input data, 
                    
                    show(); // show info
                     
                    cal(); // calculation 
                    fclose( file );
                    return 0;
                  
                  
                
                 
                 
              }
          }    

}




void input(char* argument_file){
  
    
   
   
    
   
    printf("Entering with the Max Matrix .... \n");
   

    
        int i,j;
       
        max = (int**)malloc(sizeof(int*)*n);
           
           for(i=0; i<n; i++) {
                   max[i] = (int*)malloc(sizeof(int) * r);
           }
           
           
          int c;
          char d;
          //d = (char*)malloc(sizeof(char)*n*r);
         
            
            for(i=0; i<n;i++){
                for(j=0;j<r; j++){
                 d = fgetc(file);
                 
                   if(c == EOF){
                      /*ERRO*/
                   }
                     c = toInt(d);
                     //c = atoi(d[i]);
                      max[i][j] = c;
                }
               d = fgetc(file);
                if(c!='\n'){
                  /*ERRO*/
                }
            }
  
    
  
    
    printf("Entering with the Allocation Matrix\n");
   
    
    
      
     
      alloc = (int**)malloc(sizeof(int*)*n);
         
         for(i=0; i<n; i++) {
                 alloc[i] = (int*)malloc(sizeof(int) * r);
         }
         
         
      
        //d = (char*)malloc(sizeof(char)*n*r);
       
          
          for(i=0; i<n;i++){
              for(j=0;j<r; j++){
               d = fgetc(file);
               
                 if(c == EOF){
                    /*ERRO*/
                 }
                   c = toInt(d);
                   //c = atoi(d[i]);
                    alloc[i][j] = c;
              }
             d = fgetc(file);
              if(c!='\n'){
                /*ERRO*/
              }
          }
    
    
      printf("Entering with resource available\n");
    
    
        avail = (int*)malloc(sizeof(int*)*r);
        for(i=0; i<r; i++){
            d = fgetc(file);
             c = toInt(d);
             avail[i]=c;
        }
    
    
    
}

int toInt(char c){

    return  c - 48;


}

void show()
{
    int i,j;
    printf("Process\t Allocation\t Max\t Available\t");
    for(i=0; i<n; i++)
    {
        printf("\nP%d\t   ",i+1);
        for(j=0; j<r; j++)
        {
            printf("%d ",alloc[i][j]);
        }
        printf("\t");
        for(j=0; j<r; j++)
        {
            printf("%d ",max[i][j]);
        }
        printf("\t");
        if(i==0)
        {
            for(j=0; j<r; j++)
                printf("%d ",avail[j]);
        }
    }
}
void cal()
{
    int finish[100],temp,need[100][100],flag=1,k,c1=0;
    int dead[100];
    int safe[100];
    int i,j;
    for(i=0; i<n; i++)
    {
        finish[i]=0;
    }
    //find need matrix
    for(i=0; i<n; i++)
    {
        for(j=0; j<r; j++)
        {
            need[i][j]=max[i][j]-alloc[i][j];
        }
    }
    while(flag)
    {
        flag=0;
        for(i=0; i<n; i++)
        {
            int c=0;
            for(j=0; j<r; j++)
            {
                if((finish[i]==0)&&(need[i][j]<=avail[j]))
                {
                    c++;
                    if(c==r)
                    {
                        for(k=0; k<r; k++)
                        {
                            avail[k]+=alloc[i][j];
                            finish[i]=1;
                            flag=1;
                        }
                        //printf("\nP%d",i);
                        if(finish[i]==1)
                        {
                            i=n;
                        }
                    }
                }
            }
        }
    }
    j=0;
    flag=0;
    for(i=0; i<n; i++)
    {
        if(finish[i]==0)
        {
            dead[j]=i;
            j++;
            flag=1;
        }
    }
    if(flag==1)
    {
        printf("\n\nSystem is in Deadlock and the Deadlock process are\n");
        for(i=0; i<n; i++)
        {
            printf("P%d\t",dead[i]);
        }
    }
    else
    {
        printf("\nNo Deadlock Occur\n");
    }
}


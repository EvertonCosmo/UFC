#include <stdio.h> 
#include <stdlib.h>
#include <sys/socket.h>
#include<ctype.h>
#include <arpa/inet.h>
//#include <winsock2.h>
#include <string.h> 
#include <unistd.h>
#define PORT 2500    /*This is the port for the client server connection*/
#define MAXDATASIZE 2000 // max number of bytes we can get at once

char* getMessages(int index);
int main() { 
    char* name = "BRABO SERVER";
    int sock;
    int sock_client;
    int new_socket;
    int server_size;
    int read_size;
    char buffer[MAXDATASIZE];
    struct sockaddr_in server;
    struct sockaddr_in client;


    sock = socket(AF_INET,SOCK_STREAM,0);
  
    if(sock == -1){ 
           printf("[error] Could not create socket\n");
           exit(EXIT_FAILURE);
    }
    printf("[info] Socket created.\n");
 
    server.sin_family = AF_INET;
    server.sin_port = htons(PORT);
    server.sin_addr.s_addr =  INADDR_ANY;
    // server.sin_addr.s_addr = inet_addr("127.0.0.1");
    memset(server.sin_zero,0,sizeof(server.sin_zero));

    if(bind(sock,(struct sockaddr *)&server,sizeof(server)) < 0){ 
        printf("[info] - bind failed\n");
        exit(EXIT_FAILURE);
    }
    printf("[info] - bind OK \n");
    if(listen(sock,5) < 0){ 
        exit(EXIT_FAILURE);
    }

     printf("[info] waiting for incoming connections...\n");
    //accept connection from an incoming client
    sock_client = accept(sock,(struct sockaddr *)&client,(socklen_t*)&server_size);
    
    if(sock_client<0){ 
        printf("[error] accept connection failed\n");
        exit(EXIT_FAILURE);
    }
    printf("[info] connnection accepted\n");

    while(read_size = recv(sock_client , buffer , sizeof(buffer) , 0)> 0 ) { 
        printf("message from client: ");
        // puts(buffer);
        printf("%d\n",(int)strlen(buffer));
    for(int j= 0; j<(int)strlen(buffer); j++){ 
        printf("%c\n",buffer[j]);
    }
        int message_sort = 0 + rand() % ( 7 - 0);

        char* message = getMessages(message_sort);
        // puts(message);

        if(send(sock_client,message,strlen(message),0) < 0 ){ 
             printf("[error] failed to send\n");
             exit(EXIT_FAILURE);
        }
       
        printf("[info] message send to client\n");
    
    }
        if(read_size == 0){
        puts("[info] The client has disconnected!");
        fflush(stdout);
    }
    close(sock);
    return EXIT_SUCCESS;
}

char* getMessages(int index) { 
     char* messages[]= {
         "Não ame pela beleza, pois um dia ela acaba.",
         "Não fique triste por um momento ruim que já passou",
         "Nada melhor do que derrubar com um sorriso, quem um dia te machucou com uma lágrima. ",
         "Lute. Acredite. Conquiste. Perca. Deseje. Espere. Alcance. Invada. Caia. Seja tudo o quiser ser, mas acima de tudo, seja você sempre.",
         "Pedras no caminho? Eu guardo todas. Um dia vou construir um castelo.",
         "Você precisa fazer aquilo que pensa que não é capaz de fazer.",
         "Nossa maior fraqueza está em desistir. O caminho mais certo de vencer é tentar mais uma vez.",
         "Na vida, não existem soluções. Existem forças em marcha: é preciso criá-las e, então, a elas seguem-se as soluções.",
     };
     return messages[index];
}
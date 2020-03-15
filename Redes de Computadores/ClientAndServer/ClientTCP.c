#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <string.h>
#include<ctype.h>
#include <unistd.h>
#define PORT 2500 /*This is the port for the client server connection*/
int main(){
    int sock;
    char message[2000];
    char server_reply[2000];
    struct sockaddr_in server;

    sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock == -1){
        printf("[error] Could not create socket");
        exit(EXIT_FAILURE);
    }
    printf("[info] Socket created.\n");
    server.sin_family = AF_INET;
    server.sin_port = htons(PORT);
    server.sin_addr.s_addr = inet_addr("127.0.0.1");
    memset(server.sin_zero, 0, sizeof(server.sin_zero));

    if (connect(sock, (struct sockaddr *)&server, sizeof(server)) < 0){
        printf("[error] - connection failed\n");
        exit(EXIT_FAILURE);
    }
    printf("[info] connected to server\n");

    while (1){
        printf("Type a message : ");
        scanf("%s",message);
        // fgets(message,sizeof(message),stdin);
        if (send(sock, message, strlen(message), 0) < 0){
            printf("[error] send failed");
            exit(EXIT_FAILURE);
        }
        if (recv(sock, server_reply, sizeof(server_reply), MSG_CMSG_CLOEXEC) < 0){
            exit(EXIT_FAILURE);
        }
        printf("[info] Server reply: ");
        puts(server_reply);
    }
    close(sock);
    return EXIT_SUCCESS;
}
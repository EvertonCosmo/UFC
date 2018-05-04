#include <stdio.h> 
#include <unistd.h> 
#include <stdlib.h>
#include <pthread.h> 
#include <semaphore.h> 

#define MAX_CUSTOMERS 25 

void *cliente(void *num); 

void *barbeiro(void *); 

void wait(int segundos);

//Define os semáforos 


// limita o número de clientes permitidos para entra no quarto de espera de uma vez.
sem_t quartoEspera; 

// acesso exclusivo a cadeira do barbeiro. 
sem_t cadeiraBarbeiro;

// usado para permitir que o barbeiro durma até a chegada de um cliente. 
sem_t dormeBarbeiro; 

//  usado para fazer um cliente esperar até que o barbeiro termine de cortar o cabelo do cliente na cadeira.
sem_t cadeiraEspere;

// Flag usada para parar o barbeiro quando todos os clientes estiverem servidos.
int tudoFeito = 0;

int main() {
		 pthread_t btid; 
		 pthread_t tid[MAX_CUSTOMERS]; 

		 int i, x, numClientes;
		 int numCadeiras;
		 int Numero[MAX_CUSTOMERS];  // Clientes

		 printf("O número maximo de clientes pode ser apenas 25. Digite o número de clientes e cadeiras\n");
		 scanf("%d",&x);
		 numClientes = x; 
		 scanf("%d",&x);
		 numCadeiras = x;

		 if (numClientes > MAX_CUSTOMERS) { 
			 printf("O número maximo de clientes é %d\n", MAX_CUSTOMERS);
			 sleep(1);
		 	return 0;
		 } 

		 
		 for (i = 0; i < MAX_CUSTOMERS; i++) { 
		 	Numero[i] = i; 
 		} 

 //Inicializa os semáforos
 sem_init(&quartoEspera, 0, numCadeiras);  
 sem_init(&cadeiraBarbeiro, 0, 1);
 sem_init(&dormeBarbeiro, 0, 0); 
 sem_init(&cadeiraEspere, 0, 0); 
 	
 // Cria o barbeiro. 
 // printf("doaisod\n");
 pthread_create(&btid, NULL, barbeiro, NULL); 
 
 // Cria os clientes. 
 for (i = 0; i < numClientes; i++) {
 	pthread_create(&tid[i], NULL, cliente, (void *)&Numero[i]); 
 }

 
 for (i = 0; i < numClientes; i++) { 
 	pthread_join(tid[i],NULL); 
 }

 // Quando todos os clientes estiverem servidos, mata a thread do barbeiro.
 tudoFeito = 1; 


 sem_post(&dormeBarbeiro); // Acorda a thread do barbeiro para ele ir embora. 

 pthread_join(btid,NULL); 

 sleep(1); 

 return 0;
}

void *cliente(void *numero) { 
	 int num = *(int *)numero;

	 printf("Cliente %d está indo a barbearia\n", num);// Parte para a barbearia e leva uma quantidade de tempo para chegar.
	 wait(5); 

	
	 printf("Cliente %d chegou na barbearia.\n", num); // Aguarda por uma vaga no quartoEspera...
	 sem_wait(&quartoEspera); 

	 printf("Cliente %d está aguardando sua vez.\n", num); // Espera para a cadeira do barbeiro ficar livre.
	 sem_wait(&cadeiraBarbeiro); // A cadeira do barbeiro está livre, o cliente libera seu lugar nos acentos de espera e senta na cadeira do barbeira.
	 sem_post(&quartoEspera); // Acorda o barbeiro...

	 printf("Cliente %d acordando o barbeiro.\n", num); 
	 sem_post(&dormeBarbeiro); // Espera o barbeiro terminar de cortar o cabelo. 
	 sem_wait(&cadeiraEspere); // Libera a cadeira do barbeiro. 
	 sem_post(&cadeiraBarbeiro); 

	 printf("Cliente %d está saindo da barbearia.\n", num); 
}

void *barbeiro(void *lixo) { 
// Enquanto houver clientes para serem servidos o barbeiro é onisciente e pode dizer se ainda há clientes rumo a barbearia. 
 
	 while (!tudoFeito) { // Dorme até alguém chegar para acorda-lo... 
		 printf("O barbeiro está dormindo\n"); 
		 sem_wait(&dormeBarbeiro);
		
	 	 
		 if (!tudoFeito) { //Leva uma quantidade de tempo  para cortar o cabelo do cliente.
			 printf("O barbeiro está cortando cabelo\n"); 
			 wait(3);
			 printf("O barbeiro terminou de cortar o cabelo\n"); // Libera o cliente depois do corte de cabelo... 
			 sem_post(&cadeiraEspere); 
		 } 
		
		 else { 
		 	
		 	printf("O barbeiro está indo para casa\n"); 
		 } 
	 }
}
 
void wait(int segundos) { 
 	int len = 1; 
 	sleep(len); 
}

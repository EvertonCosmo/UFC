#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
 
// Numeros de cliente
 int P = 5;
 
// Number of resources
 int R = 3;
 
// Função para encontrar a necessidade de cada cliente
void calculateNeed(int need[P][R], int maxm[P][R],
                   int allot[P][R])
{
    int i, j;
    // Calculando a necessidade de cada P
    for (i = 0 ; i < P ; i++){
        for (j = 0 ; j < R ; j++){
 
            // Necessidade de instância = maxm instance -
            //                    // instância alocada
            need[i][j] = maxm[i][j] - allot[i][j];
        // Pritf p/ mostrar as requisições dos clientes.
             printf("\t%d", need[i][j]);

        }
         if(j == 3){
                printf("\n");
            }
    }

}
 
// Função para encontrar o sistema em estado seguro ou não
bool isSafe(int processes[], int avail[], int maxm[][R],
            int allot[][R])
{
    int need[P][R];
 
    // Função para calcular a matriz de necessidades
    calculateNeed(need, maxm, allot);
 
    //Marcar todos os processos como termninados
    int i;
    bool finish[P];
    for(i=0; i<P;i++){
        finish[i] = 0;

    }
 
    // Para armazenar a sequência segura
    int safeSeq[P];
 
    // Fazer uma cópia dos recursos disponíveis
    int work[R];
    for (int i = 0; i < R ; i++)
        work[i] = avail[i];
 
    //Enquanto todos os processos não estão terminados
     // ou o sistema não está em estado seguro.

    int count = 0;
    while (count < P)
    {
        // Encontre um processo que não esta terminado e
         // cujas necessidades podem ser satisfeitas com os
        // work[] recursos.
        bool found = false;
        for (int p = 0; p < P; p++)
        {
            //Primeiro verifique se um processo está concluído
             // se não, vá para a próxima condição

            if (finish[p] == 0)
            {
                 // Verifique se há todos os recursos de
                 // P atual necessidade é menor do que work
                int j;
                for (j = 0; j < R; j++)
                    if (need[p][j] > work[j])
                        break;
 
                // Se todas as necessidades de p estiverem satisfeitas.
                if (j == R)
                {
                    // Adicione os recursos alocados de
                    // atual P para o available/work
                  
                    for (int k = 0 ; k < R ; k++)
                        work[k] += allot[p][k];
 
                    // Adicione este processo a uma sequência segura.
                    safeSeq[count++] = p;
 
                    // Marque este p como terminado
                    finish[p] = 1;
 
                    found = true;
                }
            }
        }
 
        // Se não pudéssemos encontrar um próximo processo em segurança
         // seqüência.
        if (found == false)
        {
            printf("sistema não está em estado seguro\n");
            return false;
        }
    }
 
    // Se o sistema estiver em estado seguro,
     // sequência segura será como abaixo
    printf("O sistema esta em estado seguro. \nEm seguranca "
          "sequencia e");
    for (int i = 0; i < P ; i++)
        printf("%d ", safeSeq[i]);
 
    return true;
}
 

int main()
{
    int processes[] = {0, 1, 2, 3, 4};
 
    // Instâncias disponíveis de recursos 
    int avail[] = {3, 3, 2};
 
    // Máximo R que pode ser alocado
     // para processos

    int maxm[P][R];
    int i, j;
     printf("Digite a matriz de numero max:\n");
    for (i = 0; i < P; ++i){
        for(j=0; j < R; j++){

            scanf("%d", &maxm[i][j]);
        }
    }
   /* int maxm[P][R] = {{7, 5, 3},
                     {3, 2, 2},
                     {9, 0, 2},
                     {2, 2, 2},
                     {4, 3, 3}};
                     */
 
    // Recursos alocados para processos
    /*int allot[P][R] = {{0, 1, 0},
                      {2, 0, 0},
                      {3, 0, 2},
                      {2, 1, 1},
                      {0, 0, 2}};
 
    // Verifique se o sistema está em estado seguro ou não*/
    int allot[P][R];
     printf("Digite a matriz de numero max:\n");
    for (i = 0; i < P; ++i){
        for(j=0; j < R; j++){

            scanf("%d", &allot[i][j]);
        }
    }
    isSafe(processes, avail, maxm, allot);
 
    return 0;
}
/*	Arquivo que contém as operações que serão usadas para manipular 
	a lista 
*/
#include "lista.h"

// Retorna o valor da forma que foi digitado como um inteiro 
int toInt(char a);

// Retorna o valor da forma que foi digitado como um char
char toChar(int x);

// Lê o número e o armazena na estrutura
Lista* ler_numero(Lista* l, char v); // Por hora usar lista, depois buscar outras implementações

// executa a adição de n1 + n2 e retorna o resultado
Lista* adicao(Lista* n1, Lista* n2);

//função que recebe dois números n 1 e n 2 de entrada e retorna um terceiro
//n 3 tal que n 3 = n 1 ∗ n 2 .
Lista* multiplicacao(Lista* n1,Lista* n2);

// retorna o n1 ^ 2
Lista* quadrado(Lista* n1);

// recebe dois números n 1 e n 2 e retorna 0 se forem iguais, um número negativo se n 1 < n 2 e um número positivo se n 1 > n 2 .
int comparacao(Lista* a, Lista* b);

// retorna o n1!
Lista* fatorial(Lista* n1);

// retorna exponenciacao de n1^n2

Lista* exponenciacao(Lista* n1, int num);
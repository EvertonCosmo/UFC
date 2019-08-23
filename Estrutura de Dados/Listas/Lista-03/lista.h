/* lista.h*/
typedef struct lista Lista;

// Função para criar a lista vazia
Lista* cria(void);

// Função para inserir dados em nó da lista
Lista* insere(Lista* l,int num);

// Função para retirar um valor da lista(nó)
Lista* retira(Lista* l, int num);
 
 // Função que busca valor na lista 
Lista* busca(Lista* l, int num);

// Função que libera a memória da lista alocada 
void libera(Lista* l);

// Função que retorna 1 se vazia e 0 caso contrário
int vazia(Lista* l);

// Função para impressão dos valores da lista
void imprimir(Lista* l);
void imprimeNo(Lista* l);
int impar(int num);
void hexadecimal(int n);
// Lista* listaImpar(Lista* l);
Lista* listaImpar(Lista* l, Lista* l2);
Lista* Uniao(Lista* l1, Lista* l2);
/*
	Funções para a Lista - 03 
*/
// Questão 1
Lista* 	celulaMinima(Lista* l);

// Necessária para a questão 2
Lista* celulaMaior(Lista* l);

// Questão 2
Lista* retiraMaior(Lista* l);

// Questão 3
int numCelula(Lista* l);
void octal(int n);
Lista* somaImpares(Lista* l);

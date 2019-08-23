typedef struct lista Lista;

// Cria a lista 
Lista* cria();

// Insere um elemento  na lista (no fim) 
Lista* insere(Lista* l, char c);
// Insere um elemento  na lista (no inicio)

Lista* ad0noFinal(Lista* aux, int i);

Lista* insere_inicio(Lista* a, char n);
// Remove um elemento da lista
void retiraUmNo(Lista* l);

// Busca um elemento na lista 
Lista* busca(Lista* l,char c);

// Libera a memória ocupada pela lista  
void libera(Lista* l);

//Imprime os elementos da lista 
void imprimir(Lista* l);

// Retorna 1 se vazia se não retorna 0 
int vazia(Lista* l);

// Retorna o tamanho(comprimento) da lista
int tamanho_lista(Lista* l);

// Retorna o caractere contido na lista l
char get_caractere(Lista* l);

// Retorna o prox nó da lista
Lista* get_proximo(Lista* l);

// Retorna o ant nó da lista
Lista* get_anterior(Lista* l);

void imprime_inversa(Lista* l);

//Retorna o ultimo elemento da lista
Lista* ultimo_elemento(Lista* a);

void set_caractere(Lista* l, char a);


Lista* eliminar_zeros(Lista* l);


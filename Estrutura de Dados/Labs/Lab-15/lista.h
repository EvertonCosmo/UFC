
typedef struct lista Lista;

// Função para criar a lista vazia
Lista* lista_cria();

// Função para inserir dados em nó da lista
Lista* lista_insere(Lista* l, char v);


// Função para retirar um valor da lista(nó)
Lista* lista_retira(Lista* l, int num);
 
 
// Função que libera a memória da lista alocada 
void lista_libera(Lista* l);

char Lista_retorna_inicio(Lista* l);

Lista* lista_remove_inicio(Lista* l);

int lista_vazia(Lista* l);

 void setProx(Lista* l, Lista* p);

Lista* acessa_proximo(Lista* l);


void imprime(Lista* l);



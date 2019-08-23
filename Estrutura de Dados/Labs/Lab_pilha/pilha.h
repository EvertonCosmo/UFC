typedef struct pilha Pilha;
typedef struct lista Lista;

Pilha* pilha_cria();

void pilha_push(Pilha* p,char v);

char pilha_pop(Pilha* p);

int pilha_vazia(Pilha* p);

void pilha_libera(Pilha* p);

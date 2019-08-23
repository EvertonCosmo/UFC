typedef struct fila Fila;

Fila* fila_cria();

void fila_insere(Fila *f, char v);

char fila_retira(Fila *f);

int fila_vazia(Fila *f);

void fila_libera(Fila *f);

void imprime_fila(Fila* f);
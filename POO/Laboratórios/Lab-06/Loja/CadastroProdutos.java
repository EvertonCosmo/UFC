class CadastroProdutos {

    private Produto[] produtos = new Produto[10];
    
    protected int qtdProdutos = 0;

    public void adiciona(Produto produto) {
        produtos[qtdProdutos++] = produto;
    }

    public void ordenar() {
        Produto p[] = new Produto[qtdProdutos];    

        for (int i = 0; i < qtdProdutos; i++) {
            p[i] = produtos[i];
        }

        java.util.Arrays.sort(p);

        for (Produto i : p) {
            System.out.println(i.toString());
        }
       
    }

    public Produto[] getProdutos() {

        return produtos;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public boolean equals(Produto o) {
        for (int i = 0; i < qtdProdutos; i++) {
            if (o instanceof Dvd) {
                Dvd p = (Dvd) o;
                return produtos[i].codBarra == p.codBarra;

            } else if (o instanceof Cd) {
                Cd p = (Cd) o;
                return produtos[i].codBarra == p.codBarra;
            } else if (o instanceof Livro) {
                Livro p = (Livro) o;
                return produtos[i].codBarra == p.codBarra;
            }

        }
        return false;
    }

    public void imprimir() {
        for (int i = 0; i < qtdProdutos; i++) {

            System.out.println(produtos[i].toString());
        }
    }
    

}
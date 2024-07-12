package produto;

public interface RepositorioProduto<T extends Produto> {
    
    boolean existe(int codigo);
    void inserir(T produto);
    void atualizar(T produto);
    void remover(int codigo);
    T procurar(int codigo);
}

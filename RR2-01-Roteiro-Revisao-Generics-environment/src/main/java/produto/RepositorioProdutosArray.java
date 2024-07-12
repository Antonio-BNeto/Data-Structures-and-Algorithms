package produto;

public class RepositorioProdutosArray<X extends Produto> implements RepositorioProduto<X> {
    
    /**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
    protected X[] produtos;

    /**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
    protected int index = -1;

    public RepositorioProdutosArray(int size){
        super();
        this.produtos = (X[]) new Object[size];
    }

    /**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
    private int procurarIndice(int codigo){
        for(int i = 0; i < this.produtos.length; i++){
            if(produtos[i].getCodigo() == codigo){
                return i;
            }
        }
        return -1;
    }
    /**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
    @Override
    public boolean existe(int codigo) {
        // TODO Auto-generated method stub
        if(procurarIndice(codigo) != -1){
            return true;
        }
        return false;
    }

    /**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
    @Override
    public void inserir(X produto) {
        // TODO Auto-generated method stub
        if(index<produtos.length){
            this.produtos[++index] = produto;
        }
    }

    /**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
    @Override
    public void atualizar(X produto) {
        // TODO Auto-generated method stub
        for(Produto prod : produtos){
            if(prod.equals(produto)){
                prod = produto;
            }
        }
        throw new RuntimeException("Produto não existe!");
    }
    /**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
    @Override
    public void remover(int codigo) {
        // TODO Auto-generated method stub
        if(index != -1){
            int i = procurarIndice(codigo);
            produtos[i] = produtos[index];
            this.produtos[index] = null;
            index --;
        }
        throw new RuntimeException("Produto não existe!");
    }

    /**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
    @Override
    public X procurar(int codigo) {
        // TODO Auto-generated method stub
        if(existe(codigo)){
            int i = procurarIndice(codigo);
            return this.produtos[i];
        }
        throw new RuntimeException("Produto não existe!");
    }
    
}

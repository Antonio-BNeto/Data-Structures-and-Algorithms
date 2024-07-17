package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<o> {

	// O array interno onde os objetos manipulados são guardados
	private Object[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(Object o) {
		if(indice < tamanho){
			arrayInterno[++indice] = o;
		}
	}

	// Remove um objeto do vetor
	public Object remover(Object o) {
		if(!isVazio()){
			for(int i=0; i< indice+1; i++){
				if (arrayInterno[i].equals(o)) {
					Object key = arrayInterno[i];
					for(int j = i; j < indice+1;j++){
						arrayInterno[j] = arrayInterno[j+1];
					}
					arrayInterno[indice] = null;
					this.indice --;
					return key;
				}
			}
		}
		return null;
	}

	// Procura um elemento no vetor
	public Object procurar(Object o) {
		for(Object vetor: arrayInterno){
			if (vetor.equals(o)) {
				return vetor;
			}
		}
		return null;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		if(indice == -1){
			return true;
		}
		return false;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		if(indice == tamanho-1){
			return true;
		}
		return false;
	}

}

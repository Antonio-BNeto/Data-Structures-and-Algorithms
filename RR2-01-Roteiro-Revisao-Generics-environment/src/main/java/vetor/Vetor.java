package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<V> {

	// O array interno onde os objetos manipulados são guardados
	private V[] arrayInterno;

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
	public void inserir(V vetor) {
		// TODO Remove the exception and implement your code
		if(indice < tamanho){
			arrayInterno[++indice] = vetor;
		}
		
	}

	// Remove um objeto do vetor
	public V remover(V vetor) {
		// TODO Remove the exception and implement your code
		if(!isVazio()){
			for(int i = 0; i< indice+1 ;i++){
				if(arrayInterno[i].equals(vetor)){
					arrayInterno[i] = null;
					indice --;
					return vetor;
				};
			}
		}
		return null;
	}

	// Procura um elemento no vetor
	public V procurar(V vetor) {
		// TODO Remove the exception and implement your code
		for(V elementos: arrayInterno){
			if(elementos.equals(vetor)){
				return elementos;
			}
		}
		return null;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		// TODO Remove the exception and implement your code
		if(indice == -1){
			return true;
		}
		return false;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		// TODO Remove the exception and implement your code
		if(indice == tamanho-1){
			return true;
		}
		return false;
	}

}

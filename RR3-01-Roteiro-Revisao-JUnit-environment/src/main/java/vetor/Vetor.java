package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */

public class Vetor<T extends Comparable<T>> {

	// O array interno onde os objetos manipulados são guardados
	private	T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> ComparadorMaximo;
	private Comparator<T> ComparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (T[]) new Comparable[tamanho];
	}

	public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.ComparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.ComparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		if(indice < tamanho){
			arrayInterno[++indice] = o;
		}
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		if(!isVazio()){
			for(int i=0; i< indice+1; i++){
				if (arrayInterno[i].equals(o)) {
					T key = arrayInterno[i];
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
	public T procurar(T o) {
		T result = null;
		boolean achou = false;
		int i = 0;
		while (i<=indice && !achou) {
			if(arrayInterno[i].equals(o)){
				result = arrayInterno[i];
				achou = true;
			}
			i++;
		}
		return result;
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

	public T maximo(){
		T result = null;
		if(!isVazio()){
			result = arrayInterno[0];
			for(int i = 0; i<=indice; i++){
				if(ComparadorMaximo.compare(result, arrayInterno[i])<0){
					result = arrayInterno[i];
				}
			}
		}
		
		return result;
	}

	public T minimo(){
		T result = null;
		if(!isVazio()){
			result = arrayInterno[0];
			for(int i = 0; i<= indice; i++){
				if(ComparadorMinimo.compare(result, arrayInterno[i])<0){
					result = arrayInterno[i];
				}
			}
		}
		return result;
	}
	

}

class ComparadorMaximo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o1.getMedia() - o2.getMedia());
	}

}

class ComparadorMinimo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o2.getMedia() - o1.getMedia());
	}

}

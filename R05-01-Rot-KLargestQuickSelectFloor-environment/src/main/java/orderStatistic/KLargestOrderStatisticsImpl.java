package orderStatistic;

import java.util.Arrays;

import javax.swing.UIClientPropertyKey;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		T[] Kmaiores;
 		if(array != null && k>=1 && k<=array.length){
			Kmaiores = (T[]) new Comparable[k];
			for(int i = 0; i < k;i++){
				Kmaiores[i] = orderStatistics(array, array.length-i);
			}
			
		}else{
			Kmaiores = (T[]) new Comparable[0];
		} 
		return Kmaiores;
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		T result = null;
		if(array.length != 0 && k <= array.length && k > 0){
			result = select(array, 0, array.length-1, k);
		}
		return result;
	}

	private T select(T[] array, int leftIndex, int rightIndex, int k){

		if(leftIndex == rightIndex){
			return array[leftIndex];
		}

		int pivotIndex = partition(array, leftIndex, rightIndex);

		T result = array[pivotIndex];

		if(pivotIndex == k-1){

		}else if(pivotIndex < k-1){
			result = select(array, pivotIndex + 1, rightIndex, k);
		}else{
			result = select(array, leftIndex, pivotIndex-1, k);
		}

		return result;
	}

	private int partition(T[] array,int leftIndex, int rightIndex){
		int pivot = leftIndex;
		int i = leftIndex;

		for(int j = i+1; j<=rightIndex;j++){
			if(array[j].compareTo(array[pivot])<= 0){
				i++;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, leftIndex , i);

		return i;
	}
}

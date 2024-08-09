package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(array != null && leftIndex>=0 && leftIndex < rightIndex && rightIndex<array.length){

			int min = array[leftIndex];
			int max = array[leftIndex];

			//pegando o maior e o menor elemento do array inicial.
			for(int i = leftIndex+1; i<= rightIndex;i++){
				if(array[i]< min){
					min = array[i];
				}
				if(array[i]> max){
					max = array[i];
				}
			}

			//array auxiliar
			int[] C = new int[max-min +1];

			for(int i = leftIndex;i<=rightIndex;i++){
				C[array[i]-min]++;
			}

			//Soma acumulativa do elementos do array C
			for(int i = 1;i<C.length;i++){
				C[i]+=C[i-1];
			}

			int[] B = new int[rightIndex-leftIndex+1];

			for(int i= rightIndex;i>= leftIndex;i--){
				C[array[i]-min]--;
				B[C[array[i]-min]] = array[i];
			}

			//Colocando todos os elementos ordenados que estão no array B no array passado como parametro.
			int indexB = 0; 
			for(int i = leftIndex ;i<= rightIndex;i++){
				array[i] = B[indexB];
				indexB++;
			}
		}
	}
}

package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(array != null && leftIndex>=0 && leftIndex < rightIndex && rightIndex<array.length){

			int maior = array[leftIndex];
			
			//pegando o valor do maior elemento do array passado como parametro
			for(int i = leftIndex+1;i<=rightIndex; i++){
				if(array[i] > maior){
					maior = array[i];
				}
			}

			//array auxiliar
			int[] C = new int[maior+1];

			for(int i = leftIndex; i <= rightIndex;i++){
				C[array[i]] += 1;
			}

			//Soma acumulativa dos elementos que estão presentes no array C.
			for(int i = 1; i<C.length;i++){
				C[i] += C[i-1];
			}

			//array que vai ordenar os elementos do array inicial.
			int[] B = new int[rightIndex-leftIndex+ 1];

			for(int i = rightIndex;i>=leftIndex;i--){
				B[C[array[i]]-1] = array[i];
				C[array[i]]-= 1 ;
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

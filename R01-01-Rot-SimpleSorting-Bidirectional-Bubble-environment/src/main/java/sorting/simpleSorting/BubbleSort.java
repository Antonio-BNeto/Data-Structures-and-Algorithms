package sorting.simpleSorting;

import sorting.AbstractSorting;

import util.*;
/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	Util u = new Util();

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		boolean swapped = true;

		while (swapped) {
			swapped = false;
			for(int i = leftIndex; i<rightIndex; i++){
				if(array[i].compareTo(array[i+1])> 0){
					u.swap(array, i, i+1);
					swapped = true;
				}	
			}
			rightIndex--;
		}
	}
}

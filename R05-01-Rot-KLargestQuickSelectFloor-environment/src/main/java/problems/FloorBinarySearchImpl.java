package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (array != null && array.length > 0 && x != null){
			quickSort(array, 0, array.length-1);
			return floorBinarySearch(array, x, 0, array.length-1);
		}
		return null;
	}

	private Integer floorBinarySearch(Integer[] array,Integer value, Integer leftIndex, Integer rightIndex){
		
		if (leftIndex > rightIndex) {
			return null;
		}

		if(array[rightIndex] <= value){
			return array[rightIndex];
		}

		int middle = (rightIndex+leftIndex)/2;

		if(middle > 0  && array[middle-1]<= value && value< array[middle]){
			return array[middle-1];
		}

		if(array[middle] > value){
			return floorBinarySearch(array, value, leftIndex, (middle-1));
		}

		return floorBinarySearch(array, value, (middle+1), rightIndex);
		
	}


	private void quickSort(Integer[] array, int leftIndex, int rightIndex){
		if(array != null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length){
			int pivotIndex = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, rightIndex);
		}
	}

	private int medianThree(Integer[] array, int leftIndex, int rightIndex){

		int middle = (leftIndex + rightIndex) / 2;

		if(array[leftIndex] > array[rightIndex]){
			Util.swap(array, leftIndex, rightIndex);
		}
		if(array[leftIndex] > array[middle]){
			Util.swap(array, leftIndex, middle);
		}
		if(array[middle] > array[rightIndex]){
			Util.swap(array, middle, rightIndex);
		}

		return middle;
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex){

		int pivotIndex = medianThree(array, leftIndex, rightIndex);

		int i = rightIndex - 1;

		Util.swap(array, pivotIndex, rightIndex - 1);

		for (int j = i - 1; j >= leftIndex + 1; j--) {
			if (array[j] >= array[rightIndex - 1]) {
				i--;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, i, rightIndex - 1);

		return i;	
		
	}
}
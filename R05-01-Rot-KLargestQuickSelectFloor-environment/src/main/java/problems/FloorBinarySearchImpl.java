package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (array != null && array.length > 0 && x != null){
			quickSort(array, 0, array.length-1, x);
			return floorBinarySearch(array, x, 0, array.length-1);
		}
		return null;
	}

	private Integer floorBinarySearch(Integer[] array,Integer value, Integer leftIndex, Integer rightIndex){
		Integer res = null;

		if (leftIndex <= rightIndex) {

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
		return res;
	}


	private void quickSort(Integer[] array, int leftIndex, int rightIndex, Integer x){
		if(array != null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length){
			
			int pivotIndex;

			if(rightIndex-leftIndex >= 2){
				medianThree(array, leftIndex, rightIndex);
				pivotIndex = partition(array, leftIndex+1, rightIndex-1);
			}else{
				pivotIndex = partition(array, leftIndex, rightIndex);
			}
			
			if(array[pivotIndex].compareTo(x)<0){
				quickSort(array, pivotIndex+1, rightIndex, x);
			}else{
				quickSort(array, leftIndex, pivotIndex-1, x);
			}
			
		}
	}

	private void medianThree(Integer[] array, int leftIndex, int rightIndex){

		int middle = (leftIndex + rightIndex) / 2;

		if(array[leftIndex].compareTo(array[rightIndex]) > 0){
			Util.swap(array, leftIndex, rightIndex);
		}
		if(array[leftIndex].compareTo(array[middle]) > 0){
			Util.swap(array, leftIndex, middle);
		}
		if(array[middle].compareTo(array[rightIndex]) > 0){
			Util.swap(array, middle, rightIndex);
		}

		if (rightIndex-leftIndex>=2) {
			
		}

		Util.swap(array, middle, leftIndex+1);
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex){

		int pivot = leftIndex;
		int i = leftIndex;

		for(int j = i+1; j<=rightIndex;j++){
			if(array[j] < array[pivot]){
				i++;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, leftIndex , i);

		return i;
		
	}
}
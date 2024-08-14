package problems;

import static org.junit.Assert.assertArrayEquals;

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

	private Integer floorBinarySearch(Integer[] array,Integer value, int leftIndex, int rightIndex){
		Integer result = null;
		if (leftIndex <= rightIndex && array[0]<=value) {

			int middle = leftIndex+(rightIndex-leftIndex)/2;

			if(array[rightIndex].compareTo(value) <= 0){
				result = array[rightIndex];

			}else if(array[middle].compareTo(value) == 0){
				result = value;

			}else if(value.compareTo(array[middle]) < 0){

				if(array[middle-1].compareTo(value)<0){
					result = array[middle-1];

				}else{

					result = floorBinarySearch(array, value, leftIndex, middle-1);
				}
			}else{

				result = floorBinarySearch(array, value, middle+1, rightIndex);
			}
		}
		return result;
	}


	private void quickSort(Integer[] array, int leftIndex, int rightIndex){
		if(leftIndex==rightIndex || leftIndex < 0 || leftIndex > rightIndex || rightIndex > array.length){

		}else{
			medianThree(array, leftIndex, rightIndex);
			int pivotIndex = partition(array, leftIndex+1, rightIndex-1);
			quickSort(array, leftIndex, pivotIndex-1);
			quickSort(array, pivotIndex+1, rightIndex);	
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
			Util.swap(array, middle, leftIndex+1);
		}

	}

	private int partition(Integer[] array, int leftIndex, int rightIndex){

		int pivot = leftIndex;
		int i = leftIndex;

		for(int j = i+1; j<=rightIndex;j++){
			if(array[j].compareTo(array[pivot]) < 0){
				i++;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, leftIndex , i);

		return i;
		
	}
}
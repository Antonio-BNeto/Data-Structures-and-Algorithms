package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		sort(array, 0, array.length-1);
		int floorindex = floorBinarySearch(array, 0, array.length-1, x);
		return array[floorindex];
	}

	private int floorBinarySearch(Integer[] array, int leftIndex, int rightIndex, int value){
		if(leftIndex<=rightIndex){

			int middle = (rightIndex-leftIndex)/2;

			if(array[middle] == value){
				return middle;
			}else if(array[middle]<value){
				
				floorBinarySearch(array, middle+1, rightIndex, value);
			}else{
				floorBinarySearch(array, leftIndex, middle-1, value);
			}
		}
		return -1;
	}


	private void sort(Integer[] array, int leftIndex, int rightIndex){
		if(leftIndex < rightIndex){
			int pivotIndex = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);
		}
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex){

		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for(int j = i+1; j<=rightIndex;j++){
			if(array[j].compareTo(pivot)<= 0){
				i++;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, leftIndex , i);

		return i;
	}

}

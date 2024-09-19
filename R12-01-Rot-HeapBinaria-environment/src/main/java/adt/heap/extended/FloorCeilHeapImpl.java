package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		for(Integer value: array){
			insert(value);
		}
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for(Integer value: array){
			insert(value);
		}
	}

}

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
		return  this.recursiveFloor(numero, null);
	}

	private Integer recursiveFloor(double numero, Integer floor){
		Integer root = this.extractRootElement();
		
		if(root != null){
			if(numero >= root && (floor == null || root>=floor)){
				floor = this.recursiveFloor(numero, root);
			}else{
				floor = this.recursiveFloor(numero, floor);
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for(Integer value: array){
			insert(value);
		}
		return this.recursiveCeil(numero, null);
	}

	private Integer recursiveCeil(double numero, Integer ceil){
		Integer root = this.extractRootElement();
		
		if(root != null){
			if(numero <= root && (ceil == null || root<= ceil)){
				ceil = this.recursiveFloor(numero, root);
			}else{
				ceil = this.recursiveFloor(numero, ceil);
			}
		}
		return ceil;
	}

}

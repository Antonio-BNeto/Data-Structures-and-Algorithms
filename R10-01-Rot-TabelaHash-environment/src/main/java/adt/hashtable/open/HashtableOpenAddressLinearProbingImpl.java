package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}


	@Override
	public void insert(T element) {
		if(element != null && this.search(element) == null){
			int probe = 0;

			while(probe < capacity()){
				int index = ((HashFunctionLinearProbing<T>)this.hashFunction).hash(element, probe);

				if(this.table[index] == null || this.table[index].equals(this.deletedElement)){
					this.table[index] = element;
					this.elements++;
					break;
				}else{
					probe ++;
					this.COLLISIONS++;
				}
			}

			if(probe == capacity()){
				throw new HashtableOverflowException();
			}
		}
	}

	@Override
	public void remove(T element) {
		int indexOf = this.indexOf(element);
		if(indexOf >= 0){
			this.table[indexOf] = this.deletedElement;
			this.elements--;
		}
	}

	@Override
	public T search(T element) {
		T search = null;
		int index = indexOf(element);

		if(element != null && index >= 0){
			search = (T) this.table[index];
		}

		return search;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;
		if(!isEmpty() && element != null){
			int probe = 0;

			while(probe < capacity()){
				int index = ((HashFunctionLinearProbing<T>)this.hashFunction).hash(element, probe);

				if(this.table[index] == null){
					break;
				}

				if(this.table[index].equals(element)){
					result =index;
					break;
				}

				probe ++;
				
			}
		}
		return result;
	}
}

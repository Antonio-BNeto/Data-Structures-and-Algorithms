package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		if(data == null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int size() {
		int result = 0;
		if(!isEmpty()){
			result = 1+next.size();
		}
		return result;
	}

	@Override
	public T search(T element) {
		T result = null;
		if(!isEmpty()){
			if(data == element){
				result = data;
			}else{
				result = next.search(element);
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()){
			data = element;
			next = new RecursiveSingleLinkedListImpl<T>();
		}else{
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()){
			if(data == element){
				data = next.data;
				next = next.next;
			}else{
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}

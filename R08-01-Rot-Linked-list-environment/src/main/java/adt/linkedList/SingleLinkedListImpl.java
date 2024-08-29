package adt.linkedList;


public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();	
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = getHead();
		while(!aux.isNIL()){
			size ++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T search = null;
		if(!isEmpty()&& element!=null){
			SingleLinkedListNode<T> auxHead = getHead();
			while(!auxHead.isNIL() && !auxHead.getData().equals(element)){
				auxHead = auxHead.getNext();
			}
			search = auxHead.getData();
		}
		return search;
		
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> auxHead = getHead();
			if(this.isEmpty()){
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, getHead());
				this.setHead(newHead);
			}else{
				while (!auxHead.isNIL()){
					auxHead = auxHead.getNext();
				}
				auxHead.data = element;
				auxHead.next = new SingleLinkedListNode<>();
			}
		}
		
	}

	@Override
	public void remove(T element) {
		if(!isEmpty() && element != null){
			if(this.head.getData().equals(element)){
				this.setHead(this.getHead().getNext());
			}else{
				SingleLinkedListNode<T> aux = getHead();
				while (!aux.isNIL() && aux.data != element){
					aux = aux.getNext();
				}
				if(!aux.isNIL()){
					aux.setData(aux.getNext().getData());
					aux.setNext(aux.getNext().getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] elements = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = getHead();
		int cont = 0;
		while(!aux.isNIL()){
			elements[cont] = aux.getData();
			aux = aux.getNext();
			cont ++;
		}
		return elements;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}

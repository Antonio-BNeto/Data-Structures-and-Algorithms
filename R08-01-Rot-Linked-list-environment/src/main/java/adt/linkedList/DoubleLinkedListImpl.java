package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl(){
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		if(element != null){
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>();
			node.setData(element);
			node.setNext(this.getHead());
			node.setPrevious(new DoubleLinkedListNode<>());
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(node);

			if(this.getHead().isNIL()){
				this.setLast(node);
			}
			this.setHead(node);
		}
	}

	@Override
	public void removeFirst() {
		if(!this.isEmpty()){
			setHead(this.head.next);
			if(this.getHead().isNIL()){
				this.last = (DoubleLinkedListNode<T>) getHead();
			}else{
				((DoubleLinkedListNode<T>)this.getHead()).setPrevious(new DoubleLinkedListNode<>());
			}
		}
	}

	@Override
	public void removeLast() {
		if(!this.isEmpty() && !last.isNIL()){
			this.setLast(last.getPrevious());
			if(last.isNIL()){
				head = last;
			}else{
				last.setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void remove(T element){

		if(!isEmpty() && element != null){
			if(this.head.getData().equals(element)){
				this.removeFirst();
			}else{
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead(); 
				while(!aux.isNIL() && !aux.getData().equals(element)){
					aux = (DoubleLinkedListNode<T>) aux.next;
				}
				if(!aux.isNIL()){
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
				}
			}
		}

	}

	@Override 
	public T search(T element){
		T found = null;
		if(!this.isEmpty() && element != null){
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> auxLast = this.getLast();
			while(auxHead != auxLast && auxHead.next != auxLast && auxHead.data != element && auxLast.data != element){
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}
			if(auxHead.getData().equals(element)){
				found =  auxHead.getData();
			}
			if(auxLast.data == element){
				found =  auxLast.getData();
			}
		}
		return found;
	}

	@Override
	public void insert(T element){
		if(element != null){
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
			newLast.setData(element);
			newLast.setPrevious(this.getLast());
			newLast.setNext(new DoubleLinkedListNode<>());

			this.getLast().setNext(newLast);

			if(this.getLast().isNIL()){
				this.setHead(newLast);
			}
			this.setLast(newLast);
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}

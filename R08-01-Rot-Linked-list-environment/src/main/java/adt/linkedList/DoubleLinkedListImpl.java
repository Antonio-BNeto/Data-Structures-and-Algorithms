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
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(element,new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());
			node.setNext(this.getHead());
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
			this.setHead(this.getHead().getNext());
			if(this.getHead().isNIL()){
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			}else{
				((DoubleLinkedListNode<T>)this.getHead()).setPrevious(new DoubleLinkedListNode<>());
			}
		}
	}

	@Override
	public void removeLast() {
		if(!this.getLast().isNIL()){
			this.setLast(this.getLast().getPrevious());
			if(this.last.isNIL()){
				this.setHead(this.getLast());
			}else{
				this.getLast().setNext(new DoubleLinkedListNode<>());
			}
		}
	}

	@Override
	public void remove(T element){
		if(!this.isEmpty() && element != null){
			if(this.getHead().getData().equals(element)){
				this.removeFirst();

			}else if(this.getLast().getData().equals(element)){
				this.removeLast();

			}else{
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead(); 
				while(!aux.isNIL() && !aux.getData().equals(element)){
					aux = (DoubleLinkedListNode<T>) aux.getNext();
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
			if(this.isEmpty()){
				getHead().setData(element);
			}else{
				DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), this.getLast());
				this.last.setNext(newLast);
				this.setLast(newLast);
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}

package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;


	@Override 
	public T search(T element){
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void insertFirst(T element) {
		if(element != null){
		}
	}

	@Override
	public void removeFirst() {
		if(!head.isNIL()){
			head = head.next;
			if(head.isNIL()){
				last = (DoubleLinkedListNode<T>) head;
			}else{
				head.getPrevious() = new DoubleLinkedListNode();
			}
		}
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}

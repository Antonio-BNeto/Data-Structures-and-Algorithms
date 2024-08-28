package adt.linkedList;

import java.lang.reflect.Array;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();	
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL()){
			size ++;
			aux = aux.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = head;
		while(!auxHead.isNIL() && auxHead.data != element){
			auxHead = auxHead.next;
		}
		return auxHead.data;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxhead = this.head;
		if(head.isNIL()){
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>();
			newHead.data = element;
			newHead.next = head;
			head = newHead;
		}else{
			while (!auxhead.isNIL()){
				auxhead = auxhead.next;
			}
			auxhead.data = element;
			auxhead.next = new SingleLinkedListNode<T>();
		}
	}

	@Override
	public void remove(T element) {
		if(head.data.equals(element)){
			head = head.next;
		}else{
			SingleLinkedListNode<T> aux = head;
			while (!aux.isNIL() && aux.data != element){
				aux = aux.next;
			}
			if(!aux.isNIL()){
				aux.data = aux.next.data;
				aux.next = aux.next.next;
			}
		}
		
	}

	@Override
	public T[] toArray() {
		T[] elements = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = head;
		int cont = 0;
		while(!aux.isNIL()){
			elements[cont] = aux.data;
			aux = aux.next;
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

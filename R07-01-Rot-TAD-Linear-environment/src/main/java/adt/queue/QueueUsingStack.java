package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}
		if(element != null){
			try{
				this.stack1.push(element);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(this.isEmpty()){
			throw new QueueUnderflowException();
		}
		while(!isEmpty()){
			try{
				this.stack2.push(this.stack1.pop());
			}catch(Exception e){
				break;
			}
		}

		T dequeued = null;

		try{	
			dequeued = stack2.pop();
		}catch(Exception e){}
		
		while(!stack2.isEmpty()){
			try{
				this.stack1.push(this.stack2.pop());
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return dequeued;
	}

	@Override
	public T head() {
		T head = null;
		if(!isEmpty()){
			while(!stack1.isEmpty()){
				try{
					this.stack2.push(this.stack1.pop());
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			head = stack2.top();

			while(!stack2.isEmpty()){
				try{
					this.stack1.push(stack2.pop());
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return head;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}

}

package adt.bst;

import java.util.ArrayList;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	private int height(BSTNode<T> node){
		int result = -1;

		if(!node.isEmpty()){
			result = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
		}

		return result;
	}
	

	@Override
	public BSTNode<T> search(T element) {
		return search(element, this.root);
	}

	private BSTNode<T> search(T element, BSTNode<T> currentNode){
		BSTNode<T> result = new BSTNode<T>();

		if(currentNode.isEmpty() || currentNode.getData().equals(element)){
			result = currentNode;

		}else{
			if(element.compareTo(currentNode.getData()) < 0){
				result = search(element, (BSTNode<T>) currentNode.getLeft());
			}else{
				result = search(element, (BSTNode<T>)currentNode.getRight());
			}
		}

		return result;
	}

	@Override
	public void insert(T element) {
		if(element != null && search(element).isEmpty()){
			this.recursiveInsert(this.getRoot(), element);
		}
	}

	private void recursiveInsert(BSTNode<T> node, T element){
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.getLeft().setParent(node);

			node.setRight(new BSTNode<>());
			node.getRight().setParent(node);
		}else{ 
			if(node.getData().compareTo(element) > 0){
				recursiveInsert((BSTNode<T>)node.getLeft(), element);
			}else if(node.getData().compareTo(element) < 0){
				recursiveInsert((BSTNode<T>)node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;

		if(!isEmpty()){
			result = recursiveMaximum(this.root);
		}
		return result;
	}


	private BSTNode<T> recursiveMaximum(BSTNode<T> node){
		BSTNode<T> result = node;

		if(!node.getRight().isEmpty()){
			result = recursiveMaximum((BSTNode<T>) node.getRight());

		}

		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;

		if(!isEmpty()){
			result = recursiveMinimum(this.root);
		}

		return result;
	}

	private BSTNode<T> recursiveMinimum(BSTNode<T> node){
		BSTNode<T> result = node;

		if(!node.getLeft().isEmpty()){
			result = recursiveMinimum((BSTNode<T>) node.getLeft());
		}

		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = this.search(element);

		BSTNode<T> result = null;

		if(!node.isEmpty()){
			BSTNode<T> right = (BSTNode<T>) node.getRight();
			if(!right.isEmpty()){
				result = recursiveMinimum(right);
			}else{
				result = sucessor(node);
			}
		}
		return result;
	}

	private BSTNode<T> sucessor(BSTNode<T> node){
		BSTNode<T> result = (BSTNode<T>) node.getParent();

		if(node.getParent() != null && !result.isEmpty() && node.equals(result.getRight())){
			result = this.sucessor((BSTNode<T>) result);
		}

		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = this.search(element);

		BSTNode<T> result = null;

		if(!node.isEmpty()){
			BSTNode<T> left = (BSTNode<T>) node.getLeft();
			if(!left.isEmpty()){
				result = recursiveMaximum(left);
			}else{
				result = predecessor(element,(BSTNode<T>) node.getParent());
			}
		}
		return result;
	}

	private BSTNode<T> predecessor(T element, BSTNode<T> currentNode){
		BSTNode<T> result = null;

		if(currentNode == null || currentNode.getData().compareTo(element)< 0){
			result = currentNode;
		}else{
			result = predecessor(element, (BSTNode<T>)currentNode.getParent());
		}

		return result;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		remove(node);
	}

	private boolean hasOneChild(BSTNode<T> node){
		return (node.getLeft().isEmpty() && !node.getRight().isEmpty()) ||
			(!node.getLeft().isEmpty() && node.getRight().isEmpty());
	}

	private void remove(BSTNode<T> node){
		if(node != null && !node.isEmpty()){
			if(node.isLeaf()){
				node.setData(null);
			
			}else if(hasOneChild(node)){
				if(node.getParent() != null){
					if(node.getParent().getData().compareTo(node.getData()) > 0){
						if(!node.getLeft().isEmpty()){
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						}else{
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
						
					}else{
						if(!node.getLeft().isEmpty()){
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						}else{
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}

					}
				}else{
					if(node.getLeft().isEmpty()){
						root = (BSTNode<T>) node.getRight();
					}else{
						root = (BSTNode<T>) node.getLeft();	
					}
					root.setParent(null);
				}
			}else{
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
			}
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<>();
		preOrder(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[this.size()]);

	}

	private void preOrder(ArrayList<T> list, BSTNode<T> node){
		if(node != null &&!node.isEmpty()){
			list.add(node.getData());
			preOrder(list, (BSTNode<T>) node.getLeft());
			preOrder(list, (BSTNode<T>) node.getRight());
		}
	}	

	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<>();
		order(list, this.getRoot());

		return (T[]) list.toArray(new Comparable[this.size()]);
	}

	private void order(ArrayList<T> list, BSTNode<T> node){
		if(node != null && !node.isEmpty()){
			order(list,(BSTNode<T>) node.getLeft());
			list.add(node.getData());
			order(list, (BSTNode<T>)node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<>();
		postOrder(list, this.root);
		return (T[]) list.toArray(new Comparable[this.size()]);
	}

	private void postOrder(ArrayList<T> list, BSTNode<T> node){
		if(node != null  && !node.isEmpty()){
			postOrder(list, (BSTNode<T>) node.getLeft());
			postOrder(list, (BSTNode<T>)node.getRight());
			list.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}

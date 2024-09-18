package adt.bst;

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
		if(this.root.isEmpty()){
			this.root = (BSTNode<T>) new BSTNode.Builder<T>()
								.data(element)
								.left(new BTNode<>())
								.right(new BSTNode<>())
								.build();	
			
			this.root.getLeft().setParent(root);

			this.root.getRight().setParent(root);
		}else{
			this.insert(this.root, element);
		}
	}

	private void insert(BSTNode<T> node, T element){
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);

			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		}else if(element.compareTo(node.getData()) < 0){
			this.insert((BSTNode<T>) node.getLeft(), element);
		}else{
			this.insert((BSTNode<T>) node.getRight(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;

		if(!isEmpty()){
			result = maximum(this.root);
		}
		return result;
	}


	private BSTNode<T> maximum(BSTNode<T> node){
		BSTNode<T> result = node;

		if(!node.getRight().isEmpty()){
			result = maximum((BSTNode<T>) node.getRight());

		}

		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;

		if(!isEmpty()){
			minimum(this.root);
		}

		return result;
	}

	private BSTNode<T> minimum(BSTNode<T> node){
		BSTNode<T> result = node;

		if(!node.getLeft().isEmpty()){
			result = minimum((BSTNode<T>) node.getLeft());
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
				result = minimum(right);
			}else{
				result = sucessor(element, (BSTNode<T>) node.getParent());
			}
		}
		return result;
	}

	private BSTNode<T> sucessor(T element, BSTNode<T> currentNode){
		BSTNode<T> result;

		if(currentNode == null || currentNode.getData().compareTo(element) > 0){
			result = currentNode;
		}else{
			result = sucessor(element, (BSTNode<T>)currentNode.getParent());
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
				result = maximum(left);
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

		if(!node.isEmpty()){
			if(node.isLeaf()){
				if(node == root){
					root = new BSTNode<T>();
				}else{
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
				}

			}else if(node.getRight().isEmpty()){
				if(node == root){
					root =(BSTNode<T>) root.getLeft();
					root.setParent(null);
				}else{
					BSTNode<T> parent = (BSTNode<T>) node.getParent();

					if(node.getLeft().getData().compareTo(parent.getData()) < 0){
						parent.setLeft(node.getLeft());
					}else{
						parent.setRight(node.getLeft());
					}

					node.getLeft().setLeft(parent);

				}

			}else if(node.getLeft().isEmpty()){
				if(node == root){
					root = ((BSTNode<T>) root.getRight());
					root.setParent(null);

				}else{
					BSTNode<T> parent = (BSTNode<T>) node.getParent();
					if(node.getRight().getData().compareTo(parent.getData())<0){
						parent.setLeft(node.getRight());
					}else{
						parent.setRight(node.getRight());
					}

					node.getLeft().setParent(parent);
				}
			}else{
				T aux = minimum((BSTNode<T>) node.getRight()).getData();
				remove(aux);
				node.setData(aux);
			}
		}
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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

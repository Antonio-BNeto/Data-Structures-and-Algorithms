package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	@Override
	public void insert(T element){
		if(element != null){
			recursiveInsert(this.root, element);
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
			if(element.compareTo(node.getData()) < 0){
				recursiveInsert((BSTNode<T>)node.getLeft(), element);
			}else{
				recursiveInsert((BSTNode<T>)node.getRight(), element);
			}
			rebalance(node);
		}

	}

	@Override
	public void remove(T element){
		BSTNode<T> node = this.search(element);
		if(!node.isEmpty()){
			this.recursiveRemove(node);
		}
	}

	private boolean nodeHasOnlyChild(BSTNode<T> node){
		return (!node.getLeft().isEmpty() && node.getRight().isEmpty())
		|| (node.getLeft().isEmpty() && !node.getRight().isEmpty());
	}

	private void recursiveRemove(BSTNode<T> node){
		
		if(node.isLeaf()){
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);
			rebalanceUp(node);

		}else if(nodeHasOnlyChild(node)){
			if(!node.getLeft().isEmpty()){
				if(node.equals(this.root)){
					this.root = (BSTNode<T>)node.getLeft();
					this.root.setParent(null);
				}else{
					node.getLeft().setParent(node.getParent());

					if(node.getData().compareTo(node.getParent().getData()) < 0){
						node.getParent().setLeft(node.getLeft());
					}else{
						node.getParent().setRight(node.getLeft());
					}
				}
			}else if(!node.getRight().isEmpty()){
				if(node.equals(this.root)){
					this.root = (BSTNode<T>) node.getRight();
					this.root.setParent(null);
				}else{
					node.getRight().setParent(node.getParent());

					if(node.getData().compareTo(node.getParent().getData()) < 0){
						node.getParent().setLeft(node.getRight());
					}else{
						node.getParent().setRight(node.getRight());
					}
				}	
			}
			rebalanceUp(node);
		}else{
			BSTNode<T> sucessor = this.sucessor(node.getData());
			T element = sucessor.getData();
			this.recursiveRemove(sucessor);
			node.setData(element);
		}
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int result = 0;

		if(!node.isEmpty()){
			result = this.height((BSTNode<T>)node.getLeft()) - this.height((BSTNode<T>) node.getRight());
		}

		return result;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {

		int balace = this.calculateBalance(node);

		BSTNode<T> aux = null;
		if(Math.abs(balace) > 1){
			if(balace > 1){
				if(this.calculateBalance((BSTNode<T>)node.getLeft())>= 0){
					aux = Util.rightRotation(node);
				}else{
					aux = Util.doubleRightRotation(node);
				}
			}else{
				if(this.calculateBalance((BSTNode<T>)node.getRight())<=0){
					aux = Util.leftRotation(node);
				}else{
					aux = Util.doubleLeftRotation(node);
				}
			}
		}
		
		if(this.getRoot().equals(node) && aux != null){
			this.root = aux;
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if(node.getParent() != null){
			this.rebalance((BSTNode<T>)node.getParent());
			this.rebalanceUp((BSTNode<T>)node.getParent());
		}
	}
}

package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {

		return isBST() && (this.avlTree.isEmpty() || recursiveIsAVLTree(this.avlTree.getRoot()));

		// return isBST() && ...
	}

	private  boolean recursiveIsAVLTree(BSTNode<T> node){
		boolean result = true;

		if(!node.isEmpty()){
			if(Math.abs(this.avlTree.calculateBalance(node)) <= 1){
				result = recursiveIsAVLTree((BSTNode<T>) node.getLeft()) &&
							recursiveIsAVLTree((BSTNode<T>)node.getRight());
			}else{
				result = false;
			}
		}

		return result;
	}

}

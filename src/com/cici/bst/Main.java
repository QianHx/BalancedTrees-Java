package com.cici.bst;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(new BSTNode(10));
		tree.insert(new BSTNode(5));
		tree.insert(new BSTNode(6));
		tree.insert(new BSTNode(19));
		tree.toOrderedArray(tree.root);
		
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}

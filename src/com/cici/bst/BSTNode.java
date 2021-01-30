package com.cici.bst;

public class BSTNode<T> {
	BSTNode<T> left;
	BSTNode<T> right;
	T val;
	
	public BSTNode(T val, BSTNode<T> left, BSTNode<T> right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	public BSTNode(T v) {
		this.val = v;
	}
	public BSTNode() {}
	
	
	
}

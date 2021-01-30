package com.cici.rbtree;

public class IntegerRedBlackTreeNode {
	private IntegerRedBlackTreeNode parent;

	private IntegerRedBlackTreeNode right;
	private IntegerRedBlackTreeNode left;
	private Integer key;
	private Color color;
	
	public IntegerRedBlackTreeNode() {
		this.setParent(null);
		this.left = null;
		this.right = null;
		this.color = Color.Black;
	}

	public IntegerRedBlackTreeNode(Integer k) {
		this();
		this.key = k;
	}
	
	public IntegerRedBlackTreeNode getRight() {
		return right;
	}

	public void setRight(IntegerRedBlackTreeNode right) {
		this.right = right;
	}

	public IntegerRedBlackTreeNode getLeft() {
		return left;
	}

	public void setLeft(IntegerRedBlackTreeNode left) {
		this.left = left;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public IntegerRedBlackTreeNode getParent() {
		return parent;
	}

	public void setParent(IntegerRedBlackTreeNode parent) {
		this.parent = parent;
	}
}

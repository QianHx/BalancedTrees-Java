package com.cici.rbtree;

public class IntegerRedBlackTree {
	public static IntegerRedBlackTreeNode nil = new IntegerRedBlackTreeNode();
	
	private IntegerRedBlackTreeNode root;
	
	public IntegerRedBlackTree() {
		this.root = null;
	}
	
	void insert_case2(IntegerRedBlackTreeNode node) {
		if (node == null || node.getParent() == null || node.getParent().getColor() == Color.Black) {
			return;
		}
		
		insert_case3(node);
	}
	
	void insert_case3(IntegerRedBlackTreeNode node) {
		IntegerRedBlackTreeNode parent = node.getParent();
		IntegerRedBlackTreeNode grandP = parent.getParent();
		IntegerRedBlackTreeNode uncle;
		if (parent == grandP.getLeft()) {
			uncle = grandP.getRight();
		} else {
			uncle = grandP.getLeft();
		}
		
		if(uncle != nil && uncle.getColor() == Color.Red) {
			grandP.setColor(Color.Red);
			parent.setColor(Color.Black);
			uncle.setColor(Color.Black);
			if (grandP.getParent() == null) {
				grandP.setColor(Color.Black);
			} else {
				insert_case2(grandP);
			}
		} else {
			insert_case4(node);
		}
	}
	
	void insert_case4(IntegerRedBlackTreeNode node) {
		IntegerRedBlackTreeNode parent = node.getParent();
		IntegerRedBlackTreeNode grandP = parent.getParent();
		if(node == parent.getRight() && parent == grandP.getLeft()) {
			rotate_left(node);
			node = node.getLeft();
		} else if(node == parent.getLeft() && parent == grandP.getRight()) {
			rotate_right(node);
			node = node.getRight();
		}
		insert_case5(node);
	}
	
	void insert_case5(IntegerRedBlackTreeNode node) {
		IntegerRedBlackTreeNode parent = node.getParent();
		IntegerRedBlackTreeNode grandP = parent.getParent();
		parent.setColor(Color.Black);
		grandP.setColor(Color.Red);
		if(node == parent.getLeft() && parent == grandP.getLeft()) {
			rotate_right(parent);
		} else {
			rotate_left(parent);
		}
	}
	
	void rotate_left(IntegerRedBlackTreeNode node) {
		IntegerRedBlackTreeNode parent = node.getParent();
		if (parent.getParent().getLeft() == parent) parent.getParent().setLeft(node); 
		else parent.getParent().setRight(node);
		
		node.setParent(parent.getParent());
		
		parent.setParent(node);
		parent.setRight(node.getLeft());
		if (node.getLeft() != nil) {
			node.getLeft().setParent(parent);
		}
		
		node.setLeft(parent);
	}
	
	void rotate_right(IntegerRedBlackTreeNode node) {
		IntegerRedBlackTreeNode parent = node.getParent();
		if (parent.getParent().getLeft() == parent) parent.getParent().setLeft(node); 
		else parent.getParent().setRight(node);
		
		node.setParent(parent.getParent());
		
		parent.setParent(node);
		parent.setLeft(node.getRight());
		if (node.getRight() != nil) {
			node.getRight().setParent(parent);
		}
		
		node.setRight(parent);
	}
	
	public IntegerRedBlackTreeNode insert(Integer key) {
		// insert_case1
		if(this.root == null) {
			root = new IntegerRedBlackTreeNode(key);
			root.setColor(Color.Black);
			root.setLeft(nil);
			root.setRight(nil);
			return root;
		}
		
		IntegerRedBlackTreeNode insertPoint = this.findInsertNode(key);
		IntegerRedBlackTreeNode node = new IntegerRedBlackTreeNode(key);
		node.setLeft(nil);
		node.setRight(nil);
		node.setColor(Color.Red);
		
		if(key > insertPoint.getKey()) {
			insertPoint.setRight(node);
			node.setParent(insertPoint);
		} else {
			insertPoint.setLeft(node);
			node.setParent(insertPoint);
		}
		
		// Balance
		insert_case2(node);
		
		return node;
	}

	IntegerRedBlackTreeNode findInsertNode(Integer key) {
		IntegerRedBlackTreeNode cur = this.root;
		IntegerRedBlackTreeNode probe = null;
		while(probe != nil) {
			if (probe != null) cur = probe;
			if (key == cur.getKey()) {
				assert(false);
			} else if (key > cur.getKey()) {
				// cur = cur.getRight();
				probe = cur.getRight();
			} else {
				// cur = cur.getLeft();
				probe = cur.getLeft();
			}
		}
		// return null;
		return cur;
	}
	
	public IntegerRedBlackTreeNode remove(Integer key) {
		if (!this.contains(key)) {
			return null;
		}
		return this.remove(this.search(key));
	}

	public IntegerRedBlackTreeNode remove(IntegerRedBlackTreeNode node) {
		if (!this.contains(node)) {
			return null;
		}
		
		IntegerRedBlackTreeNode nodeToRemove;
		if (node.getLeft() != nil && node.getRight() != nil) {
			// TODO: find the biggest node in the left tree/ the smallest node in the right tree
			
		} else if (node.getLeft() == nil && node.getRight() == nil) {
			
		} else {
			nodeToRemove = node;
		}
		this.delete_one_child(node);
		
		return null;
	}
	
	void delete_one_child(IntegerRedBlackTreeNode node) {
		IntegerRedBlackTreeNode parent = node.getParent();
		IntegerRedBlackTreeNode child;
		if (node.getLeft() != nil) {
			child = node.getLeft();
		} else {
			child = node.getRight();
		}
		
		// Node is root
		if (parent == null) {
			root = child;
		} else {
			// Substitute node and node's child
			if (child != nil) child.setParent(parent);
			if (node == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}	
		
		// Balance the black height
		if (node.getColor() == Color.Black) {
			if (child.getColor() == Color.Red)
				child.setColor(Color.Black);
			else
				delete_case1(child);
		}
	}
	
	void delete_case1(IntegerRedBlackTreeNode node) {
		if (node.getParent() != null)
			delete_case2(node);
	}
	
	void delete_case2(IntegerRedBlackTreeNode node) {
		IntegerRedBlackTreeNode parent = node.getParent();
		IntegerRedBlackTreeNode brother;
		if (node == parent.getLeft()) {
			brother = parent.getRight();
		} else {
			brother = parent.getLeft();
		}
		
		if (brother.getColor() == Color.Red) {
			parent.setColor(Color.Red);
			brother.setColor(Color.Black);
			
			if (node == parent.getLeft()) {
				rotate_left(parent);
			} else {
				rotate_right(parent);
			}
		}
		
		delete_case3(node);
	}
	
	void delete_case3(IntegerRedBlackTreeNode node) {
		IntegerRedBlackTreeNode parent = node.getParent();
		IntegerRedBlackTreeNode brother;
		if (node == parent.getLeft()) {
			brother = parent.getRight();
		} else {
			brother = parent.getLeft();
		}
		
		if (parent.getColor() == Color.Black 
				&& brother.getColor() == Color.Black 
				&& brother.getLeft().getColor() == Color.Black 
				&& brother.getRight().getColor() == Color.Black) {
			brother.setColor(Color.Red);
			delete_case1(parent);
		} else if (parent.getColor() == Color.Red
				&& brother.getColor() == Color.Black
				&& brother.getLeft().getColor() == Color.Black
				&& brother.getRight().getColor() == Color.Black) {
			brother.setColor(Color.Red);
			parent.setColor(Color.Black);
		} else {
			if (brother.getColor() == Color.Black) {
				if (node == parent.getLeft() && brother.getLeft().getColor() == Color.Red
						&& brother.getRight().getColor() == Color.Black) {
					brother.setColor(Color.Red);
					brother.getLeft().setColor(Color.Black);
					rotate_right(brother);
				} else if (node == parent.getRight() && brother.getLeft().getColor() == Color.Black
						&& brother.getRight().getColor() == Color.Red) {
					brother.setColor(Color.Red);
					brother.getRight().setColor(Color.Black);
					rotate_left(brother);
				}
			}
			delete_case5(node);
		}
	}
	
	void delete_case5(IntegerRedBlackTreeNode node) {
		IntegerRedBlackTreeNode parent = node.getParent();
		IntegerRedBlackTreeNode brother;
		if (node == parent.getLeft()) {
			brother = parent.getRight();
		} else {
			brother = parent.getLeft();
		}
		
		brother.setColor(parent.getColor());
		parent.setColor(Color.Black);
		
		if (node == parent.getLeft()) {
			brother.getRight().setColor(Color.Black);
			rotate_left(parent);
		} else {
			brother.getLeft().setColor(Color.Black);
			rotate_right(parent);
		}
	}
	
	public IntegerRedBlackTreeNode search(Integer key) {
		if(this.root == null) return null;
		IntegerRedBlackTreeNode cur = this.root;
		while(cur != nil) {
			if (key == cur.getKey()) {
				// return cur;
				break;
			} else if (key > cur.getKey()) {
				cur = cur.getRight();
			} else {
				cur = cur.getLeft();
			}
		}
		// return null;
		return cur == nil ? null : cur;
	}
	
	public boolean contains(Integer key) {
		return this.search(key) != null;
	}
	
	public boolean contains(IntegerRedBlackTreeNode node) {
		return this.inOrderContains(this.root, node);
	}
	
	void inOrder(IntegerRedBlackTreeNode root) {
		if (root != null) inOrder(root.getLeft());
		// access
		if (root != null) inOrder(root.getRight());
	}
	
	boolean inOrderContains(IntegerRedBlackTreeNode root, IntegerRedBlackTreeNode node) {
		boolean contains = false;
		// boolean inLeft = false, inRight = false, isMe = false;
		if (root != null) contains = inOrderContains(root.getLeft(), node);
		// access
		if (root == node) contains = true;
		// if (root != null) contains = (inOrderContains(root.getRight(), node) ? true : false);
		if (root != null) contains |= inOrderContains(root.getRight(), node);
		// return inLeft || inRight || isMe;
		return contains;
	}
	
	boolean preOrderContains(IntegerRedBlackTreeNode root, IntegerRedBlackTreeNode node) {
		boolean inLeft = false, inRight = false, isMe = false;
		if (root == node) isMe = true;
		if (root != null) inLeft = inOrderContains(root.getLeft(), node);	
		if (root != null) inRight = inOrderContains(root.getRight(), node);
		return inLeft || inRight || isMe;
	}
	
	int getHeight() {
		return 0;
	}

	/*
	@Override
	public String toString() {
		if (this.root == null) {
			return "RedBlackTree Empty";
		}
		int height = this.getHeight();
		StringBuffer s = new StringBuffer();
		ArrayList<IntegerRedBlackTreeNode> queue = new ArrayList<IntegerRedBlackTreeNode>();
		
		int i = 0;
		int nextSize = 0;
		int currentSize = 1;
		int currentTotalSize = 1;
		int level = 0;
		queue.add(this.root);
		while (!queue.isEmpty()) {
			IntegerRedBlackTreeNode node = queue.remove(0);
			
			// for (int i = 0; ) {
				
			// }
			
			if (node.getLeft() != nil) {
				queue.add(node.getLeft());
				nextSize += 1;
			}
			if (node.getRight() != nil) {
				queue.add(node.getRight());
				nextSize += 1;
			}
				
			currentSize -= 1; // Remove current layer
			if (currentSize == 0) {
				currentSize = nextSize;
				currentTotalSize = currentSize;
				nextSize = 0;
				level += 1;
				s.append("\n\n");
			}
		}
		
		
		
		return "RedBlackTree:";
	}
	*/
}

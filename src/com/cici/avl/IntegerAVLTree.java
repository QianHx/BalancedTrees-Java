package com.cici.avl;


public class IntegerAVLTree {
	
	public IntegerAVLTree() {
		root = null;
	}

    private IntegerAVLTreeNode root;

    public IntegerAVLTreeNode find(int key) {
    	IntegerAVLTreeNode current = root;
        while (current != null) {
            if (current.key == key) {
               break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public IntegerAVLTreeNode getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private IntegerAVLTreeNode insert(IntegerAVLTreeNode node, int key) {
        if (node == null) {
            return new IntegerAVLTreeNode(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    private IntegerAVLTreeNode delete(IntegerAVLTreeNode node, int key) {
        if (node == null) {
            return node;
        } else if (node.key > key) {
            node.left = delete(node.left, key);
        } else if (node.key < key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
            	// Change with the minimum node in the left tree
            	IntegerAVLTreeNode mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private IntegerAVLTreeNode mostLeftChild(IntegerAVLTreeNode node) {
    	IntegerAVLTreeNode current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private IntegerAVLTreeNode rebalance(IntegerAVLTreeNode z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
            	// RR
                z = rotateLeft(z);
            } else {
            	// RL
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
            	// LL
                z = rotateRight(z);
            } else {
            	// LR
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private IntegerAVLTreeNode rotateRight(IntegerAVLTreeNode y) {
        IntegerAVLTreeNode x = y.left;
        IntegerAVLTreeNode z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private IntegerAVLTreeNode rotateLeft(IntegerAVLTreeNode y) {
        IntegerAVLTreeNode x = y.right;
        IntegerAVLTreeNode z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(IntegerAVLTreeNode n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(IntegerAVLTreeNode n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(IntegerAVLTreeNode n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }
}

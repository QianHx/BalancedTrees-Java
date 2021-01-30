package com.cici.bst;
import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchTree<T> {
	public BSTNode<T> root;
	
	private Comparator c;
	private int comparedInt = 0;
	
	public BSTNode<T> search(T key){
		if(root == null){
			System.out.println("The tree is empty!");
			return null;
		}
		
		BSTNode<T> current = root;
		while(current.val != key){
			if (key instanceof Comparable) {
				comparedInt = ((Comparable) key).compareTo(current.val);
			}else {
				comparedInt = c.compare(key, current.val);
			}
			
			if(comparedInt > 0)
				current = current.right;
			else
				current = current.left;
			if(current == null)
				return null;
		}
		return current;
	}
	
	public boolean insert(BSTNode<T> node){
		if(root == null){
			root = node;
			return true;
		}
		if(this.search(node.val) != null){
			System.out.println("Node with value '" +
					node.val + "' has already existed!");
			return false;
		}
		BSTNode<T> current = root;
		while(current != null){
			if (node.val instanceof Comparable) {
				comparedInt = ((Comparable) node.val).compareTo(current.val);
			}else {
				comparedInt = c.compare(node.val, current.val);
			}
			if(comparedInt > 0){
				if(current.right == null){
					current.right = node;
					return true;
				}
				current = current.right;
			}else{
				if(current.left == null){
					current.left = node;
					return true;
				}
				current = current.left;
			}
		}
		return false;
	}
	
	public BSTNode<T> min(BSTNode<T> root){
		if(root == null){
			System.out.println("Node dosen't exist!");
			return null;
		}
		if(root.left == null)
			return root;
		BSTNode<T> current = root.left;
		while(current.left != null)
			current = current.left;
		return current;
	}
	
	public BSTNode<T> max(BSTNode<T> root){
		if(root == null){
			System.out.println("Node dosen't exist!");
			return null;
		}
		if(root.right == null)
			return root;
		BSTNode<T> current = root.right;
		while(current.right != null)
			current = current.right;
		return current;
	}


	public boolean delete(T key) {
		if(root == null){
			System.out.println("The tree is empty!");
			return false;
		}
		BSTNode<T> targetParent = root;
		BSTNode<T> target = root;
		boolean isLeftChild = true;
		while(! target.val.equals(key)){
			if (key instanceof Comparable) {
				comparedInt = ((Comparable) key).compareTo(target.val);
			}else {
				comparedInt = c.compare(key, target.val);
			}
			if(comparedInt > 0){
				targetParent = target;
				target = target.right; 
				isLeftChild = false;
			}else{
				targetParent = target;
				target = target.left;
				isLeftChild = true;
			}
			if(target == null)
				break;
		}
		if(target == null){
			System.out.println("Node dosen't exist!");
			return false;
		}
		
		//被删除节点为叶子节点
		if(target.left == null && target.right == null){
			if(target.val == root.val){
				root = null;
				return true;
			}
			if(isLeftChild)
				targetParent.left = null;
			else
				targetParent.right = null;
		} else if(target.left == null && target.right != null) {
			if(target.val == root.val){
				root = root.right;
				return true;
			}
			if(isLeftChild)
				targetParent.left = target.right;
			else
				targetParent.right = target.right;
		}
		//被删除节点只有左子节点
		else if(target.left != null && 
				target.right == null){
			if(target.val == root.val){
				root = root.left;
				return true;
			}
			if(isLeftChild)
				targetParent.left = target.left;
			else
				targetParent.right = target.left;
		}
		else{
			BSTNode<T> preNode = this.getPreNode(target);
			if(target.val == root.val)
				root = preNode;
			else if(isLeftChild)
				targetParent.left = preNode;
			else
				targetParent.right = preNode;
			preNode.left = target.left;
			preNode.right = target.right;
		}
		return true;
	}
	
	public BSTNode<T> getPreNode(BSTNode<T> node) {
		BSTNode<T> nodeParent = node;
		BSTNode<T> current = node.right;
		while(current.left != null){
			nodeParent = current;
			current = current.left;
		}
		if(current.val != node.right.val)
			nodeParent.left = current.right;
		else
			nodeParent.right = current.right;
		return current;
	}
	
	public ArrayList<BSTNode<T>> toOrderedArray(BSTNode<T> node){
		array.clear();
		inorder_iterator(node);
		return array;
	}
	ArrayList<BSTNode<T>> array = new ArrayList<BSTNode<T>>(); 

	public void inorder_iterator(BSTNode<T> node){
		if(node.left != null)
			this.inorder_iterator(node.left);
		array.add(node);
		if(node.right != null)
			this.inorder_iterator(node.right);
	}	
}

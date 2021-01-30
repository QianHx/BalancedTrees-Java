package com.cici.bst;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BSTTest {

	@Test
	@DisplayName("╯°□°）╯")
	void testSearch() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		BSTNode<Integer> node5 = new BSTNode<Integer>(5);
		BSTNode<Integer> node10 = new BSTNode<Integer>(10);
		BSTNode<Integer> node6 = new BSTNode<Integer>(6);
		BSTNode<Integer> node19 = new BSTNode<Integer>(19);
		tree.insert(node10);
		tree.insert(node5);
		tree.insert(node6);
		tree.insert(node19);
		
		assertEquals(tree.search(5), node5); 
		assertEquals(tree.search(15), null); 
	}
	
	@Test
	@DisplayName("QAQ")
	void testDelete() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		BSTNode<Integer> node5 = new BSTNode<Integer>(5);
		BSTNode<Integer> node10 = new BSTNode<Integer>(10);
		BSTNode<Integer> node6 = new BSTNode<Integer>(6);
		BSTNode<Integer> node19 = new BSTNode<Integer>(19);
		tree.insert(node10);
		tree.insert(node5);
		tree.insert(node6);
		tree.insert(node19);
		
		assertEquals(tree.delete(5), true); 
		assertEquals(tree.delete(5), false); 
		assertEquals(tree.delete(10), true); 
	}
	
	@Test
	@DisplayName("QwQ")
	void testMaxMin() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		BSTNode<Integer> node5 = new BSTNode<Integer>(5);
		BSTNode<Integer> node10 = new BSTNode<Integer>(10);
		BSTNode<Integer> node6 = new BSTNode<Integer>(6);
		BSTNode<Integer> node19 = new BSTNode<Integer>(19);
		tree.insert(node10);
		tree.insert(node5);
		tree.insert(node6);
		tree.insert(node19);
		
		assertEquals(tree.max(tree.root), node19); 
		assertEquals(tree.min(tree.root), node5);
	}
	
	@Test
	@DisplayName("TAT")
	void testToArray() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		BSTNode<Integer> node5 = new BSTNode<Integer>(5);
		BSTNode<Integer> node10 = new BSTNode<Integer>(10);
		BSTNode<Integer> node6 = new BSTNode<Integer>(6);
		BSTNode<Integer> node19 = new BSTNode<Integer>(19);
		tree.insert(node10);
		tree.insert(node5);
		tree.insert(node6);
		tree.insert(node19);
		
		ArrayList<BSTNode<Integer>> treeA = tree.toOrderedArray(tree.root);
		ArrayList<BSTNode<Integer>> A = new ArrayList<BSTNode<Integer>>();
		A.add(node5);
		A.add(node6);
		A.add(node10);
		A.add(node19);

		for(int i=0; i<A.size(); ++i) {
			assertEquals(treeA.get(i), A.get(i));
		}
	}
	
	@Test
	@DisplayName("Q_Q")
	void testSearchString() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		BSTNode<String> node5 = new BSTNode<String>("5");
		BSTNode<String> node10 = new BSTNode<String>("10");
		BSTNode<String> node6 = new BSTNode<String>("6");
		BSTNode<String> node19 = new BSTNode<String>("19");
		tree.insert(node10);
		tree.insert(node5);
		tree.insert(node6);
		tree.insert(node19);
		
		assertEquals(tree.search("5"), node5); 
		assertEquals(tree.search("15"), null); 
	}
	
	@Test
	@DisplayName("<3")
	void testSearchMain() {
		BinarySearchTree<Object> tree = new BinarySearchTree<Object>();
		BSTNode<Object> node5 = new BSTNode<Object>(new Object());
		BSTNode<Object> node = new BSTNode<Object>(new Object());
		tree.insert(node5);
		tree.insert(node);
		
		assertEquals(tree.search(new BSTNode<Object>().val), node5);
	}

}

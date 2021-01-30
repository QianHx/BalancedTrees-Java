package com.cici.rbtree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RBTreeInsertTest {

	@Test
	@DisplayName("╯°□°）╯SSS")
	void testSearch() {
		IntegerRedBlackTree tree = new IntegerRedBlackTree();
		
		tree.insert(5);

		IntegerRedBlackTreeNode node = tree.search(3);
		assertEquals(node, null);
	}

	@Test
	@DisplayName("╯°□°）╯")
	void testInsertOneAndSearch() {
		IntegerRedBlackTree tree = new IntegerRedBlackTree();
		
		tree.insert(5);

		IntegerRedBlackTreeNode node = tree.search(5);
		assertNotEquals(node, null);
		assertEquals(node.getColor(), Color.Black);
		assertEquals(node.getKey(), Integer.valueOf(5));
		assertEquals(node.getLeft(), IntegerRedBlackTree.nil);
		assertEquals(node.getRight(), IntegerRedBlackTree.nil);
		assertEquals(node.getParent(), null);
	}
	
	@Test
	@DisplayName("╯°□°）╯2")
	void testInsertTwoAndSearch() {
		IntegerRedBlackTree tree = new IntegerRedBlackTree();
		
		tree.insert(5);
		tree.insert(3);

		IntegerRedBlackTreeNode node = tree.search(5);
		assertNotEquals(node, null);
		assertEquals(node.getColor(), Color.Black);
		assertEquals(node.getKey(), Integer.valueOf(5));
		// assertEquals(node.getLeft(), IntegerRedBlackTree.nil);
		assertEquals(node.getRight(), IntegerRedBlackTree.nil);
		assertEquals(node.getParent(), null);
		
		IntegerRedBlackTreeNode node3 = tree.search(3);
		assertNotEquals(node3, null);
		assertEquals(node3.getColor(), Color.Red);
		assertEquals(node3.getKey(), Integer.valueOf(3));
		assertEquals(node3.getLeft(), IntegerRedBlackTree.nil);
		assertEquals(node3.getRight(), IntegerRedBlackTree.nil);

		assertEquals(node3.getParent(), node);
		assertEquals(node.getLeft(), node3);
	}
	
	@Test
	@DisplayName("╯°□°）╯3")
	void testInsertThreeAndSearch() {
		IntegerRedBlackTree tree = new IntegerRedBlackTree();
		
		tree.insert(5);
		tree.insert(3);
		tree.insert(10);

		IntegerRedBlackTreeNode node = tree.search(5);
		assertNotEquals(node, null);
		assertEquals(node.getColor(), Color.Black);
		assertEquals(node.getKey(), Integer.valueOf(5));
		// assertEquals(node.getLeft(), IntegerRedBlackTree.nil);
		// assertEquals(node.getRight(), IntegerRedBlackTree.nil);
		assertEquals(node.getParent(), null);
		
		IntegerRedBlackTreeNode node3 = tree.search(3);
		assertNotEquals(node3, null);
		assertEquals(node3.getColor(), Color.Red);
		assertEquals(node3.getKey(), Integer.valueOf(3));
		assertEquals(node3.getLeft(), IntegerRedBlackTree.nil);
		assertEquals(node3.getRight(), IntegerRedBlackTree.nil);

		assertEquals(node3.getParent(), node);
		assertEquals(node.getLeft(), node3);
		
		IntegerRedBlackTreeNode node10 = tree.search(10);
		assertNotEquals(node10, null);
		assertEquals(node10.getColor(), Color.Red);
		assertEquals(node10.getKey(), Integer.valueOf(10));
		assertEquals(node10.getLeft(), IntegerRedBlackTree.nil);
		assertEquals(node10.getRight(), IntegerRedBlackTree.nil);

		assertEquals(node10.getParent(), node);
		assertEquals(node.getRight(), node10);
	}
	
	@Test
	@DisplayName("╯°□°）╯6")
	void testInsertSixAndSearch() {
		IntegerRedBlackTree tree = new IntegerRedBlackTree();
		
		tree.insert(5);
		tree.insert(3);
		tree.insert(10);
		IntegerRedBlackTreeNode node5 = tree.search(5);
		IntegerRedBlackTreeNode node3 = tree.search(3);
		IntegerRedBlackTreeNode node10 = tree.search(10);
		assertNotEquals(node3, null);
		assertNotEquals(node5, null);
		assertNotEquals(node10, null);
		assertEquals(node3.getColor(), Color.Red);
		assertEquals(node10.getColor(), Color.Red);
		assertEquals(node5.getColor(), Color.Black);
		tree.insert(2);
		IntegerRedBlackTreeNode node2 = tree.search(2);
		assertNotEquals(node2, null);
		assertEquals(node3.getColor(), Color.Black);
		assertEquals(node10.getColor(), Color.Black);
		assertEquals(node5.getColor(), Color.Black);
		assertEquals(node2.getColor(), Color.Red);
		
		tree.insert(4);
		IntegerRedBlackTreeNode node4 = tree.search(4);
		assertNotEquals(node4, null);
		assertEquals(node3.getColor(), Color.Black);
		assertEquals(node10.getColor(), Color.Black);
		assertEquals(node5.getColor(), Color.Black);
		assertEquals(node2.getColor(), Color.Red);
		assertEquals(node4.getColor(), Color.Red);

		tree.insert(1);
		// Test case 3
		IntegerRedBlackTreeNode node1 = tree.search(1);
		assertNotEquals(node1, null);
		assertEquals(node3.getColor(), Color.Red);
		assertEquals(node10.getColor(), Color.Black);
		assertEquals(node5.getColor(), Color.Black);
		assertEquals(node2.getColor(), Color.Black);
		assertEquals(node4.getColor(), Color.Black);
		assertEquals(node1.getColor(), Color.Red);

		tree.insert(0);
		// Test case 5
		IntegerRedBlackTreeNode node0 = tree.search(0);
		assertNotEquals(node0, null);
		assertEquals(node3.getColor(), Color.Red);
		assertEquals(node10.getColor(), Color.Black);
		assertEquals(node5.getColor(), Color.Black);
		assertEquals(node2.getColor(), Color.Red);
		assertEquals(node4.getColor(), Color.Black);
		assertEquals(node1.getColor(), Color.Black);
		assertEquals(node0.getColor(), Color.Red);
		
		tree.insert(15);
		tree.insert(12);
		// Test case 4
		IntegerRedBlackTreeNode node15 = tree.search(15);
		IntegerRedBlackTreeNode node12 = tree.search(12);
		assertNotEquals(node15, null);
		assertNotEquals(node12, null);
		assertEquals(node3.getColor(), Color.Red);
		assertEquals(node10.getColor(), Color.Red);
		assertEquals(node5.getColor(), Color.Black);
		assertEquals(node2.getColor(), Color.Red);
		assertEquals(node4.getColor(), Color.Black);
		assertEquals(node1.getColor(), Color.Black);
		assertEquals(node0.getColor(), Color.Red);
		assertEquals(node15.getColor(), Color.Red);
		assertEquals(node12.getColor(), Color.Black);
	}

}

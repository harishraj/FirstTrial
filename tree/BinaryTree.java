import java.util.*;

public class BinaryTree {

	class Node {
		int key;
		String name;

		Node leftChild;
		Node rightChild;

		Node(int key, String name) {
			this.key = key;
			this.name = name;
		}

		public String toString() {
			return name + " has the key " + key;
		}
	}

	Node root;

	public void addNode(int key, String name) {

		Node newNode = new Node(key, name);

		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			// Future parent for our new Node
			Node parent;

			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}

				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public Node findNode(int key) {
		Node focusNode = root;
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null)
				return null;
		}
		return focusNode;
	}

	public boolean remove(int key) {

		Node focusNode = root;
		Node parent = root;
		// When searching for a Node this will tell us whether to search to the
		// right or left
		boolean isItALeftChild = true;
		// While we haven't found the Node keep looking
		while (focusNode.key != key) {
			parent = focusNode;
			// If we should search to the left
			if (key < focusNode.key) {
				isItALeftChild = true;
				// Shift the focus Node to the left child
				focusNode = focusNode.leftChild;
			} else {
				// Greater than focus node so go to the right
				isItALeftChild = false;
				// Shift the focus Node to the right child
				focusNode = focusNode.rightChild;
			}
			// The node wasn't found
			if (focusNode == null)
				return false;
		}

		// If Node doesn't have children delete it
		if (focusNode.leftChild == null && focusNode.rightChild == null) {
			// If root delete it
			if (focusNode == root)
				root = null;
			// If it was marked as a left child of the parent delete it in its
			// parent
			else if (isItALeftChild)
				parent.leftChild = null;
			// Vice versa for the right child
			else
				parent.rightChild = null;
		}

		// If no right child
		else if (focusNode.rightChild == null) {
			if (focusNode == root)
				root = focusNode.leftChild;
			// If focus Node was on the left of parent, move the focus Nodes
			// left child up to the parent node

			else if (isItALeftChild)
				parent.leftChild = focusNode.leftChild;
			// Vice versa for the right child
			else
				parent.rightChild = focusNode.leftChild;
		}

		// If no left child
		else if (focusNode.leftChild == null) {
			if (focusNode == root)
				root = focusNode.rightChild;
			// If focus Node was on the left of parent move the focus Nodes
			// right child
			// up to the parent node
			else if (isItALeftChild)
				parent.leftChild = focusNode.rightChild;
			// Vice versa for the left child
			else
				parent.rightChild = focusNode.rightChild;
		}

		// Two children so I need to find the deleted nodes replacement
		else {
			Node replacement = getReplacementNode(focusNode);
			// If the focusNode is root replace root with the replacement
			if (focusNode == root)
				root = replacement;
			// If the deleted node was a left child make the replacement the
			// left child
			else if (isItALeftChild)
				parent.leftChild = replacement;
			// Vice versa if it was a right child
			else
				parent.rightChild = replacement;
			replacement.leftChild = focusNode.leftChild;
		}
		return true;
	}

	private Node getReplacementNode(Node replacedNode) {

		Node replacementParent = replacedNode;
		Node replacement = replacedNode;

		Node focusNode = replacedNode.rightChild;

		// While there are no more left children
		while (focusNode != null) {
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;
		}

		// If the replacement isn't the right child, move the replacement into
		// the parents
		// leftChild slot and move the replaced nodes right child into the
		// replacements rightChild

		if (replacement != replacedNode.rightChild) {
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		return replacement;
	}

	// dfs
	public void preOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode);
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);
		}
	}

	public void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}

	public void postOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}

	public boolean isBST() {
		return (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	/**
	 * Efficient BST helper -- Given a node, and min and max values, recurs down
	 * the tree to verify that it is a BST, and that all its nodes are within
	 * the min..max range. Works in O(n) time -- visits each node only once.
	 */
	private boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return (true);
		} else {
			boolean leftOk = isBST(node.leftChild, min, node.key);
			if (!leftOk)
				return (false);
			boolean rightOk = isBST(node.rightChild, node.key + 1, max);
			return rightOk;
		}
	}

	public int maxDepth() {
		return (maxDepth(root));
	}

	private int maxDepth(Node node) {
		if (node == null) {
			return (0);
		} else {
			int lDepth = maxDepth(node.leftChild);
			int rDepth = maxDepth(node.rightChild);

			return (Math.max(lDepth, rDepth) + 1);
		}
	}

	public boolean isBalanced() {
		return (isBalanced(root));
	}

	public boolean isBalanced(Node root) {
		int leftD, rightD;
		Node focusNode = root;

		if (root == null) {
			return true;
		}
		leftD = maxDepth(focusNode.leftChild);
		rightD = maxDepth(focusNode.rightChild);

		if (Math.abs(leftD - rightD) > 1) {
			return false;
		} else {
			return isBalanced(focusNode.rightChild)
					&& isBalanced(focusNode.leftChild);
		}
	}

	public int minValue() {
		return (minValue(root));
	}

	private int minValue(Node node) {
		Node current = node;
		while (current.leftChild != null) {
			current = current.leftChild;
		}
		return (current.key);
	}

	public int max() {
		return (max(root));
	}

	private int max(Node root) {
		Node focusNode = root;
		while (focusNode.rightChild != null) {
			focusNode = focusNode.rightChild;
		}
		return (focusNode.key);
	}

	public boolean hasPathSum(int sum) {
		return (hasPathSum(root, sum));
	}

	boolean hasPathSum(Node node, int sum) {
		// return true if we run out of tree and sum==0
		if (node == null) {
			return (sum == 0);
		} else {
			// otherwise check both subtrees
			int subSum = sum - node.key;
			return (hasPathSum(node.leftChild, subSum) || hasPathSum(
					node.rightChild, subSum));
		}
	}

	/**
	 * Given a binary tree, prints out all of its root-to-leaf paths, one per
	 * line. Uses a recursive helper to do the work.
	 */
	public void levelTraversal() {
		int[] path = new int[1000];
		printPaths(root, path, 0);
	}

	private void printPaths(Node node, int[] path, int pathLen) {
		if (node == null)
			return;
		// append this node to the path array
		path[pathLen] = node.key;
		pathLen++;
		// it's a leaf, so print the path that led to here
		if (node.leftChild == null && node.rightChild == null) {
			printArray(path, pathLen);
		} else {
			// otherwise try both subtrees
			printPaths(node.leftChild, path, pathLen);
			printPaths(node.rightChild, path, pathLen);
		}
	}

	/**
	 * Utility that prints int from an array on one line.
	 */
	private void printArray(int[] ints, int len) {
		int i;
		for (i = 0; i < len; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println();
	}

	public Node createBSTFromARray(int[] arr) {
		return (createBSTFromArray(arr, 0, arr.length));
	}

	public Node createBSTFromArray(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node root = new Node(mid, "");
		root.leftChild = createBSTFromArray(arr, start, mid - 1);
		root.rightChild = createBSTFromArray(arr, mid + 1, end);
		return root;
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		if (node != null) {
			// do the sub-trees
			mirror(node.leftChild);
			mirror(node.rightChild);
			// swap the left/right pointers
			Node temp = node.leftChild;
			node.leftChild = node.rightChild;
			node.rightChild = temp;
		}
	}

	public void doubleTree() {
		doubleTree(root);
	}

	private void doubleTree(Node node) {
		Node oldLeft;
		if (node == null)
			return;
		// do the subtrees
		doubleTree(node.leftChild);
		doubleTree(node.rightChild);
		// duplicate this node to its left
		oldLeft = node.leftChild;
		node.leftChild = new Node(node.key, node.name);
		node.leftChild = oldLeft;
	}

	public boolean sameTree(Node a, Node b) {
		// 1. both empty -> true
		if (a == null && b == null)
			return (true);
		// 2. both non-empty -> compare them
		else if (a != null && b != null) {
			return ((a.key == b.key) && (sameTree(a.leftChild, b.leftChild)) && (sameTree(
					a.rightChild, b.rightChild)));
		}
		return false;
	}

	public static int countTrees(int numKeys) {
		if (numKeys <= 1) {
			return (1);
		} else {
			// there will be one value at the root, with whatever remains
			// on the left and right each forming their own subtrees.
			// Iterate through all the values that could be the root...
			int sum = 0;
			int left, right, root;
			for (root = 1; root <= numKeys; root++) {
				left = countTrees(root - 1);
				right = countTrees(numKeys - root);
				// number of possible trees with this root == left*right
				sum += left * right;
			}
			return (sum);
		}
	}

	/*
	 * public void byLevel(Node root) { Queue<Node> level = new
	 * LinkedList<Node>(); level.add(root);
	 * 
	 * while (!level.isEmpty()) { Node node = level.poll();
	 * System.out.print(node.item + " "); if (node.leftChild != null)
	 * level.add(node.leftChild); if (node.rightChild != null)
	 * level.add(node.rightChild); } }
	 * 
	 * public void displayTree() { Stack globalStack = new Stack();
	 * globalStack.push(root); int emptyLeaf = 32; boolean isRowEmpty = false;
	 * System
	 * .out.println("****......................................................****"
	 * ); while (isRowEmpty == false) {
	 * 
	 * Stack localStack = new Stack(); isRowEmpty = true; for (int j = 0; j <
	 * emptyLeaf; j++) System.out.print(' '); while (globalStack.isEmpty() ==
	 * false) { Node temp = globalStack.pop(); if (temp != null) {
	 * System.out.print(temp.item); localStack.push(temp.leftChild);
	 * localStack.push(temp.rightChild); if (temp.leftChild != null ||
	 * temp.rightChild != null) isRowEmpty = false; } else {
	 * System.out.print("--"); localStack.push(null); localStack.push(null); }
	 * for (int j = 0; j < emptyLeaf * 2 - 2; j++) System.out.print(' '); }
	 * System.out.println(); emptyLeaf /= 2; while (localStack.isEmpty() ==
	 * false) globalStack.push(localStack.pop()); } System.out
	 * .println("****......................................................****"
	 * ); }
	 */
	public static void main(String[] args) {

		BinaryTree theTree = new BinaryTree();
		theTree.addNode(50, "Boss");
		theTree.addNode(25, "Vice President");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(30, "Secretary");
		theTree.addNode(75, "Sales Manager");
		theTree.addNode(85, "Salesman 1");
		// Different ways to traverse binary trees
		// theTree.inOrderTraverseTree(theTree.root);
		// theTree.preorderTraverseTree(theTree.root);
		// theTree.postOrderTraverseTree(theTree.root);
		// Find the node with key 75

		System.out.println("\nNode with the key 75");
		System.out.println(theTree.findNode(75));
		System.out.println("Remove Key 25");
		theTree.remove(25);
		System.out.println(theTree.findNode(25));
		theTree.inOrderTraverseTree(theTree.root);

		boolean balanced = theTree.isBalanced();
		System.out.println("isBalanced " + balanced);
	}
}

package io.github.marcocaballero;

public class BinTree {
	Node head;

	public BinTree(Node raiz) {
		this.head = raiz;
	}

	public BinTree(int freq) {
		this(new Node(freq));
	}

	public BinTree(int freq, char value) {
		this(new Node(freq, value));
	}

	public Node getHead() {
		return head;
	}

	public void pushOnLeft(BinTree bt) {
		this.head.setLeftChild(bt);
	}

	public void pushOnLeft(Node node) {
		this.head.setLeftChild(new BinTree(node));
	}

	public void pushOnRight(BinTree bt) {
		this.head.setRightChild(bt);
	}

	public void pushOnRight(Node node) {
		this.head.setRightChild(new BinTree(node));
	}

	public boolean isEmpty() {
		return head == null;
	}

	public boolean isLeaf() {
		return !isEmpty() && (head.getLeftChild().isEmpty() && head.getRightChild().isEmpty());
	}

	@Override
	public String toString() {
		return "(" + head + ")";
	}
}

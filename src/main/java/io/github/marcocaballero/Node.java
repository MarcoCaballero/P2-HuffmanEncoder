package io.github.marcocaballero;

public class Node {

	private static final char NULL = '\u0000';
	BinTree leftChild;
	BinTree rightChild;
	int freq;
	char val;

	public Node(int freq, char value) {
		this.freq = freq;
		this.val = value;
		this.leftChild = null;
		this.rightChild = null;
	}

	public Node(int freq) {
		this(freq, NULL);
	}

	public Node(char value) {
		this(0, value);
	}

	public boolean hasLeftChild() {
		return this.leftChild != null;
	}

	public boolean hasRightChild() {
		return this.rightChild != null;
	}

	public BinTree getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinTree leftChild) {
		this.leftChild = leftChild;
	}

	public BinTree getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinTree rightChild) {
		this.rightChild = rightChild;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public char getVal() {
		return val;
	}

	public void addFrequency() {
		this.freq++;
	}

	@Override
	public String toString() {
		// return "(HEAD) -[" + val + ":" + freq + "]" + "" + "(LEFT)" + leftChild +
		// "(RIGHT)" + rightChild;
		return "Node [leftChild=" + leftChild + ", rightChild=" + rightChild + ", freq=" + freq + ", val=" + val + "]";
	}

}

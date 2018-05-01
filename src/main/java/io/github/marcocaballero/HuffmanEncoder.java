package io.github.marcocaballero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class HuffmanEncoder {

	private static final ArrayList<Integer> BAD_SYMBOLS = new ArrayList<Integer>() {
		private static final long serialVersionUID = 1L;

		{
			add(10);
			add(13);
			add(32);
		}
	};
	private ArrayList<BinTree> trees;

	public HuffmanEncoder() {
		trees = new ArrayList<>();
	}

	public String encode(String fileName) throws IOException {
		generateTrees(getClass().getClassLoader().getResourceAsStream(fileName));
		return trees.get(0).toString();
	}

	private void generateEncodeTree() {
		while (trees.size() > 1) {
			Node raiz = new Node(trees.get(0).getHead().getFreq() + trees.get(1).getHead().getFreq());
			raiz.setLeftChild(trees.get(0));
			raiz.setRightChild(trees.get(1));
			trees.remove(1);
			trees.remove(0);
			BinTree firstTree = new BinTree(raiz);
			trees.add(firstTree);
			sortTreesList();
		}
	}

	private void generateTrees(InputStream input) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(input));

		ArrayList<Character> chars = new ArrayList<>();

		int c;
		while ((c = br.read()) != -1) {
			char ch = (char) c;
			if (chars.contains(ch)) {
				updateFrequency(ch);
			} else if (!BAD_SYMBOLS.contains(c)) {
				chars.add(ch);
				trees.add(new BinTree(1, ch));
			}
		}

		sortTreesList();
		generateEncodeTree();
	}

	private void updateFrequency(char ch) {
		for (BinTree tree : trees) {
			if (tree.getHead().getVal() == ch) {
				tree.getHead().addFrequency();
			}
		}
	}

	private void sortTreesList() {
		Collections.sort(trees, new BinTreeComparator());
	}
}

package io.github.marcocaballero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
	private Map<Character, String> huffmanCodes;
	private InputStream input;

	public HuffmanEncoder() {
		trees = new ArrayList<BinTree>();
	}

	public String encode(String fileName) throws IOException {
		input = getClass().getClassLoader().getResourceAsStream(fileName);
		generateTrees();
		// generateTrees(true); // encode special characters
		fillHuffmanCodes(trees.get(0), "");
		return generateTranslation();
	}

	private String generateTranslation() throws IOException {
		String encoded = "";
		int c;
		input.reset();
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		while ((c = br.read()) != -1) {
			char ch = (char) c;
			if (huffmanCodes.containsKey(ch)) {
				encoded += huffmanCodes.get(ch);
			} else {
				encoded += ch;
			}
		}
		return encoded;
	}

	private void fillHuffmanCodes(BinTree head, String code) {
		if (head.isLeaf()) {
			huffmanCodes.put(head.getHead().getVal(), code);
			code = "";
		}
		if (head.getHead().hasLeftChild()) {
			fillHuffmanCodes(head.getHead().getLeftChild(), code + "0");
		}
		if (head.getHead().hasRightChild()) {
			fillHuffmanCodes(head.getHead().getRightChild(), code + "1");
		}
	}

	private void generateEncodeTree() {
		while (trees.size() > 1) {
			trees.add(mergeTreest(trees.get(0), trees.get(1)));
			sortTreesList();
		}
	}

	private BinTree mergeTreest(BinTree a, BinTree b) {
		Node raiz = new Node(a.getHead().getFreq() + b.getHead().getFreq());
		raiz.setLeftChild(a);
		raiz.setRightChild(b);
		updateQueue();
		return new BinTree(raiz);
	}

	private void updateQueue() {
		trees.remove(1);
		trees.remove(0);
	}

	private void generateTrees() throws IOException {
		generateTrees(false);
	}

	private void generateTrees(boolean permit) throws IOException {
		input.mark(0);
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		huffmanCodes = new HashMap<Character, String>();
		int c;
		while ((c = br.read()) != -1) {
			char ch = (char) c;
			if (huffmanCodes.containsKey(ch)) {
				updateFrequency(ch);
			} else if (!BAD_SYMBOLS.contains(c) || permit) {
				huffmanCodes.put(ch, "");
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

package io.github.marcocaballero;

import java.util.Comparator;

public class BinTreeComparator implements Comparator<BinTree> {
	@Override
	public int compare(BinTree bt1, BinTree bt2) {
		return new Integer(bt1.getHead().getFreq()).compareTo(new Integer(bt2.getHead().getFreq()));
	}
}

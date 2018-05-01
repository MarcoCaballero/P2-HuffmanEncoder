package io.github.marcocaballero;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/*
		 * Simulates a medium-long message.
		 * 
		 */
		System.out.println("Result: " + new HuffmanEncoder().encode("message"));
		System.out.println("\n");
		
		/*
		 * Simulates a medium-long message.
		 * 
		 * Allowing specials characters like blank spaces, returns of carries, etc....
		 */
		System.out.println("Result: " + new HuffmanEncoder(true).encode("message"));
		System.out.println("\n");
		/*
		 * Simulates P2 subject, but with 100 characters (avoiding 100.000)
		 */
		System.out.println("Result: " + new HuffmanEncoder().encode("simulateP2Data"));
		System.out.println("\n");
		

		/*
		 * Simulates P2 subject, but with 100 characters (avoiding 100.000)
		 * 
		 * Allowing specials characters like blank spaces, returns of carries, etc....
		 */
		System.out.println("Result: " + new HuffmanEncoder(true).encode("simulateP2Data"));
		System.out.println("\n");
	}

}

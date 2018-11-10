package view;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import util.WordlistGeneratorAB;

public class App {

	public static void main(String[] args) {
		
		Character[] arrayA = {'0', '1', '2', '3', '4', '5', '6', '7'};
		Character[] arrayB = {'a', 'b', 'c'};
		
		List<Character> conjuntoA = new ArrayList<>(Arrays.asList(arrayA));
		int quantA = 5;
		
		List<Character> conjuntoB = new ArrayList<>(Arrays.asList(arrayB));
		int quantB = 2;
		
		WordlistGeneratorAB generator = new WordlistGeneratorAB();
		List<String> wordlist = generator.generate(conjuntoA, quantA, conjuntoB, quantB);
		
		printWordlist(wordlist, 15);
		System.out.println("Quant.: " + wordlist.size());
		
	}
	
	private static void printWordlist(List<String> wordlist, int columnSize) {
		
		int count = 0;
		
		for(String word : wordlist) {
			System.out.print(word+" ");
			if(++count > columnSize) {
				count = 0;
				System.out.println("");
			}
		}
		
	}
	
}

package util;

import java.util.ArrayList;
import java.util.List;

public class WordlistGeneratorAB {
	
	public static List<String> generate(List<Character> conjuntoA, int sizeA, List<Character> conjuntoB, int sizeB) {		
		
		List<String> wordlist = new ArrayList<>();
		
		// Buscando combinacoes para A e para B separados
		WordlistGenerator generator = new WordlistGenerator();
		List<String> wordlistA = generator.generate(conjuntoA, sizeA);
		List<String> wordlistB = generator.generate(conjuntoB, sizeB);
		
		// Inserindo valores de B dentro de A para todas as posicoes possiveis
		for(String wordA : wordlistA) {
			int possiblesPos = wordA.length() + 1;
			
			for(String wordB: wordlistB) {
				
				char b1 = wordB.charAt(0);
				char b2 = wordB.charAt(1);
				
				for(int pos1 = 0; pos1 < possiblesPos; pos1++) {
					for(int pos2 = pos1 + 1; pos2 < possiblesPos+1; pos2++) {
						
						String newString = insertIntoPosition(wordA, b1, pos1);
						newString = insertIntoPosition(newString, b2, pos2);
						
						wordlist.add(newString);						
					}
				}
			}
		}		
		return wordlist;
	}
	
	public static String insertIntoPosition(String string, char letra, int position) {		
		if(position<=0) {
			return letra+string;
		}
		if(position>=string.length()) {
			return string+letra;
		}		
		return string.substring(0, position)+letra+string.substring(position, string.length());
	}
	
}

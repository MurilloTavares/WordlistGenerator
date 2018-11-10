package util;

import java.util.ArrayList;
import java.util.List;

public class WordlistGeneratorAB {
	
	private List<String> wordlist;
	
	public List<String> generate(List<Character> conjuntoA, int sizeA, List<Character> conjuntoB, int sizeB) {		
		
		this.wordlist = new ArrayList<>();
		
		// Buscando combinacoes para A e para B separados
		WordlistGenerator generator = new WordlistGenerator();
		List<String> wordlistA = generator.generate(conjuntoA, sizeA);
		List<String> wordlistB = generator.generate(conjuntoB, sizeB);
		
		// Inserindo valores de B dentro de A para todas as posicoes possiveis
		for(String wordA : wordlistA) {
			
			for(String wordB: wordlistB) {				
				startInsertChain(wordA, wordB, sizeB);
			}
		}		
		return wordlist;
	}
	
	private void startInsertChain(String wordA, String wordB, int numChain){		
		
		insertChain(0, wordA.length()+1, wordA, wordB, 0, numChain);
		
	}
	
	private void insertChain(int startPos, int finalPos, String wordToInsert, String wordToLetra, int letraPos, int remaingChain) {
		
		remaingChain--;
		
		for(int pos = startPos; pos < finalPos; pos++) {			
			
			char letra = wordToLetra.charAt(letraPos);
			String newWord = insertIntoPosition(wordToInsert, letra, pos);
			
			// Caso precise continuar interacao
			if(remaingChain > 0) {
					
				insertChain(pos+1, finalPos+1, newWord, wordToLetra, letraPos+1, remaingChain);
				
			} else {
				// Caso ultima interacao
				this.wordlist.add(newWord);
			}
								
		}
		
	}
	
	private String insertIntoPosition(String string, char letra, int position) {		
		if(position<=0) {
			return letra+string;
		}
		if(position>=string.length()) {
			return string+letra;
		}		
		return string.substring(0, position)+letra+string.substring(position, string.length());
	}
	
}

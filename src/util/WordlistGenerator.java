package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

public class WordlistGenerator {
	
	private List<String> wordList = new ArrayList<>();
	private int wordize;
	
	public List<String> generate(List<Character> conjunto, int wordsize){
		this.wordize = wordsize;
		this.wordList = new ArrayList<>();
		buildWords(conjunto);
		return this.wordList;
	}
	
	private void buildWords(List<Character> conjunto) {		
		buildWordsChain(conjunto, "");
	}
	
	private void buildWordsChain(List<Character> conjunto, String word) {		
		for(Character letra : conjunto) {			
			// Instanciando nova palavra para nao modificar a palavra de referencia
			String newWord = word + letra;
			
			// Criando um novo conjunto com as letras que restaram
			List<Character> remaining = sublistExcept(conjunto, letra);
			
			if(word.length() + 1 < this.wordize) {
				buildWordsChain(remaining, newWord);				
			} else {				
				// Caso ultima letra
				this.wordList.add(newWord);	
			}			
		}
	}
	
	private List<Character> sublistExcept(List<Character> list, Character except){
		List<Character> sublist = new ArrayList<>();
		sublist.addAll(list);
		sublist.remove(except);
		return sublist;
	}

}

package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WordlistWriter {
	
	private PrintWriter writer;
	
	public void write(List<String> wordlist) throws IOException {
	
		File file = new File("wordlist.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		writer = new PrintWriter(file);
		
		System.out.println("Escrevendo em wordlist.txt ...");
		writer.print(wordlist);
		System.out.println("Escrita completa.");
		
	}
	
	public void close() {
		writer.close();
	}

}

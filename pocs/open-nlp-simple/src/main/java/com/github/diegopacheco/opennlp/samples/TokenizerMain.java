package com.github.diegopacheco.opennlp.samples;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class TokenizerMain {
	public static void main(String[] args) throws Throwable{
		
		InputStream is = new FileInputStream("en-token.bin");
		 
		TokenizerModel model = new TokenizerModel(is);
		Tokenizer tokenizer = new TokenizerME(model);
	 
		String tokens[] = tokenizer.tokenize("Hi. How are you? This is Mike.");
		for (String a : tokens)
			System.out.println(a);
	 
		is.close();
		
	}
}

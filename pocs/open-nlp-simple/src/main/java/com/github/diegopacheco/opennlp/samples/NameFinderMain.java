package com.github.diegopacheco.opennlp.samples;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

public class NameFinderMain {
	public static void main(String[] args) throws Throwable{
		
		InputStream is = new FileInputStream("en-ner-person.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
	 
		NameFinderME nameFinder = new NameFinderME(model);
		String []sentence = new String[]{
			    "Mike",
			    "Smith",
			    "is",
			    "a",
			    "good",
			    "person"
			    };
	 
			Span nameSpans[] = nameFinder.find(sentence);
			for(Span s: nameSpans)
				System.out.println("Name Spam: " + s.toString());	
		
	}
}

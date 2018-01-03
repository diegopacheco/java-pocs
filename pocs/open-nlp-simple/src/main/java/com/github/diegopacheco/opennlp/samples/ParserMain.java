package com.github.diegopacheco.opennlp.samples;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

public class ParserMain {
	public static void main(String[] args) throws Throwable{
		
		InputStream is = new FileInputStream("en-parser-chunking.bin");
		 
		ParserModel model = new ParserModel(is);
	 
		Parser parser = ParserFactory.create(model);
	 
		String sentence = "Programcreek is a very huge and useful website.";
		Parse topParses[] = ParserTool.parseLine(sentence, parser, 1);
	 
		for (Parse p : topParses)
			p.show();
	 
		is.close();
		
	}
}

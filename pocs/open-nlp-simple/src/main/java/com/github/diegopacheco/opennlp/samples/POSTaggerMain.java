package com.github.diegopacheco.opennlp.samples;

import java.io.File;
import java.nio.charset.Charset;

import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.SystemInputStreamFactory;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class POSTaggerMain {
	public static void main(String[] args) throws Throwable{
		
		POSModel model = new POSModelLoader()	
				.load(new File("en-pos-maxent.bin"));
			PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
			POSTaggerME tagger = new POSTaggerME(model);
		 
			String input = "Hi. How are you? This is Mike."; // paste this on the console and type ENTER to work.
			ObjectStream<String> lineStream = new PlainTextByLineStream(new SystemInputStreamFactory(), Charset.forName("UTF-8"));
		 
			perfMon.start();
			String line;
			while ((line = lineStream.read()) != null) {
		 
				String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(line);
				String[] tags = tagger.tag(whitespaceTokenizerLine);
		 
				POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
				System.out.println(sample.toString());
		 
				perfMon.incrementCounter();
			}
			perfMon.stopAndPrintFinalResult();
		}
		
	}

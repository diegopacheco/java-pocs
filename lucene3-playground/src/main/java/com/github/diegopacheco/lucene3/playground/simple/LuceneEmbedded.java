package com.github.diegopacheco.lucene3.playground.simple;

import java.io.IOException;

import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

/**
 * Simple Lucene Embed class utility :-)
 * 
 * @author Diego Pacheco
 * @version 1.0-SNAPSHOT
 * 
 */
public class LuceneEmbedded {
	
	private static RAMDirectory 	  directory;
	private static IndexWriterConfig  conf;
	private static IndexWriter 		  writer;
	private static IndexSearcher 	  searcher;
	
	private static LuceneEmbedded instance;
	
	private LuceneEmbedded() {
		setup();
	}
	
	public synchronized static LuceneEmbedded build(){
		if (instance==null) instance = new LuceneEmbedded();
		return instance;
	}
	
	private void setup(){
		try{
			directory = new RAMDirectory();		
			conf      = new IndexWriterConfig(Version.LUCENE_31,new SimpleAnalyzer(Version.LUCENE_31));
			writer    = new IndexWriter(directory, conf);
		}catch(Exception e){
			throw new RuntimeException(e);
		}		
	}
	
	public void index(){
		try{
			writer.close();
			searcher  = new IndexSearcher(directory);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void addDoc(Document doc){
		try{
			writer.addDocument(doc);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public TopDocs queryTop(Query query){
		try{
			return searcher.search(query, null, 10);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public Document getById(int key){
		try{
			return searcher.doc(key);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		LuceneEmbedded luceneEmbedded = LuceneEmbedded.build();
		
		Document doc = new Document();
		doc.add(new Field("partnum", "Q36", Field.Store.YES,Field.Index.NOT_ANALYZED));
		doc.add(new Field("description", "Illidium Space Modulator",Field.Store.YES, Field.Index.ANALYZED));		
		
		luceneEmbedded.addDoc(doc);
		luceneEmbedded.index();

		Query query = new TermQuery(new Term("partnum", "Q36"));
		TopDocs rs  = luceneEmbedded.queryTop(query);
		System.out.println("Total Hits :" + rs.totalHits);

		Document firstHit = luceneEmbedded.getById(rs.scoreDocs[0].doc);
		System.out.println("First Doc: " + firstHit.getField("partnum").name());
	}

}

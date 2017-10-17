package com.bogspot.diegopacheco.sandbox.java.fast;

import java.util.Properties;

import com.fastsearch.esp.search.ISearchFactory;
import com.fastsearch.esp.search.SearchFactory;
import com.fastsearch.esp.search.query.BaseParameter;
import com.fastsearch.esp.search.query.IQuery;
import com.fastsearch.esp.search.query.Query;
import com.fastsearch.esp.search.result.IDocumentSummary;
import com.fastsearch.esp.search.result.IDocumentSummaryField;
import com.fastsearch.esp.search.result.IQueryResult;
import com.fastsearch.esp.search.view.ISearchView;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class SimpleFAST {

	public static void main(String[] args) throws Exception {		
		try{
			// Pull out information from command line
			String host = "10.1.1.71";
			String port = "15100";
			String query = "";
			String viewName = "callcenter"; //"espsystemwebcluster";
			String hostport = host + ":" + port;

			Properties p = new Properties();
			p.setProperty("com.fastsearch.esp.search.SearchFactory", "com.fastsearch.esp.search.http.HttpSearchFactory");
			p.setProperty("com.fastsearch.esp.search.http.qrservers", hostport);
			
			// [DIEGO-PACHECO:IMPROV.] Cache in memory
			ISearchFactory searchFactory = SearchFactory.newInstance(p);

			// Printing list of views.
			if (viewName.length() == 0) {
				String[] list = searchFactory.getSearchViewList();

				System.out.println("Views located at " + host + ":" + port + "\n");

				if (list.length > 0) {
					for (int i = 0; i < list.length; i++)
						System.out.println(list[i]);
				} else {
					System.out.println("No views found.\n");
				}

				return;
			}
			
			// Show the collections
			ISearchView svr = searchFactory.getSearchView("callcenter");
			System.out.println("Collections: " + svr.getContentSpecification().getCollections());

			for (int i = 3; i < args.length; i++) {
	            if (args[i].trim().startsWith("-")) continue; 
	            query += args[i];
				query += " ";
			}
			
	        // Creating FQL sentence
	        query = query.replaceAll("\"", "\\\"");
	        String fql = "string(\"" + query + "\", mode=simpleall)";        
			
			ISearchView view = searchFactory.getSearchView(viewName);

			// Creating the query and do a search.              
			IQuery theQuery = new Query(fql);
			theQuery.setParameter(BaseParameter.HITS, 10);
			System.out.println("Request params: " + view.getRequestParameters(theQuery));
	        
			IQueryResult result = view.search(theQuery);
			theQuery.setParameter(BaseParameter.HITS, 10);
			System.out.println(result);
			
			System.out.println("**************");
			
		    // Display rank for most relevant document
	        if (result.getDocCount() > 0) {
	           IDocumentSummary docSummary = result.getDocument(1);
	           IDocumentSummaryField sumField = docSummary.getSummaryField("rank");
	           System.out.print("\n\nDocument #1 had the rank value: ");
	           System.out.println(sumField.toString());
	        }
	        else {
	            System.out.print("\n\nYour query returned 0 documents.\n\n");
	        }

	        // Print out a result document for document, field for field 
	        // without knowing the field names.
	        for (int i = 1; i <= 10 ; i++) 
	        {
	           System.out.println("\n");
	           System.out.print("================= Document ");
	           System.out.print(i);
	           System.out.println(" =================");
	           IDocumentSummary docSummary = result.getDocument(i);
	           
	           for (int j = 0; j < docSummary.fieldCount(); j++)
	           {
	              IDocumentSummaryField sumField = docSummary.getSummaryField(j);
	              System.out.print(sumField.getName());
	              System.out.print(" => ");
	              System.out.println(sumField.toString());
	           } 
	        }

		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
}

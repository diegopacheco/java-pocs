package com.bogspot.diegopacheco.sandbox.java.fast;

import java.util.Iterator;
import java.util.Properties;

import com.fastsearch.esp.search.ConfigurationException;
import com.fastsearch.esp.search.ISearchFactory;
import com.fastsearch.esp.search.SearchEngineException;
import com.fastsearch.esp.search.SearchFactory;
import com.fastsearch.esp.search.navigation.Navigation;
import com.fastsearch.esp.search.query.BaseParameter;
import com.fastsearch.esp.search.query.IQuery;
import com.fastsearch.esp.search.query.Query;
import com.fastsearch.esp.search.query.SearchParameter;
import com.fastsearch.esp.search.result.IModifier;
import com.fastsearch.esp.search.result.INavigator;
import com.fastsearch.esp.search.result.IQueryResult;
import com.fastsearch.esp.search.view.ISearchView;

/**
 * 
 * @author Diego Pacheco
 * 
 */
public class SimpleNavigator {

	private ISearchFactory iSearchFactory = null;

	public ISearchFactory getFactory() {
		if (iSearchFactory == null) {
			String host = "10.1.1.71";
			String port = "15100";
			String hostport = host + ":" + port;

			Properties p = new Properties();
			p.setProperty("com.fastsearch.esp.search.SearchFactory", "com.fastsearch.esp.search.http.HttpSearchFactory");
			p.setProperty("com.fastsearch.esp.search.http.qrservers", hostport);

			ISearchFactory searchFactory = null;
			try {
				searchFactory = SearchFactory.newInstance(p);
			} catch (ConfigurationException e) {
				throw new RuntimeException(e);
			}
			iSearchFactory = searchFactory;
			return searchFactory;
		} else {
			return iSearchFactory;
		}

	}

	public ISearchView getSearchView(String searchView) {
		try {
			return getFactory().getSearchView(searchView);
		} catch (SearchEngineException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String createFQL(String query){
		String fql = "string(\"" + query + "\", mode=simpleall)";
		return fql;
	}
	
	public IQuery createFQLWithNavigators(String fql){

		SearchParameter param = new SearchParameter(BaseParameter.NAVIGATION, 1);
		
		// Traz apenas un navigator
		SearchParameter param2 = new SearchParameter(BaseParameter.NAVIGATORS, "locationsnavigator");
				
		String fqlString = createFQL(fql);
		IQuery query = new Query(fqlString);
		query.setParameter(param);
		
		// adiciona parametro de restrição de navigators.
		query.setParameter(param2);
		
		return query; 
	}
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Throwable{

		SimpleNavigator sn = new SimpleNavigator();
		ISearchView isv    = sn.getSearchView("callcenter");
		IQuery query 	   = sn.createFQLWithNavigators("");
		
		IQueryResult firstResult = isv.search(query);
		// Abort this navigator example program if there are no navigators in the search result
		if (firstResult.navigatorCount() == 0) {
			System.out.println("\nThere are no navigators in the search result");
			return;
		}

		// Print out each navigator with its data
		System.out.println("\nFIRST SEARCH RESULT\n==================");
		System.out.println("The result contains the navigators listed below with data as shown on next line");
		System.out.println("[ (name), (hits), (unit), (min), (max), (mean), (sum) ] \n");
		INavigator lastNavigator = null;

		for (Iterator itr = firstResult.navigators(); itr.hasNext();) {
			INavigator navigator = (INavigator) itr.next();
			System.out.print("[");
			System.out.print(" (" + navigator.getDisplayName() + "),");
			System.out.print(" (" + navigator.getHits() + "),");
			System.out.print(" (" + navigator.getUnit() + "),");
			System.out.print(" (" + navigator.getMin() + "),");
			System.out.print(" (" + navigator.getMax() + "),");
			System.out.print(" (" + navigator.getMean() + ")");
			System.out.print(" (" + navigator.getSum() + ")");
			System.out.println(") ]");
			lastNavigator = navigator;
		}

		// Print out the modifer for the last navigator from above
		System.out.print("\n\nNavigator \"" + lastNavigator.getDisplayName() + "\" has the modifiers ");
		System.out.println("listed below (data as on the next line)");
		System.out.println("[ (modifier name), (hits), (actual query value), (document ratio) ] \n");

		for (Iterator itr = lastNavigator.modifiers(); itr.hasNext();) {
			IModifier modifier = (IModifier) itr.next();
			System.out.print("[");
			System.out.print(" (" + modifier.getName() + "),");
			System.out.print(" (" + modifier.getCount() + "),");
			System.out.print(" (" + modifier.getValue() + "),");
			System.out.print(" (" + modifier.getDocumentRatio() + ")");
			System.out.println(") ]");
		}

		// Create an navigation object. Use it to create an "adjustment"
		// (to previous query) based on navigators and modifiers.
		Navigation navigation = new Navigation();

		// Use the navigation object to create a new (adjusted) query
		IQuery drillDownQuery = new Query(query);

		// Instruments new query with navigation parameters.
		navigation.instrument(drillDownQuery);

		IQueryResult drillDownResult = isv.search(drillDownQuery);

		// Dump the new drill downed search result to the terminal window
		System.out.println("\nSEARCH RESULT AFTER DRILL DOWN\n==============================");
		System.out.println(drillDownResult);

	}
}

package com.github.diegopacheco.sandbox.java.crawler;

import java.io.File;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class ControllerMain {
	public static void main(String[] args) throws Exception {
		
		try {
			new File("/tmp/crawler-data/").mkdir();
		}catch(Exception e) {}
		
		String crawlStorageFolder = "/tmp/crawler-data/";
		int numberOfCrawlers = 7;

		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(crawlStorageFolder);

		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

		controller.addSeed("http://www.valor.com.br/valor-data/tabela/5854/petroleo");
		controller.start(MyCrawler.class, numberOfCrawlers);
	}
}

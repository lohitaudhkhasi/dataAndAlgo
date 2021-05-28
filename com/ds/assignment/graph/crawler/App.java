package com.ds.assignment.graph.crawler;

public class App {
	public static void main(String[] args) {
		WebCrawler w = new WebCrawler();
		w.discoverWeb("https://www.bbc.com/news");
		
	}
}

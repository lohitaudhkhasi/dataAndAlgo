package com.ds.assignment.graph.crawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
	private Queue<String> queue;
	private List<String> discoveredSites;
	
	public WebCrawler() {
		this.queue = new LinkedList<>();
		discoveredSites = new ArrayList<>();
	}
	
	public void discoverWeb(String root) {
		this.queue.add(root);
		this.discoveredSites.add(root);
		
		while (!queue.isEmpty()) {
			String s = queue.remove();
			String rawHtml = readURL(s);
			String regex = "http://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(rawHtml);
			while(matcher.find()) {
				String actualUrl = matcher.group();
				System.out.println(actualUrl);
				if (!discoveredSites.contains(actualUrl)) {
					discoveredSites.add(actualUrl);
					queue.add(actualUrl);
					
				}
			}
		}
	}

	private String readURL(String s) {
		String rawHTML = "";
		try {
			URL url = new URL (s);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLIne = "";
			while((inputLIne = in.readLine()) != null) {
				rawHTML+= inputLIne;
			}
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rawHTML;
	}
}

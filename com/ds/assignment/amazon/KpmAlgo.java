package com.ds.assignment.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KpmAlgo {
	public static void main(String[] args) {
		String pattern = "abcabyab";
		KpmAlgo kmp = new KpmAlgo();
		System.out.println(Arrays.toString(kmp.lps(pattern)));
		System.out.println(pattern.substring(0, 1));
		Map map = new HashMap<>();
		Double d = Double.POSITIVE_INFINITY;
		System.out.println(d);
		d = Double.valueOf(Integer.MIN_VALUE);
		System.out.println(d);
	}
	
    
    class Graph{
        int V;
        ArrayList[] list;
        
        Graph(int v){
            this.V = v;
            list = new ArrayList[v+1];
        }
        
        public void addEdges(ArrayList<ArrayList<Integer>> edges){
            for(int i = 0 ; i < edges.size(); i++) {
                list[edges.get(i).get(0)].add(edges.get(i).get(1));
                list[edges.get(i).get(1)].add(edges.get(i).get(0));
            }
        }
    }
    
	public int[] lps(String p) {
		int[] lps = new int[p.length()];
		int j = 1; 
		int i = 0;
		lps[0] = 0;
		while ( j < p.length()) {
			if (p.charAt(i) == p.charAt(j)) {
				lps[j++] = ++i;
			} else {
				if ( i!= 0) {
					i = lps[i-1];
				} else {
					lps[j++] = 0;
				}
			}
		}
		return lps;
	}
}

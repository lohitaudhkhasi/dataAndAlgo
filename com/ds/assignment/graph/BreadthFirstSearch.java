package com.ds.assignment.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	public void traverse(Vertex rootVertex) {
		Queue<Vertex> queue = new LinkedList<>();
		
		rootVertex.setVisted(true);
		queue.add(rootVertex);
		
		while(!queue.isEmpty()) {
			Vertex curr = queue.poll();
			System.out.println("Actual visited vertex:" + curr);
			for (Vertex v : curr.getAdjacencyList()) {
				if (!v.isVisted()) {
					v.setVisted(true);
					queue.add(v);
				}
			}
		}
	}
}

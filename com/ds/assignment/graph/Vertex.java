package com.ds.assignment.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private String name;
	private boolean visted;
	private List<Vertex> adjacencyList;
	
	public Vertex(String name) {
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}
	
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisted() {
		return visted;
	}

	public void setVisted(boolean visted) {
		this.visted = visted;
	}

	public List<Vertex> getAdjacencyList() {
		return adjacencyList;
	}

	public void addNeighbor(Vertex vertex) {
		this.adjacencyList.add(vertex);
	}
}

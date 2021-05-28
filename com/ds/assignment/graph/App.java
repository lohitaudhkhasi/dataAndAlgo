package com.ds.assignment.graph;

public class App {
	public static void main(String[] args) {
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex g = new Vertex("g");
		Vertex h = new Vertex("h");
		
		a.addNeighbor(b);
		a.addNeighbor(f);
		a.addNeighbor(g);
		
		b.addNeighbor(a);
		b.addNeighbor(c);
		b.addNeighbor(d);
		
		c.addNeighbor(b);
		
		d.addNeighbor(b);
		d.addNeighbor(e);
		
		f.addNeighbor(a);
		
		g.addNeighbor(a);
		g.addNeighbor(h);
		h.addNeighbor(g);
		
		bfs.traverse(a);
	}
}

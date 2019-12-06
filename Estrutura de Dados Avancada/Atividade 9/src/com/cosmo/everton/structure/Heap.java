package com.cosmo.everton.structure;


import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Heap {

	private PriorityQueue<Node> heap = new PriorityQueue<Node>(Collections.reverseOrder());
	
	
	public PriorityQueue<Node> getHeap() {
		return heap;
	}
	
	public Heap(List <Node> nodes) { 
		insert(nodes);
	}
	public  void insert(List <Node> nodes) { 
		heap.addAll(nodes);
	}
	
	@Override
	public String toString() {
		Object array[] = this.heap.toArray();
		StringBuilder sb = new StringBuilder();
		for(Object obj: array) { 
//			System.out.println(obj);
			sb.append("[NODEHEAP:");
			sb.append(obj);
			sb.append("");
			sb.append("]\n");
		} 
		
		
		return sb.toString();
	}
}

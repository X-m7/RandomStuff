package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import general.DisjointSets;

public class MinSpanningTree {
	
	public static void main(String[] args) {
		List<WeightedNode<Integer>> adjList = new ArrayList<WeightedNode<Integer>>();
		adjList.add(null); //null first element for easy reference to the nodes (1 to 10)
		for (int counter = 1; counter <= 7; counter++) { //create the nodes
			adjList.add(new WeightedNode<Integer>(counter));
		}
		adjList.get(1).addEdge(adjList.get(2), 1); //connect the nodes
		adjList.get(1).addEdge(adjList.get(4), 4);
		adjList.get(2).addEdge(adjList.get(2), 1);
		adjList.get(2).addEdge(adjList.get(3), 2);
		adjList.get(2).addEdge(adjList.get(5), 4);
		adjList.get(3).addEdge(adjList.get(2), 2);
		adjList.get(3).addEdge(adjList.get(6), 6);
		adjList.get(4).addEdge(adjList.get(1), 4);
		adjList.get(4).addEdge(adjList.get(2), 6);
		adjList.get(4).addEdge(adjList.get(5), 3);
		adjList.get(4).addEdge(adjList.get(7), 4);
		adjList.get(5).addEdge(adjList.get(2), 4);
		adjList.get(5).addEdge(adjList.get(4), 3);
		adjList.get(5).addEdge(adjList.get(6), 8);
		adjList.get(5).addEdge(adjList.get(7), 7);
		adjList.get(6).addEdge(adjList.get(3), 6);
		adjList.get(6).addEdge(adjList.get(5), 8);
		adjList.get(6).addEdge(adjList.get(7), 3);
		adjList.get(7).addEdge(adjList.get(4), 4);
		adjList.get(7).addEdge(adjList.get(5), 7);
		adjList.get(7).addEdge(adjList.get(6), 3);
		adjList.remove(0); //remove the null added earlier, no longer needed
		System.out.println(kruskal(adjList));
	}

	public static <T> List<Edge<WeightedNode<T>>> kruskal(List<WeightedNode<T>> adjList) {
		DisjointSets<WeightedNode<T>> connectedComponents = new DisjointSets<WeightedNode<T>>();
		List<Edge<WeightedNode<T>>> edges = new ArrayList<Edge<WeightedNode<T>>>();
		List<Edge<WeightedNode<T>>> output = new ArrayList<Edge<WeightedNode<T>>>();
		for (WeightedNode<T> node : adjList) { //fill the queue of edges
			for (Edge<WeightedNode<T>> edge : node.getEdges()) {
				edges.add(edge);
			}
			connectedComponents.makeSet(node);
		}
		Collections.sort(edges);
		for (Edge<WeightedNode<T>> edge : edges) {
			if (connectedComponents.findSet(edge.getOrigin()) != connectedComponents.findSet(edge.getDestination())) { //add the edge if it will not make a cycle
				output.add(edge);
				connectedComponents.union(edge.getOrigin(), edge.getDestination()); //and put the two vertices in the same connected component
			}
			if (connectedComponents.getNoOfSets() == 1) { //once all vertices are accounted for no need to check the other edges
				break;
			}
		}
		return output;
	}
	
}

package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {

	public static void main(String[] args) {
		List<TopoSortNode<Integer>> adjList = new ArrayList<TopoSortNode<Integer>>();
		adjList.add(null); //null first element for easy reference to the nodes (1 to 10)
		for (int counter = 1; counter <= 10; counter++) { //create the nodes
			adjList.add(new TopoSortNode<Integer>(counter));
		}
		adjList.get(1).addAdjacentNode(adjList.get(2)); //connect the nodes
		adjList.get(2).addAdjacentNode(adjList.get(3));
		adjList.get(2).addAdjacentNode(adjList.get(5));
		adjList.get(4).addAdjacentNode(adjList.get(1));
		adjList.get(4).addAdjacentNode(adjList.get(7));
		adjList.get(5).addAdjacentNode(adjList.get(8));
		adjList.get(6).addAdjacentNode(adjList.get(9));
		adjList.get(7).addAdjacentNode(adjList.get(8));
		adjList.get(8).addAdjacentNode(adjList.get(9));
		adjList.remove(0); //remove the null added earlier, no longer needed
		System.out.println(topoSort(adjList)); //print the result
	}
	
	public static <T> Deque<T> topoSort(List<TopoSortNode<T>> adjList) {
		Deque<T> output = new LinkedList<T>();
		for (TopoSortNode<T> node : adjList) { //run the algorithm for every node (in case there are disconnected components)
			if (!node.isVisited()) { //but only do so if the node isn't already visited
				topoSortRec(node, output);
			}
		}
		return output;
	}
	
	private static <T> void topoSortRec(TopoSortNode<T> start, Deque<T> output) {
		start.setVisited(true);
		for (Node<T> node : start.getAdjacentNodes()) { //try visiting all adjacent nodes
			TopoSortNode<T> topoNode = (TopoSortNode<T>) node;
			if (!topoNode.isVisited()) { //visit the node only if it hasn't been previously
				topoSortRec(topoNode, output);
			}
		}
		output.offerFirst(start.getValue()); //after the loop it means that it is a dead end or there are no more nodes to visit
	}

}

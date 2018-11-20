package graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WeightedNode<T> {

	private T value;
	private List<Edge<WeightedNode<T>>> edges;
	
	public WeightedNode(T newValue) {
		value = newValue;
		edges = new LinkedList<Edge<WeightedNode<T>>>();
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public List<Edge<WeightedNode<T>>> getEdges() {
		return Collections.unmodifiableList(edges);
	}
	
	public void addEdge(WeightedNode<T> destination, int weight) {
		edges.add(new Edge<WeightedNode<T>>(this, destination, weight));
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}

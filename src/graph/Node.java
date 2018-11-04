package graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Node<T> {

	private T value;
	private List<Node<T>> adjacentNodes;
	
	public Node(T newValue) {
		value = newValue;
		adjacentNodes = new LinkedList<Node<T>>();
	}

	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}

	public List<Node<T>> getAdjacentNodes() {
		return Collections.unmodifiableList(adjacentNodes);
	}
	
	public void addAdjacentNode(Node<T> node) {
		adjacentNodes.add(node);
	}
}

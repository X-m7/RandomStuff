package graph;

public class TopoSortNode<T> extends Node<T> {
	
	private boolean visited;

	public TopoSortNode(T newValue) {
		super(newValue);
		setVisited(false);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}

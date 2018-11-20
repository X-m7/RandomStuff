package graph;

public class Edge<T> implements Comparable<Edge<T>>{

	private T origin;
	private T destination;
	private int weight;
	
	public Edge(T newOrigin, T newDestination, int newWeight) {
		origin = newOrigin;
		destination = newDestination;
		weight = newWeight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public T getOrigin() {
		return origin;
	}

	public T getDestination() {
		return destination;
	}
	
	@Override
	public String toString() {
		return "Edge from " + origin + " to " + destination + " with weight " + weight;
	}

	@Override
	public int compareTo(Edge<T> arg0) {
		if (getWeight() < arg0.getWeight()) {
			return -1;
		}
		else if (getWeight() > arg0.getWeight()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
}

package general;

import java.util.HashMap;
import java.util.Map;

public class DisjointSets<T> {

	private Map<T, T> parentMap;
	private Map<T, Integer> rankMap;
	private int noOfSets;
	
	public DisjointSets() {
		parentMap = new HashMap<T, T>();
		rankMap = new HashMap<T, Integer>();
		noOfSets = 0;
	}
	
	public void makeSet(T in) {
		parentMap.put(in, in); //create a new set with itself as the root
		rankMap.put(in, 0); //start with rank 0 since it has no levels
		noOfSets++;
	}
	
	public T findSet(T in) {
		T root = in; //start from the input
		while (root != parentMap.get(root)) { //find the actual root
			root = parentMap.get(root);
		}
		T temp = parentMap.get(in);
		while (temp != root) { //connect everything on the way to root directly to minimize level
			parentMap.put(in, root); //connect to root
			in = temp;
			temp = parentMap.get(in); //then check its parent
		}
		return root;
	}
	
	private void mergeTrees(T root1, T root2) {
		if (root1 == root2) {
			return;
		}
		if (rankMap.get(root1) < rankMap.get(root2)) { //if root2's tree has higher rank use root2 as the final root
			parentMap.put(root1, root2);
		}
		else if (rankMap.get(root1) > rankMap.get(root2)) { //if the other way around
			parentMap.put(root2, root1);
		}
		else { //if they both have the same rank then pick one as the new root (will mean that the rank will increase for the final tree)
			parentMap.put(root1, root2); //could be the other way around, doesn't matter here
			rankMap.put(root2, rankMap.get(root2) + 1);
		}
		noOfSets--;
	}
	
	public void union(T in1, T in2) {
		mergeTrees(findSet(in1), findSet(in2));
	}
	
	public int getNoOfSets() {
		return noOfSets;
	}
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SSTFCalculator {
	
	private int reference;
	
	public void run(int start, int[] data) {
		List<SSTFInt> list = new ArrayList<SSTFInt>();
		for (int x : data) {
			list.add(new SSTFInt(x));
		}
		reference = start;
		int sum = 0;
		while (!list.isEmpty()) {
			Collections.sort(list);
			sum += list.get(0).getDistanceFromReference();
			reference = list.get(0).getData();
			list.remove(0);
		}
		System.out.println(sum);
	}

	private class SSTFInt implements Comparable<SSTFInt> {

		private int data;
		
		public SSTFInt(int data) {
			this.data = data;
		}
		
		public int getDistanceFromReference() {
			return Math.abs(data - reference);
		}
		
		public int getData() {
			 return data;
		}
		
		@Override
		public int compareTo(SSTFInt arg0) {
			if (this.getDistanceFromReference() < arg0.getDistanceFromReference()) {
				return -1;
			}
			else if (this.getDistanceFromReference() > arg0.getDistanceFromReference()) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
	}
	
	public static void main(String[] args) {
		new SSTFCalculator().run(1167, new int[] {1045, 750, 932, 878, 1365, 1787, 1245, 664, 1678, 1897});
	}
	
}

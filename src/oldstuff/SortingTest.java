package oldstuff;
import java.util.ArrayList;
import java.util.List;

public class SortingTest {

	public static void run() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		for (int counter = 0; counter < 10; counter++) {
			input.add((int) (Math.random() * 1000));
		}
		System.out.println(input);
		bubbleSort(input);
		System.out.println(input);

	}

	public static void mergeSort(ArrayList<Integer> array) {
		mergeSortRec(array, 0, array.size() - 1);
	}

	/*
	 * 1st array goes from begin to mid, 2nd goes from mid+1 to end
	 */
	public static void merge(ArrayList<Integer> array, int begin, int mid, int end) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int leftIndex = begin;
		int rightIndex = mid + 1;
		while (leftIndex <= mid && rightIndex <= end) {
			if (array.get(leftIndex) <= array.get(rightIndex)) { // <= ensures stability, since left one will come
																	// before right
				temp.add(array.get(leftIndex));
				leftIndex++;
			} else {
				temp.add(array.get(rightIndex));
				rightIndex++;
			}
		}
		for (int counter = leftIndex; counter <= mid; counter++) {
			temp.add(array.get(counter));
		}
		for (int counter = rightIndex; counter <= end; counter++) {
			temp.add(array.get(counter));
		}
		for (int counter = begin; counter <= end; counter++) {
			array.set(counter, temp.get(0));
			temp.remove(0);
		}
	}

	public static void mergeSortRec(ArrayList<Integer> array, int begin, int end) {
		if (begin == end) {
			return;
		}
		int mid = (begin + end) / 2;
		mergeSortRec(array, begin, mid);
		mergeSortRec(array, mid + 1, end);
		merge(array, begin, mid, end);
	}

	/*
	 * bubbles bigger elements up every time here, so the end gets sorted
	 */
	public static void bubbleSort(List<Integer> list) {
		for (int counter = list.size() - 1; counter > 0; counter--) { // counter is the last index that needs checking
																		// (past this is good)
			for (int counter2 = 0; counter2 < counter; counter2++) {
				if (list.get(counter2) > list.get(counter2 + 1)) { // swap
					int temp = list.get(counter2);
					list.set(counter2, list.get(counter2 + 1));
					list.set(counter2 + 1, temp);
				}
			}
		}
	}
}

package oldstuff;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTest {

	public int runCounter = 0;

	public <T extends Comparable<T>> int binarySearch(ArrayList<T> list, T target) {
		int midIndex = list.size() / 2;
		int i = 0;
		int j = list.size() - 1;
		boolean found = true;
		while (list.get(midIndex).compareTo(target) != 0) {
			runCounter++;
			if (i == j) {
				found = false;
				break;
			}
			if (list.get(midIndex).compareTo(target) < 0) {
				i = midIndex + 1;
			} else {
				j = midIndex - 1;
			}
			midIndex = ((j - i + 1) / 2) + i;
			if (midIndex < 0 || midIndex >= list.size()) {
				found = false;
				break;
			}
		}
		if (found) {
			return midIndex;
		} else {
			return -1;
		}
	}

	public int searchDataEqualsIndex2(List<Integer> list) {
		int midIndex = list.size() / 2;
		int i = 0;
		int j = list.size() - 1;
		boolean found = true;
		while (list.get(midIndex).compareTo(midIndex) != 0) {
			runCounter++;
			if (i == j) {
				found = false;
				break;
			}
			if (list.get(midIndex).compareTo(midIndex) < 0) {
				i = midIndex + 1;
			} else {
				j = midIndex - 1;
			}
			midIndex = ((j - i + 1) / 2) + i;
			if (midIndex < 0 || midIndex >= list.size()) {
				found = false;
				break;
			}
		}
		if (found) {
			return midIndex;
		} else {
			return -1;
		}
	}

	public int searchDataEqualsIndex(ArrayList<Integer> list) {
		for (int counter = 0; counter < list.size(); counter++) {
			list.set(counter, list.get(counter) - counter);
		}
		return binarySearch(list, 0);
	}
}

package oldstuff;

import java.util.LinkedList;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		StringSortTest.run();
	}

	public static void oldMain() {
		List<Integer> list = new LinkedList<Integer>();
		list.add(9);
		list.add(60);
		list.add(5);
		list.add(17);
		list.add(6);
		System.out.println(maxInList(list));
		System.out.println(factorial(7));
		System.out.println(factorialTailRec(7));
		list.add(900);
		list.add(20);
		list.add(5);
		list.add(170);
		list.add(60);
		System.out.println(maxTest(list, 0));
		String[][] table = new String[4][];
		table[0] = new String[] { "Head1", "Head2", "Head3" };
		table[1] = new String[] { "test", "test2", "test3" };
		table[2] = new String[] { "test", "test2", "test3" };
		table[3] = new String[] { "test", "test2", "test3" };
		for (Object[] row : table) {
			System.out.format("%10s%10s%10s\n", row);
		}
	}

	public static int max(int m, int n) {
		if (m > n) {
			return m;
		} else if (m < n) {
			return n;
		} else {
			return 0;
		}
	}

	public static int maxInList(List<Integer> list) {
		return maxInListRec(list, 0);
	}

	private static int maxInListRec(List<Integer> list, int lastMax) {
		if (list.size() == 0) {
			return lastMax;
		} else {
			return maxInListRec(list, max(lastMax, list.remove(0)));
		}
	}

	public static int factorial(int factorialMax) {
		int factorialResult = 1, counter = 2; // initialize loop: result=1, counter = 2
		while (counter <= factorialMax) { // condition: counter <= max
			factorialResult *= counter; // statements: fR = fR * counter, counter++
			counter++;
		}
		return factorialResult; // output: fR
	}

	public static int factorialTailRec(int factorialMax) {
		return factorialTailRecHelper(factorialMax, 1, 2); // same as initialize loop
	}

	private static int factorialTailRecHelper(int factorialMax, int factorialResult, int counter) {
		if (counter <= factorialMax) { // same as loop condition
			factorialResult *= counter; // same as statements
			counter++;
			return factorialTailRecHelper(factorialMax, factorialResult, counter);
		} else {
			return factorialResult; // same as loop output
		}
	}

	public static int maxTest(List<Integer> list, int oldMax) {
		int temp = 0;
		if (list.size() != 0) {
			temp = list.remove(0);
		}
		if (oldMax < temp) {
			oldMax = temp;
			return maxTest(list, oldMax);
		} else if (list.size() == 0) {
			if (oldMax < temp) {
				return temp;
			} else {
				return oldMax;
			}
		} else {
			return maxTest(list, oldMax);
		}
	}
}

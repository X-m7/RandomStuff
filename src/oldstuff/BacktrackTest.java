package oldstuff;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacktrackTest {

	public static void run() {
		ArrayList<Integer> start = new ArrayList<Integer>();
		List<List<Integer>> out = rec(start, Arrays.asList(1, 2, 3, 4));
		System.out.println(out);
	}

	public static List<List<Integer>> rec(List<Integer> currentPerm, List<Integer> remainingChoices) {
		ArrayList<List<Integer>> out = new ArrayList<List<Integer>>();
		if (remainingChoices.size() == 1) {
			ArrayList<Integer> finalPerm = new ArrayList<Integer>(currentPerm);
			finalPerm.add(remainingChoices.get(0));
			out.add(finalPerm);
			return out;
		}
		for (Integer i : remainingChoices) {
			ArrayList<Integer> newRemaining = new ArrayList<Integer>(remainingChoices);
			newRemaining.remove(i);
			ArrayList<Integer> newPerm = new ArrayList<Integer>(currentPerm);
			newPerm.add(i);
			out.addAll(rec(newPerm, newRemaining));
		}
		return out;
	}

	public static void perm(int n) {
		boolean[] used = new boolean[n + 1];
		int[] x = new int[n + 1];
		for (int k = 1; k <= n; k++) {
			used[k] = false;
		}
		for (int k = 1; k <= n; k++) {
			x[k] = k;
		}
		reperm(1, n, used, x);
	}

	public static void reperm(int k, int n, boolean[] used, int[] x) {
		for (int s = 1; s <= n; s++) {
			if (!used[s]) {
				used[s] = true;
				x[k] = s;
				if (k == n) {
					for (int i = 1; i <= n; i++) {
						System.out.print(x[i] + "");
					}
				} else {
					reperm(k + 1, n, used, x);
				}
				used[s] = false;
			}
		}
	}

	public static void all_subsets(int n) {
		int[] x = new int[n + 1];
		rec_all_subsets(n, 1, x);
	}

	public static void rec_all_subsets(int n, int k, int[] x) {
		System.out.println("rec");
		for (int s = 0; s <= 1; s++) {
			x[k] = s;
			if (k == n) {
				for (int i = 1; i <= n; i++) {
					if (x[i] == 1) {
						System.out.print(i + " ");
					}
				}
			} else {
				rec_all_subsets(n, k + 1, x);
			}
		}
	}

}

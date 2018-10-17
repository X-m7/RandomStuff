package oldstuff;
import java.util.Arrays;

public class StringSortTest {

	public static void run() {
		String[] list = new String[] { "(0) H1 uses dispenser 1 (time: 4)", "(0) H2 uses dispenser 1 (time: 4)",
				"(0) H10 uses dispenser 1 (time: 4)" };
		Arrays.sort(list);
		for (String s : list) {
			System.out.println(s);
		}
	}
}

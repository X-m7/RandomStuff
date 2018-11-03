import java.util.Arrays;
import java.util.Random;

public class OutputParameterTest {

	public static void main(String[] args) {
		Random r = new Random();
		int[] array = new int[] {r.nextInt(50), r.nextInt(50), r.nextInt(50), r.nextInt(50), r.nextInt(50), r.nextInt(50)};
		System.out.println("Original: " + Arrays.toString(array));
		Arrays.sort(array); //the array parameter here is both input and output parameter
		System.out.println("After calling Arrays.sort(): " + Arrays.toString(array));
	}

}

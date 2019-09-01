import java.util.Scanner;

public class Black_Square {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int[] a = new int[4];
		String s = "";
		int calories = 0;

		for (int i = 0; i < 4; i++)
			a[i] = t.nextInt();

		s = t.next();

		for (int i = 0; i < s.length(); i++) {
			calories += a[Integer.parseInt(s.substring(i, i + 1))-1];
		}

		System.out.println(calories);

	}

}

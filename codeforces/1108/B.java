import java.util.Arrays;
import java.util.Scanner;

public class Divisors_Of_Two_Integers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];
		int x = 1, y = 1;

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		Arrays.sort(a);

		for (int i = 0; i < n - 1; i++) {
			if (a[i] == a[i + 1])
				y = a[i];

			if (a[n - 1] % a[i] != 0)
				y = a[i];
		}

		x = a[n - 1];

		System.out.println(x + " " + y);
	}

}

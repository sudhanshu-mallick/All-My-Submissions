import java.util.Arrays;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		Arrays.sort(a);

		if (n % 2 == 0)
			System.out.println(a[n / 2 - 1]);
		else
			System.out.println(a[n / 2]);

	}

}
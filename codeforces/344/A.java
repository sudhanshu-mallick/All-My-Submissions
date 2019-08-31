import java.util.Scanner;

public class Magnets {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		int group = 1;

		for (int i = 0; i < n - 1; i++) {
			if (a[i] != a[i + 1])
				group++;
		}

		System.out.println(group);

	}

}
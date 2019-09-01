import java.util.Scanner;

public class Adjacent_Replacements {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		for (int i = 0; i < n; i++) {
			if (a[i] % 2 == 0)
				a[i] -= 1;

			System.out.print(a[i] + " ");
		}

	}

}
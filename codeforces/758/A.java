import java.util.Scanner;

public class Holiday_Of_Equality {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int[] a = new int[n];
		int max = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (max < a[i])
				max = a[i];
		}

		for (int i = 0; i < n; i++) {
			sum += max - a[i];
		}

		System.out.println(sum);

	}

}

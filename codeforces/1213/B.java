import java.util.Scanner;

public class Bad_Prices {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int q = t.nextInt();

		while (q-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];
			int bad = 0;
			int max = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				a[i] = t.nextInt();
			}

			for (int i = n - 1; i >= 0; i--) {
				if (a[i] > max)
					bad++;
				max = Math.min(max, a[i]);
			}
			System.out.println(bad);
		}

	}

}

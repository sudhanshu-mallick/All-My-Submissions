import java.util.Arrays;
import java.util.Scanner;

public class K_For_The_Price_Of_One_1 {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			long p = t.nextLong();
			int k = t.nextInt();
			long[] a = new long[n];
			long max = 0, odd = 0, even = 0;

			for (int i = 0; i < n; i++) {
				a[i] = t.nextLong();
			}

			Arrays.sort(a);

			for (int i = 0; i < n; i++) {
				if (i % 2 == 0)
					odd += a[i];
				else
					even += a[i];
			}

			for (int i = n - 1; i >= 0; i--) {
				if (i % 2 == 0) {
					if (odd <= p) {
						max = i + 1;
						break;
					} else
						odd -= a[i];
				} else {
					if (even <= p) {
						max = i + 1;
						break;
					} else
						even -= a[i];
				}
			}

			System.out.println(max);

		}

	}

}
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
			long max = 0;
			long[] cost = new long[n + 1];

			for (int i = 0; i < n; i++) {
				a[i] = t.nextLong();
			}

			Arrays.sort(a);

			for (int i = 1; i <= n; i++) {
				cost[i] = cost[i - 1] + a[i - 1];

				if (i - k >= 0)
					cost[i] = Math.min(cost[i], cost[i - k] + a[i - 1]);

				if (cost[i] <= p) {
					max = i;
				} 
			}

			System.out.println(max);

		}
	}
}
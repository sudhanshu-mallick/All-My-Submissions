import java.util.*;
import java.io.*;

public class Candies {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] dp = new int[n + 1];

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt();
			dp[i + 1] = dp[i] + x;
		}

		int q = t.nextInt();

		while (q-- > 0) {
			int x = t.nextInt();
			int y = t.nextInt();

			System.out.println((dp[y] - dp[x - 1]) / 10);
		}
	}

}
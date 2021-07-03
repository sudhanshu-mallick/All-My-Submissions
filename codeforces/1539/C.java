import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class C {

	static PrintWriter out = new PrintWriter(System.out);

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

	public static void shuffle(long[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(long[] a, int i, int j) {
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		long k = sc.nextLong();
		long x = sc.nextLong();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}

		shuffle(arr);

		List<Long> diff = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			long kRequired = (arr[i + 1] - arr[i] - 1) / x;
			if (kRequired > 0) {
				diff.add(kRequired);
			}
		}
		Collections.sort(diff);
		int ans = diff.size() + 1;
		for (long num : diff) {
			if (num <= k) {
				k -= num;
				ans--;
			}
		}
		out.println(ans);
		out.close();
	}
}
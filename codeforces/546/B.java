import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Soldiers_And_Badges {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt(), cost = 0;
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();
		}

		Arrays.sort(a);

		for (int i = 1; i < n; i++) {
			if (a[i] == a[i - 1]) {
				a[i]++;
				cost++;
			} else if (a[i] < a[i - 1]) {
				cost += a[i - 1] - a[i];
				a[i] += a[i - 1] - a[i];
				a[i]++;
				cost++;
			}
		}

		o.println(cost);
		o.flush();
		o.close();

	}

}
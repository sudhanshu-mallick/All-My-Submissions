import java.util.*;
import java.io.*;

public class Good_Sequence {

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
		int n = t.nextInt();
		int[] dp = new int[100001];

		if (n == 1)
			o.println("1");
		else {
			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();
				List<Integer> list = fact(x);
				int max = 0;

				for (int val : list) {
					max = Math.max(max, dp[val]);
				}

				max++;

				for (int val : list) {
					dp[val] = max;
				}
			}

			int max = 0;

			for (int i = 0; i < dp.length; ++i)
				max = Math.max(max, dp[i]);

			o.println(max);

		}
		o.flush();
		o.close();
	}

	public static List<Integer> fact(int n) {
		List<Integer> list = new ArrayList<>();
		// Print the number of 2s that divide n
		if (n % 2 == 0) {
			list.add(2);

			while ((n & 1) == 0) {
				n = n >> 1;
			}
		}

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				list.add(i);

				while (n % i == 0) {
					n /= i;
				}
			}
		}

		if (n > 2)
			list.add(n);

		return list;
	}
}
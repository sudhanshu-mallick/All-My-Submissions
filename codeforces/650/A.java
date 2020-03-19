import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Watchmen {

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
		int[][] a = new int[n][2];
		long ans = 0;
		HashMap<Integer, Integer> mx = new HashMap<>();
		HashMap<Integer, Integer> my = new HashMap<>();
		HashMap<String, Integer> pair = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int x = t.nextInt();
			int y = t.nextInt();
			String s = x + "-" + y;

			if (mx.containsKey(x)) {
				mx.put(x, mx.get(x) + 1);
			} else
				mx.put(x, 1);

			if (my.containsKey(y)) {
				my.put(y, my.get(y) + 1);
			} else
				my.put(y, 1);

			if (pair.containsKey(s)) {
				pair.put(s, pair.get(s) + 1);
			} else
				pair.put(s, 1);
		}

		for (int p : mx.keySet()) {
			long q = mx.get(p);
			ans += q * (q - 1) / 2;
		}

		for (int p : my.keySet()) {
			long q = my.get(p);
			ans += q * (q - 1) / 2;
		}

		for (String p : pair.keySet()) {
			long q = pair.get(p);
			ans -= q * (q - 1) / 2;
		}

		o.println(ans);
		o.flush();
		o.close();
	}
}
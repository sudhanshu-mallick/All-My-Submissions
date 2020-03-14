import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Winner {

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
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> win = new HashMap<>();
		Pair[] a = new Pair[n];
		int m = 0;

		for (int i = 0; i < n; i++) {
			String s = t.next();
			int score = t.nextInt();
			a[i] = new Pair(s, score);

			if (map.containsKey(s)) {
				map.put(s, map.get(s) + score);
			} else {
				map.put(s, score);
			}
		}

		m = map.get(a[0].s);

		for (int sc : map.values())
			m = Math.max(sc, m);

		for (int i = 0; i < n; i++) {
			if (map.get(a[i].s) != m) {

			} else {

				int val = 0;

				if (win.containsKey(a[i].s))
					val = win.get(a[i].s);

				if (val + a[i].score >= m) {
					o.println(a[i].s);
					break;
				}

				win.put(a[i].s, val + a[i].score);
			}
		}

		o.flush();
		o.close();

	}

}

class Pair {
	String s;
	int score;

	Pair(String s, int score) {
		this.s = s;
		this.score = score;
	}
}
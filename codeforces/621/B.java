import java.util.*;
import java.io.*;

public class Wet_Shark_And_Bishop {

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
		HashMap<Integer, Integer> m1 = new HashMap<>();
		HashMap<Integer, Integer> m2 = new HashMap<>();
		long ans = 0;

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt();
			int y = t.nextInt();
			int s = x + y;
			int d = x - y;

			if (m1.containsKey(s))
				m1.put(s, m1.get(s) + 1);
			else
				m1.put(s, 1);

			if (m2.containsKey(d))
				m2.put(d, m2.get(d) + 1);
			else
				m2.put(d, 1);
		}

		for (Map.Entry entry : m1.entrySet()) {
			int val = (int) entry.getValue();
			ans += ((val) * (val - 1)) / 2;
		}

		for (Map.Entry entry : m2.entrySet()) {
			int val = (int) entry.getValue();
			ans += ((val) * (val - 1)) / 2;
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}
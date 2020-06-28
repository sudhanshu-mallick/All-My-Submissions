
import java.util.*;
import java.io.*;

public class Reading_Books {

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
		int k = t.nextInt();
		List<Integer> both = new ArrayList<>();
		List<Integer> alice = new ArrayList<>();
		List<Integer> bob = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			int val = t.nextInt();
			int x = t.nextInt();
			int y = t.nextInt();

			if (x == 1 && y == 1)
				both.add(val);
			else if (x == 1)
				alice.add(val);
			else if (y == 1)
				bob.add(val);
		}

		Collections.sort(both);
		Collections.sort(alice);
		Collections.sort(bob);

		if (Math.min(alice.size(), bob.size()) + both.size() >= k) {
			int a = 0, b = 0, c = 0;
			int cur = 0;
			long time = 0;

			while (cur < k && a < both.size() && b < alice.size() && c < bob.size()) {
				if (bob.get(c) + alice.get(b) <= both.get(a)) {
					time = time + bob.get(c) + alice.get(b);
					cur++;
					c++;
					b++;
				} else {
					time = time + both.get(a);
					a++;
					cur++;
				}
			}

			while (cur < k && a < both.size()) {
				time = time + both.get(a);
				a++;
				cur++;
			}

			while (cur < k && b < alice.size() && c < bob.size()) {
				time = time + bob.get(c) + alice.get(b);
				cur++;
				c++;
				b++;
			}

			o.println(time);

		} else
			o.println("-1");

		o.flush();
		o.close();
	}
}
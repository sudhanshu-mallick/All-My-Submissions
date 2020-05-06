import java.util.Queue;
import java.util.*;
import java.io.*;

public class Table_Tennis {

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
		long k = t.nextLong();
		Queue<Integer> q = new LinkedList<>();
		int ans = 0, max = 0;

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt();
			max = Math.max(max, x);

			q.add(x);
		}

		if (k >= n - 1)
			ans = max;
		else {
			int cur = 0;
			int v1 = q.remove();
			int v2 = q.remove();

			while (q.size() >= 0) {
				if (v1 > v2) {
					cur++;
					q.add(v2);
					v2 = q.remove();
				} else {
					if (cur > max) {
						ans = v1;
						max = cur;
					}

					cur = 1;
					q.add(v1);
					v1 = v2;
					v2 = q.remove();
				}

				if (cur >= k) {
					ans = v1;
					break;
				}
			}
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}

import java.util.*;
import java.io.*;

public class Producing_Snow {

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
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long[] a = new long[n];
		StringBuilder sb = new StringBuilder();
		long delta = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		for (int i = 0; i < n; ++i) {
			long snow = t.nextLong();
			long ans = 0;

			pq.add(a[i] + delta);

			while (pq.size() > 0 && pq.peek() <= snow + delta) {
				ans += (pq.remove() - delta);
			}

			delta += snow;

			ans += pq.size() * snow;

			sb.append(ans + " ");
		}

		o.println(sb);
		o.flush();
		o.close();
	}
}

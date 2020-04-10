import java.util.*;
import java.io.*;

public class Eugene_And_An_Array {

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
		int n = t.nextInt(), begin = 0, end = 0;
		long[] a = new long[n + 1];
		long ans = 0;
		HashSet<Long> map = new HashSet<>();

		map.add(0l);

		for (int i = 1; i <= n; ++i)
			a[i] = a[i - 1] + t.nextInt();

		while (begin < n) {
			while (end < n && !map.contains(a[end + 1])) {
				++end;

				map.add(a[end]);
			}

			ans += end - begin;

			map.remove(a[begin]);

			++begin;
		}

		o.print(ans);
		o.flush();
		o.close();
	}
}

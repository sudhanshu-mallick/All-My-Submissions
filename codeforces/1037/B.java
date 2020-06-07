import java.util.*;
import java.io.*;

public class Reach_Medain {

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
		long med = t.nextLong();
		long[] a = new long[n];
		long ans = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		Arrays.sort(a);

		int mid = n / 2;

		if (a[mid] == med)
			ans = 0;
		else if (a[mid] > med) {
			int idx = mid;

			while (idx >= 0) {
				if (a[idx] > med)
					ans += a[idx] - med;
				else
					break;

				idx--;
			}
		} else {
			int idx = mid;

			while (idx < n) {
				if (a[idx] < med)
					ans += med - a[idx];
				else
					break;

				idx++;
			}
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}

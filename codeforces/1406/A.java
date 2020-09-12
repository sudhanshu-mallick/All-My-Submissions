import java.util.*;
import java.io.*;

public class Subst_Mex {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			Arrays.sort(a);

			int max = 0;
			List<Integer> one = new ArrayList<>();
			List<Integer> two = new ArrayList<>();
			int cur = a[0];
			boolean vis[] = new boolean[102];

			one.add(cur);

			for (int i = 1; i < n; ++i) {
				if (cur == a[i]) {
					two.add(cur);
				} else {
					cur = a[i];

					one.add(cur);
				}
			}

			for (int el : one) {
				vis[el] = true;
			}

			for (int i = 0; i <= 101; ++i) {
				if (!vis[i]) {
					max = i;
					break;
				}
			}

			vis = new boolean[102];

			for (int el : two) {
				vis[el] = true;
			}

			for (int i = 0; i <= 101; ++i) {
				if (!vis[i]) {
					max += i;
					break;
				}
			}

			o.println(max);
		}

		o.flush();
		o.close();
	}
}
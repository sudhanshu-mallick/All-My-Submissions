
import java.util.*;
import java.io.*;

public class Replace_By_MEX {

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
		StringBuilder sb = new StringBuilder();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];
			List<Integer> ans = new ArrayList<>();

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			while (!isSorted(a)) {
				int mex = MEX(a);

				if (mex < n) {
					a[mex] = mex;

					ans.add(mex + 1);
				} else {
					for (int i = 0; i < n; ++i) {
						if (a[i] != i) {
							a[i] = mex;

							ans.add(i + 1);
							break;
						}
					}
				}
			}

			sb.append(ans.size() + "\n");

			for (int i = 0; i < ans.size(); ++i)
				sb.append(ans.get(i) + " ");

			sb.append("\n");
		}

		o.println(sb);
		o.flush();
		o.close();
	}

	private static int MEX(int[] a) {
		boolean found[] = new boolean[a.length + 1];

		for (int i = 0; i < a.length; ++i) {
			found[a[i]] = true;
		}

		for (int i = 0; i <= a.length; ++i)
			if (!found[i])
				return i;

		return -1;

	}

	private static boolean isSorted(int[] a) {

		for (int i = 0; i < a.length - 1; ++i)
			if (a[i + 1] < a[i])
				return false;

		return true;
	}
}

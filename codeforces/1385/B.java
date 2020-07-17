import java.util.*;
import java.io.*;

public class Restore_The_Permutation_By_Merger {

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
			Set<Integer> set = new HashSet<>();
			List<Integer> ans = new ArrayList<>();
			n = n << 1;

			while (n-- > 0) {
				int x = t.nextInt();

				if (set.contains(x))
					continue;
				else {
					set.add(x);
					ans.add(x);
				}
			}

			for (int i : ans)
				o.print(i + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}
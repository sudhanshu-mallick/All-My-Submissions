import java.util.*;
import java.io.*;

public class Dreamoon_Likes_Permutations {

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
			HashSet<Integer> set1 = new HashSet<>();
			HashSet<Integer> set2 = new HashSet<>();
			int[] p1 = new int[n];
			int[] p2 = new int[n];
			int max1 = 0, max2 = 0;
			ArrayList<Integer> ans = new ArrayList<>();

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 0, j = n - 1; i < n; ++i, --j) {
				max1 = Math.max(a[i], max1);
				max2 = Math.max(a[j], max2);

				set1.add(a[i]);
				set2.add(a[j]);

				if (set1.size() == max1 && max1 == i + 1)
					p1[i] = 1;

				if (set2.size() == max2 && max2 == i + 1)
					p2[j] = 1;
			}

			for (int i = 0; i < n - 1; ++i) {
				if (p1[i] == 1 && p2[i + 1] == 1)
					ans.add(i + 1);
			}

			o.println(ans.size());

			for (int i : ans)
				o.println(i + " " + (n - i));

		}

		o.flush();
		o.close();
	}
}
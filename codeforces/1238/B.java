import java.util.*;
import java.io.*;

public class Kill_Em_All {

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
			int r = t.nextInt();
			List<Integer> a = new ArrayList<>();
			int count = 0;
			Set<Integer> set = new HashSet<>();

			for (int i = 0; i < n; ++i) {
				int el = t.nextInt();

				if (set.contains(el))
					continue;

				a.add(el);
				set.add(el);
			}

			Collections.sort(a);

			int i = a.size() - 1;
			int cur = a.get(a.size() - 1);

			while (i >= 0) {
				cur = a.get(i);

				if (cur - r * count <= 0) {
					break;
				} else {
					count++;
				}

				i--;
			}

			o.println(count);

		}

		o.flush();
		o.close();
	}
}
import java.util.*;
import java.io.*;

public class UniqueNess {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		int[] a = new int[n];
		int min = n;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		int i = -1;

		while (i <= n) {
			Set<Integer> set = new HashSet<>();
			int j = 0;
			boolean flag = true;

			while (j < i) {
				if (set.contains(a[j])) {
					flag = false;
					break;
				}

				set.add(a[j]);
				++j;
			}

			if (flag) {
				j = n - 1;

				while (j >= 0) {
					if (set.contains(a[j]))
						break;

					set.add(a[j]);

					--j;
				}
			}

			if (flag)
				min = Math.min(min, n - set.size());
			++i;
		}

		o.println(min);
		o.flush();
		o.close();
	}
}

import java.util.*;
import java.io.*;

public class Different_Divisos {

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
		list = new ArrayList<>();
		soe();

		int test = t.nextInt();

		while (test-- > 0) {
			int d = t.nextInt();
			long v1 = 1 + d;
			long ans = 1;
			int i = 0;

			while (i < list.size()) {
				if (list.get(i) < v1)
					++i;
				else
					break;
			}

			ans = list.get(i);
			v1 = ans + d;

			while (i < list.size()) {
				if (list.get(i) < v1)
					++i;
				else
					break;
			}

			ans = ans * list.get(i);

			o.println(ans);
		}

		o.flush();
		o.close();
	}

	private static List<Long> list;

	private static void soe() {
		int N = 100000;
		boolean[] prime = new boolean[N + 1];

		for (int i = 2; i * i <= N; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= N; j += i)
					prime[j] = true;
			}
		}

		for (int i = 2; i <= N; ++i) {
			if (!prime[i])
				list.add(i + 0l);
		}
	}
}
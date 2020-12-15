import java.util.*;
import java.io.*;

public class Close_Tuples {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			List<Integer> a = new ArrayList<>();

			for (int i = 0; i < n; ++i)
				a.add(t.nextInt());

			Collections.sort(a);

			Map<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < n; ++i) {
				map.put(a.get(i), i);
			}

			long ans = 0;

			for (int i = 0; i < n; ++i) {
				int idx = -1;

				if (map.containsKey(a.get(i) + 2))
					idx = map.get(a.get(i) + 2);
				else if (map.containsKey(a.get(i) + 1))
					idx = map.get(a.get(i) + 1);
				else
					idx = map.get(a.get(i));

				long ele = idx - i - 1;

				if (ele >= 1)
					ans += ele * (ele + 1) / 2;
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}
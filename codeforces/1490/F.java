import java.util.*;
import java.io.*;

public class Equalize_The_Array {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			int max = 0;

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();

				map.put(x, map.getOrDefault(x, 0) + 1);

				max = Math.max(max, map.get(x));
			}

			long[] a = new long[max + 1];

			for (Map.Entry<Integer, Integer> m : map.entrySet()) {
				++a[m.getValue()];
			}

			long min = n;
			long left = 0, right = n, cnt = map.size();

			for (int i = 1; i <= max; ++i) {
				min = Math.min(min, left + right - cnt * i);
				left += i * a[i];
				right -= i * a[i];
				cnt -= a[i];
			}

			o.println(min);
		}

		o.flush();
		o.close();
	}
}
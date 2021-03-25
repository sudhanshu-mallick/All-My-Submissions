import java.util.*;
import java.io.*;

public class Gargari_And_Bishops {

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
		long[][] a = new long[n][n];
		long[] even = new long[3], odd = new long[3];
		Map<Integer, Long> diff = new HashMap<>();
		Map<Integer, Long> sum = new HashMap<>();

		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j) {
				a[i][j] = t.nextLong();

				diff.put(i - j, diff.getOrDefault(i - j, 0l) + a[i][j]);
				sum.put(i + j, sum.getOrDefault(i + j, 0l) + a[i][j]);
			}

		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j) {
				int id1 = i - j;
				int id2 = i + j;
				long val = diff.get(id1) + sum.get(id2) - a[i][j];

				if ((id2 & 1) == 0) {
					if (val >= even[0]) {
						even[0] = val;
						even[1] = i + 1;
						even[2] = j + 1;
					}
				} else {
					if (val >= odd[0]) {
						odd[0] = val;
						odd[1] = i + 1;
						odd[2] = j + 1;
					}
				}
			}

		o.println(odd[0] + even[0]);
		o.println(odd[1] + " " + odd[2] + " " + even[1] + " " + even[2]);
		o.flush();
		o.close();
	}
}
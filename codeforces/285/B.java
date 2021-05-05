import java.util.*;
import java.io.*;

public class Find_Marbes {

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
		int s = t.nextInt() - 1;
		int e = t.nextInt() - 1;
		int[] a = new int[n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt() - 1;

		if (s == e)
			o.println("0");
		else {
			int steps = 0;
			Set<Integer> set = new HashSet<>();
			int cur = s;

			while (cur != e) {
				set.add(cur);

				cur = a[cur];
				++steps;

				if (set.contains(cur)) {
					steps = -1;
					break;
				}
			}

			o.println(steps);
		}

		o.flush();
		o.close();
	}
}
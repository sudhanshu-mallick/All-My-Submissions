import java.util.*;
import java.io.*;

public class PIN_Codes {

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
			Map<String, Integer> map = new HashMap<>();
			String[] a = new String[n];

			for (int i = 0; i < n; ++i) {
				a[i] = t.next();

				map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			}

			int changes = 0;

			for (int i = 0; i < n; ++i) {
				if (map.get(a[i]) == 1)
					continue;

				int val = a[i].charAt(3) - '0';
				++changes;

				while (map.containsKey(new String(a[i].substring(0, 3) + "" + val))) {
					val = (val + 1) % 10;
				}

				map.put(a[i], map.get(a[i]) - 1);
				map.put(a[i].substring(0, 3) + "" + val, 1);

				a[i] = a[i].substring(0, 3) + "" + val;
			}

			o.println(changes);

			for (String s : a)
				o.println(s);
		}

		o.flush();
		o.close();
	}
}
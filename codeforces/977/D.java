import java.util.*;
import java.io.*;

public class Divide_By_Three_Multiply_By_Two {

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
		int n = t.nextInt();
		HashMap<Long, Integer> map = new HashMap<>();
		long[] a = new long[n];

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextLong();
			int v = map.getOrDefault(a[i], 0) + 1;

			map.put(a[i], v);
		}

		long start = a[0];

		for (long el : a) {
			if ((el & 1) == 0) {
				if (map.containsKey(el / 2) || map.containsKey(3 * el))
					continue;

				start = el;
				break;
			} else {
				if (map.containsKey(3 * el))
					continue;

				start = el;
				break;
			}
		}

		o.print(start + " ");

		int v = map.get(start);

		if (v == 1)
			map.remove(start);
		else
			map.put(start, v - 1);

		while (--n > 0) {
			if (start % 3 == 0 && map.containsKey(start / 3)) {
				o.print(start / 3 + " ");
				v = map.get(start / 3);

				if (v == 1)
					map.remove(start / 3);
				else
					map.put(start / 3, v - 1);

				start = start / 3;
			} else {
				o.print(start * 2 + " ");

				v = map.get(start * 2);

				if (v == 1)
					map.remove(start * 2);
				else
					map.put(start * 2, v - 1);

				start = start * 2;
			}
		}

		o.flush();
		o.close();
	}
}
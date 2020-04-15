import java.io.*;
import java.util.*;

public class Journey_Planning {

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
		int[] a = new int[n];
		HashMap<Integer, Long> map = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();
			int val = a[i] - i;

			if (map.containsKey(val)) {
				map.put(val, map.get(val) + a[i]);
			} else {
				map.put(val, (long) a[i]);
			}
		}

		long max = 0;

		for (Map.Entry<Integer, Long> entry : map.entrySet()) {
			max = Math.max(entry.getValue(), max);
		}

		o.println(max);

		o.flush();
		o.close();
	}
}
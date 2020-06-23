import java.util.*;
import java.io.*;

public class XOR_and_OR {

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
		long[] a = new long[n];
		int m = t.nextInt();
		int k = t.nextInt();
		Long[] b = new Long[n];
		HashMap<Long, Integer> map = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			b[i] = a[i] = t.nextLong();
		}

		Arrays.sort(b);

		long sum = 0;
		int j = 0, i = n - 1;

		while (j < m * k) {
			sum += b[i].longValue();
			++j;
			long val = b[i].longValue();
			--i;

			if (map.containsKey(val))
				map.put(val, map.get(val) + 1);
			else
				map.put(val, 1);
		}

		o.println(sum);
		int cur = 0;
		int cnt = 0;

		for (i = 0; i < n; ++i) {
			long val = a[i];

			if (map.containsKey(val)) {
				cur++;

				if (map.get(val) == 1)
					map.remove(val);
				else
					map.put(val, map.get(val) - 1);
			}

			if (cur == m) {
				cur = 0;
				cnt++;
				o.print(i + 1 + " ");
			}

			if (cnt == k - 1)
				break;
		}

		o.flush();
		o.close();
	}
}
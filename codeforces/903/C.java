import java.util.*;
import java.io.*;

public class Box_Packing {

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
		int n = t.nextInt(), max = 1;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt();

			if (map.containsKey(x))
				map.put(x, map.get(x) + 1);
			else
				map.put(x, 1);
		}

		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			max = Math.max(max, m.getValue());
		}

		o.println(max);

		o.flush();
		o.close();
	}
}

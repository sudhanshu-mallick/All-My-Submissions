import java.util.*;
import java.io.*;

public class Build_A_Contest {

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
		int m = t.nextInt();
		int n = t.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt();

			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}

			if (map.size() == m) {
				sb.append("1");

				List<Integer> l = new ArrayList<>();
				List<Integer> L = new ArrayList<>();

				for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
					if (mp.getValue() == 1)
						l.add(mp.getKey());
					else
						L.add(mp.getKey());
				}

				for (int j = 0; j < l.size(); ++j)
					map.remove(l.get(j));
				for (int j = 0; j < L.size(); ++j)
					map.put(L.get(j), map.get(L.get(j)) - 1);

			} else {
				sb.append("0");
			}
		}

		o.println(sb);

		o.flush();
		o.close();
	}
}
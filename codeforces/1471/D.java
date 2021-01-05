import java.util.*;
import java.io.*;

public class Strange_Definition {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			Map<Integer, Integer> map = new HashMap<>();

			while (n-- > 0) {
				int v = t.nextInt();
				int ele = 1;
				int pow = 0;

				while ((v & 1) == 0) {
					pow = pow ^ 1;
					v = v >> 1;
				}

				if (pow == 1)
					ele = 2;

				for (int i = 3; i * i <= v; i += 2) {
					pow = 0;

					while (v % i == 0) {
						pow = pow ^ 1;
						v /= i;
					}

					if (pow == 1)
						ele = ele * i;
				}

				if (v > 1)
					ele = ele * v;

				map.put(ele, map.getOrDefault(ele, 0) + 1);
			}

			int forZero = 0, forGZero = 0;

			for (Map.Entry<Integer, Integer> m : map.entrySet()) {
				int val = m.getValue();
				forZero = val > forZero ? val : forZero;

				if ((val & 1) == 0 || m.getKey() == 1)
					forGZero += val;
			}

			forGZero = forGZero > forZero ? forGZero : forZero;
			int q = t.nextInt();

			while (q-- > 0) {
				if (t.nextLong() == 0l)
					o.println(forZero);
				else
					o.println(forGZero);
			}
		}

		o.flush();
		o.close();
	}
}
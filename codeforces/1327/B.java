import java.io.*;
import java.util.*;

public class Princess_And_Princesses {
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
			int[][] a = new int[n][];
			HashSet<Integer> map = new HashSet<>();
			ArrayList<Integer> idx = new ArrayList<>();

			for (int j = 0; j < n; j++) {
				int s = t.nextInt();
				a[j] = new int[s + 1];
				a[j][s] = s;

				for (int i = 0; i < s; i++) {
					int el = t.nextInt();
					a[j][i] = el;
				}
			}

			for (int i = 0; i < n; i++) {
				int flag = 0;

				for (int j = 0; j < a[i].length - 1; j++) {
					int el = a[i][j];

					if (map.contains(el)) {

					} else {
						map.add(el);
						flag = 1;
						break;
					}
				}

				if (flag == 0) {
					idx.add(i);
				}
			}

			int ind = 0, elem = 0, flag = 0;

			for (int i = 0; i < idx.size(); i++) {
				int id = idx.get(i);

				if (a[id].length - 1 < n) {
					HashSet<Integer> p = new HashSet<>();

					for (int j = 0; j < a[id].length - 1; j++) {
						p.add(a[id][j]);
					}

					for (int j = 0; j < n; j++) {
						if (!p.contains(j + 1) && !map.contains(j + 1)) {
							ind = id + 1;
							elem = j + 1;
							flag = 1;
							break;
						}
					}
				}

				if (flag == 1)
					break;
			}

			if (map.size() == n)
				o.println("OPTIMAL");
			else {
				if (flag == 1) {
					o.println("IMPROVE");
					o.println(ind + " " + elem);
				} else
					o.println("OPTIMAL");
			}

		}
		o.flush();
		o.close();
	}
}
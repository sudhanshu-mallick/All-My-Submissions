import java.util.*;
import java.io.*;

public class Silly_Mistake {

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
		int n = t.nextInt();
		int[] a = new int[n];
		List<Integer> list = new ArrayList<>();
		Set<Integer> vis = new HashSet<>();
		Set<Integer> ele = new HashSet<>();

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		int i = 0;
		int cnt = 0;
		boolean flag = true;

		while (i < n) {
			int v = a[i];

			if (v > 0) {
				if (!ele.contains(v)) {
					vis.add(v);
					ele.add(v);

					++cnt;
				} else {
					flag = false;
					break;
				}
			} else {
				if (vis.contains(-v)) {
					vis.remove(-v);

					++cnt;

					if (vis.size() == 0) {
						list.add(cnt);

						ele = new HashSet<>();
						cnt = 0;
					}
				} else {
					flag = false;
					break;
				}
			}

			++i;
		}

		if (vis.size() > 0 || cnt > 0)
			flag = false;

		if (flag) {
			o.println(list.size());

			for (int v : list)
				o.print(v + " ");
		} else
			o.println("-1");

		o.flush();
		o.close();
	}
}

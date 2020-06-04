import java.util.*;
import java.io.*;

public class Polo_And_The_Penguin_Matrix {

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
		int n = t.nextInt() * t.nextInt();
		int d = t.nextInt();
		Integer[] a = new Integer[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();

			set.add(a[i] % d);

			if (map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + 1);
			else
				map.put(a[i], 1);
		}

		if (set.size() == 1) {
			Arrays.sort(a);
			int min = Integer.MAX_VALUE;
			int left = 0, right = n - map.get(a[0]), cl = 0, cr = 0, steps = 0, dif = 0, prev = a[0];

			for (int i = 1; i < n; ++i) {
				cr += (a[i] - a[0]) / d;
			}

//			System.out.println(cr);

			steps = cr;
			min = Math.min(min, steps);
			int val = map.get(a[0]);
			int i = val;
			for (; i < n;) {
				left += val;
				dif = (a[i] - prev) / d;
				prev = a[i];
				cl = cl + left * dif;
				cr = cr - right * dif;
				steps = cl + cr;
				min = Math.min(steps, min);
				val = map.get(a[i]);
				i += val;
				right -= val;
			}

			o.println(min);
		} else {
			o.println("-1");
		}

		o.flush();
		o.close();
	}
}
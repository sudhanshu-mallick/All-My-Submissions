import java.util.*;
import java.io.*;

public class Asterism {

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
		int p = t.nextInt();
		Integer[] a = new Integer[n];
		TreeSet<Integer> tree = new TreeSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		Arrays.sort(a);

		for (int i = 0; i < n; ++i) {
			tree.add(a[i]);

			if (!map.containsKey(a[i]))
				map.put(a[i], i);
		}

		for (int x = 1; x <= 2000; ++x) {
			boolean flag = true;

			for (int i = 0; i < n; ++i) {
				Integer val = tree.higher(x + i);
				int v = (val == null) ? n : map.get(val).intValue();
				int fx = v - i;

				if (fx % p == 0) {
					flag = false;
					break;
				}
			}

			if (flag)
				list.add(x);
		}

		o.println(list.size());

		for (int i = 0; i < list.size(); ++i)
			o.print(list.get(i) + " ");

		o.flush();
		o.close();
	}
}
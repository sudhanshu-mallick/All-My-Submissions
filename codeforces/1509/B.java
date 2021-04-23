import java.util.*;
import java.io.*;

public class TMT_Document {

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

		Arrays.sort(a);
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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			char[] ch = t.next().toCharArray();
			boolean flag = true;
			List<Integer> T = new ArrayList<>();
			List<Integer> M = new ArrayList<>();

			for (int i = 0; i < n; ++i)
				if (ch[i] == 'M')
					M.add(i);
				else
					T.add(i);

			if ((M.size() << 1) != T.size())
				flag = false;

			if (flag)
				for (int i = 0; i < M.size(); ++i)
					if (M.get(i) < T.get(i) || M.get(i) > T.get(i + M.size())) {
						flag = false;

						break;
					}

			o.println(flag ? "YES" : "NO");
		}

		o.flush();
		o.close();
	}
}
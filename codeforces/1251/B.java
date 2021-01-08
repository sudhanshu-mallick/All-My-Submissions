import java.util.*;
import java.io.*;

public class Binary_Palindromes {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			List<Integer> list = new ArrayList<>();
			int ones = 0, zeros = 0;

			for (int i = 0; i < n; ++i) {
				String s = t.next();

				if ((s.length() & 1) == 0)
					list.add(s.length());

				for (char c : s.toCharArray()) {
					if (c == '1')
						++ones;
					else
						++zeros;
				}
			}

			int ans = n - list.size();

			Collections.sort(list);

			if (list.size() > 0) {
				for (int v : list) {
					if (ones >= v) {
						++ans;
						ones -= v;
					} else if (zeros >= v) {
						++ans;
						zeros -= v;
					} else {
						if (((ones & 1) == 0 && ones + zeros >= v) || ((ones & 1) == 1 && zeros + ones > v)) {
							++ans;
						}

						break;
					}
				}
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}

import java.util.*;
import java.io.*;

public class Swap_Adjacent_Elements {

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
		int[] a = new int[n];
		boolean flag = true;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt() - 1;

		String s = t.next() + "0";
		List<Integer> low = new ArrayList<>();
		List<Integer> high = new ArrayList<>();

		for (int i = 0; i < s.length(); ++i) {
			if (i == 0) {
				if (s.charAt(i) == '1')
					low.add(i);
			} else if (s.charAt(i) == '1' && s.charAt(i - 1) == '0')
				low.add(i);
		}

		for (int i = 1; i < s.length(); ++i) {
			if (s.charAt(i) == '0' && s.charAt(i - 1) == '1')
				high.add(i);
		}

		for (int i = 0; i < low.size(); ++i) {
			int l = low.get(i);
			int h = high.get(i);

			for (int k = l; k <= h; ++k) {
				if (a[k] < l || a[k] > h) {
					flag = false;
					break;
				}
			}

			if (!flag)
				break;

			for (int k = l; k <= h; ++k) {
				a[k] = k;
			}
		}

		if (flag) {
			for (int i = 0; i < n; ++i) {
				if (a[i] != i) {
					flag = false;
					break;
				}
			}
		}

		if (flag)
			o.println("YES");
		else
			o.println("NO");

		o.flush();
		o.close();
	}
}
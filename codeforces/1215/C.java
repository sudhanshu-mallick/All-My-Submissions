import java.util.*;
import java.io.*;

public class Swap_Letters {

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
		Stack<Integer> a = new Stack<>();
		Stack<Integer> b = new Stack<>();
		boolean flag = true;
		List<int[]> ans = new ArrayList<>();
		String x = t.next();
		String y = t.next();
		int A = 0, B = 0;

		for (int i = 0; i < n; ++i) {
			if (x.charAt(i) == 'a')
				A++;
			else
				B++;

			if (y.charAt(i) == 'a')
				A++;
			else
				B++;

			if (x.charAt(i) != y.charAt(i)) {
				if (x.charAt(i) == 'a')
					a.add(i + 1);
				else
					b.add(i + 1);
			}
		}

		if ((A & 1) == 1 || (B & 1) == 1) {
			flag = false;
		} else {
			while (a.size() > 1) {
				int i1 = a.pop();
				int i2 = a.pop();

				ans.add(new int[] { i1, i2 });
			}

			while (b.size() > 1) {
				int i1 = b.pop();
				int i2 = b.pop();

				ans.add(new int[] { i1, i2 });
			}

			if (a.size() > 0) {
				int i1 = a.pop();
				int i2 = b.pop();

				ans.add(new int[] { i1, i1 });
				ans.add(new int[] { i1, i2 });
			}
		}

		if (flag) {
			o.println(ans.size());

			for (int[] ar : ans) {
				o.println(ar[0] + " " + ar[1]);
			}
		} else
			o.println("-1");

		o.flush();
		o.close();
	}
}
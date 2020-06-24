import java.util.*;
import java.io.*;

public class Love_Triangle {

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
		int[] a = new int[n + 1];
		boolean flag = false;

		for (int i = 1; i <= n; ++i)
			a[i] = t.nextInt();

		for (int i = 1; i <= n; ++i) {
			if (a[a[a[i]]] == i && a[i] != i && a[i] != a[a[i]]) {
				flag = true;
				break;
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

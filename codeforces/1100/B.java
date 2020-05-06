
import java.util.*;
import java.io.*;

public class Build_A_Contest {

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
		int m = t.nextInt();
		int n = t.nextInt();
		StringBuilder sb = new StringBuilder();
		int c[] = new int[m + 1];
		int fre[] = new int[100002];

		for (int i = 0; i < n; i++) {
			int x = t.nextInt();
			c[x]++;
			fre[c[x]]++;

			if (fre[c[x]] == m)
				sb.append("1");
			else
				sb.append("0");
		}

		o.println(sb);

		o.flush();
		o.close();
	}
}
import java.io.*;
import java.util.*;

public class Polycarps_New_Job {

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
		int x = 0, y = 0;

		while (test-- > 0) {
			String s[] = t.nextLine().split(" ");
			int a = Integer.parseInt(s[1]);
			int b = Integer.parseInt(s[2]);

			if (s[0].equals("+")) {
				x = Math.max(x, Math.min(a, b));
				y = Math.max(y, Math.max(a, b));
			} else {
				if (x <= Math.min(a, b) && y <= Math.max(a, b))
					o.println("YES");
				else
					o.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}
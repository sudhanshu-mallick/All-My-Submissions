import java.util.*;
import java.io.*;

public class Three_Pairwise_Maximums {

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

		while (test-- > 0) {
			int[] a = new int[3];
			a[0] = t.nextInt();
			a[1] = t.nextInt();
			a[2] = t.nextInt();
			
			Arrays.sort(a);

			if (a[1] == a[2]) {
				o.println("YES");
				o.println(a[0] + " " + a[1] + " " + a[0]);
			} else {
				o.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}
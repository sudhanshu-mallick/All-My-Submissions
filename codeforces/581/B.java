import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Luxurious_Houses {

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
		int[] h = new int[n];
		int[] m = new int[n];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++)
			h[i] = t.nextInt();

		max = h[n - 1] - 1;

		for (int i = n - 1; i >= 0; i--) {
			m[i] = max - h[i] + 1;
			max = Math.max(max, h[i]);
		}

		for (int i = 0; i < n; i++)
			if (m[i] > 0)
				o.print(m[i] + " ");
			else
				o.print(0 + " ");

		o.flush();
		o.close();
	}

}
import java.util.*;
import java.io.*;

public class Little_Elephant_And_Problem {

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
		int[] b = new int[n];
		int count = 0;

		for (int i = 0; i < n; ++i)
			a[i] = b[i] = t.nextInt();

		Arrays.sort(b);

		for (int i = 0; i < n; ++i)
			if (a[i] != b[i])
				count++;

		if (count <= 2)
			o.println("YES");
		else
			o.println("NO");

		o.flush();
		o.close();
	}
}
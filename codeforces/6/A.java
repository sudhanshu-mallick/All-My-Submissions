import java.io.*;
import java.util.*;

public class Triangle {
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
		Integer[] a = new Integer[4];
		boolean tri = false, seg = false;
		for (int i = 0; i < 4; i++)
			a[i] = t.nextInt();

		Arrays.sort(a);

		for (int i = 0; i < 2; i++) {
			if (a[i] + a[i + 1] > a[i + 2]) {
				tri = true;
				break;
			} else if (a[i] + a[i + 1] == a[i + 2])
				seg = true;
		}

		if (tri)
			o.println("TRIANGLE");
		else if (seg)
			o.println("SEGMENT");
		else
			o.println("IMPOSSIBLE");

		o.flush();
		o.close();
	}
}
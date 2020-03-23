import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Before_An_Exam {

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
		int d = t.nextInt();
		int h = t.nextInt();
		int[] minh = new int[d];
		int[] maxh = new int[d];
		int min = 0, max = 0;

		for (int i = 0; i < d; i++) {
			minh[i] = t.nextInt();
			maxh[i] = t.nextInt();
			min += minh[i];
			max += maxh[i];
		}

		if (h <= max && min <= h) {
			o.println("YES");

			for (int i = 0; i < d; i++) {
				int hour = Math.min(minh[i] + h - min, maxh[i]);
				h -= (hour - minh[i]);

				o.print(hour + " ");
			}
		} else {
			o.println("NO");
		}

		o.flush();
		o.close();
	}

}
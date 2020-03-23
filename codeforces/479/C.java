import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Exams {

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
		Pair[] arr = new Pair[n];
		int min = 0;

		for (int i = 0; i < n; i++) {
			int a = t.nextInt();
			int b = t.nextInt();
			arr[i] = new Pair(a, b);
		}

		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			if (min <= arr[i].b)
				min = arr[i].b;
			else
				min = arr[i].a;
		}

		o.println(min);
		o.flush();
		o.close();

	}

	private static class Pair implements Comparable<Pair> {
		int a;
		int b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair p) {
			return (this.a != p.a) ? (this.a - p.a) : (this.b - p.b);
		}
	}

}
import java.util.*;
import java.io.*;

public class Three_Bags {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n1 = t.nextInt();
		int n2 = t.nextInt();
		int n3 = t.nextInt();
		long sum = 0;
		long mina = Integer.MAX_VALUE, minb = Integer.MAX_VALUE, minc = Integer.MAX_VALUE;
		long min = Long.MAX_VALUE;
		long sumC = 0;

		while (n1-- > 0) {
			long x = t.nextLong();
			sum += x;
			sumC += x;
			mina = Math.min(mina, x);
		}

		min = Math.min(min, sumC);
		sumC = 0;

		while (n2-- > 0) {
			long x = t.nextLong();
			sum += x;
			sumC += x;
			minb = Math.min(minb, x);
		}

		min = Math.min(min, sumC);
		sumC = 0;

		while (n3-- > 0) {
			long x = t.nextLong();
			sum += x;
			sumC += x;
			minc = Math.min(minc, x);
		}

		min = Math.min(min, sumC);
		min = Math.min(Math.min(min, mina + minb), Math.min(minb + minc, minc + mina));

		o.println(sum - (min << 1));

		o.flush();
		o.close();
	}
}
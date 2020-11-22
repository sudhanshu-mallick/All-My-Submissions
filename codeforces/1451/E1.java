import java.util.*;
import java.io.*;

public class Bitwise_Queries {

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

	static FastReader t = new FastReader();

	public static long xor(int i, int j) {
		System.out.println("XOR " + i + " " + j);
		return t.nextLong();
	}

	public static long and(int i, int j) {
		System.out.println("AND " + i + " " + j);
		return t.nextLong();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		long[] a = new long[n];
		long a1xora2 = xor(1, 2);
		long a2xora3 = xor(2, 3);
		long a1anda2 = and(1, 2);
		long a2anda3 = and(2, 3);
		long a1anda3 = and(1, 3);
		long a1xora3 = a1xora2 ^ a2xora3;
		long x = a1xora2 + ((a1anda2) << 1);
		long y = a2xora3 + ((a2anda3) << 1);
		long z = a1xora3 + ((a1anda3) << 1);
		a[0] = (x + z - y) >> 1;
		a[1] = a[0] ^ a1xora2;
		a[2] = a[0] ^ a1xora3;

		for (int i = 3; i < n; ++i) {
			long val = xor(1, i + 1);
			a[i] = val ^ a[0];
		}

		System.out.print("! ");

		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
		o.flush();
		o.close();
	}
}
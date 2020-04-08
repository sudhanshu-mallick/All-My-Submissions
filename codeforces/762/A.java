import java.util.*;
import java.io.*;

public class kth_Divisor {

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
		long n = t.nextLong(), k = t.nextLong();

		kthDivisor(n, k);
	}

	static void kthDivisor(long n, long k) {
		ArrayList<Long> list = new ArrayList<>();
		PrintWriter o = new PrintWriter(System.out);

		for (long i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i)
					list.add(i);
				else {
					list.add(i);
					list.add(n / i);
				}
			}
		}

		Collections.sort(list);

		if (k <= list.size())
			o.println(list.get((int) k - 1));
		else
			o.println(-1);

		o.flush();
		o.close();

	}
}
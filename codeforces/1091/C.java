import java.util.*;
import java.io.*;

public class New_Year_And_Sphere_Transmission {

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
		long n = t.nextLong();
		ArrayList<Long> l1 = new ArrayList<>(), l2 = new ArrayList<>();

		for (long i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i)
					l1.add(i);
				else {
					l1.add(i);
					l2.add(n / i);
				}
			}
		}

		Collections.reverse(l1);

		for (int i = 0; i < l2.size(); ++i) {
			long val = l2.get(i);
			long num = n / val;
			long ans = val * num * (num - 1) / 2 + num;

			o.print(ans + " ");
		}

		for (int i = 0; i < l1.size(); ++i) {
			long val = l1.get(i);
			long num = n / val;
			long ans = val * num * (num - 1) / 2 + num;

			o.print(ans + " ");
		}

		o.flush();
		o.close();
	}
}
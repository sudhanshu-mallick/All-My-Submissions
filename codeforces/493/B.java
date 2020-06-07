import java.util.*;
import java.io.*;

public class Vasya_And_Wrestling {

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
		long sum1 = 0, sum2 = 0;
		ArrayList<Long> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		byte first = 0;

		while (n-- > 0) {
			long x = t.nextLong();

			if (x > 0) {
				first = 0;
				sum1 += x;

				l1.add(x);
			} else {
				first = 1;
				x = Math.abs(x);
				sum2 += x;

				l2.add(x);
			}
		}

		if (sum1 > sum2)
			o.println("first");
		else if (sum2 > sum1)
			o.println("second");
		else {

			int i = 0, x = l1.size(), y = l2.size(), val = 0;

			while (i < x && i < y) {
				if (l1.get(i) > l2.get(i)) {
					val = 1;
					break;
				} else if (l2.get(i) > l1.get(i)) {
					val = 2;
					break;
				}

				i++;
			}

			if (val == 0) {
				if (first == 0)
					o.println("first");
				else
					o.println("second");

			} else if (val == 1)
				o.println("first");
			else
				o.println("second");
		}

		o.flush();
		o.close();
	}
}

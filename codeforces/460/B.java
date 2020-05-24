import java.util.*;
import java.io.*;

public class Little_Dima_And_Equations {

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
		long a = t.nextLong();
		long b = t.nextLong();
		long c = t.nextLong();
		ArrayList<Long> list = new ArrayList<>();

		for (long i = 1; i <= 81; ++i) {
			long x = b * (long) Math.pow(i, a) + c;

			if (x <= 0 || x >= (long) 1e9)
				continue;

			long digits = 0, num = x;

			while (x != 0) {
				digits += x % 10;
				x /= 10;
			}

			if (digits == i)
				list.add(num);
		}

		o.println(list.size());

		for (int i = 0; i < list.size(); ++i)
			o.print(list.get(i) + " ");

		o.flush();
		o.close();
	}
}
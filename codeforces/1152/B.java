import java.util.*;
import java.io.*;

public class Neko_Performs_Cat_Furrier_Transform {

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
		List<Integer> ans = new ArrayList<>();
		int steps = 0;

		while (n > 0) {
			int temp = n;
			int cnt = 0;
			int bits = 0;

			while (temp > 0) {
				if ((temp & 1) == 1)
					++cnt;

				++bits;
				temp = temp >> 1;
			}

			ans.add(bits);

			if (cnt == 1) {
				++steps;
				break;
			}

			n = n ^ ((1 << bits) - 1);

			if (n == 0) {
				++steps;
				break;
			}

			++n;
			steps += 2;
		}

		o.println(steps);

		if (steps > 0) {
			for (int val : ans)
				o.print(val + " ");
		}

		o.flush();
		o.close();
	}
}
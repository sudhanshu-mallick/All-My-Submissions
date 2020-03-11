import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Taxi {

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
		int one = 0, two = 0, three = 0, four = 0;
		int ans = 0;

		for (int i = 0; i < n; i++) {
			int a = t.nextInt();

			if (a == 1)
				one++;
			else if (a == 2)
				two++;
			else if (a == 3)
				three++;
			else
				four++;
		}

		ans += four;
		ans += three;
		one = Math.max(0, one - three);
		ans += two / 2;

		if (two % 2 == 1) {
			if (one != 0) {
				one = Math.max(0, one - 2);
			}

			ans++;
		}

		if (one != 0)
			ans += (one + 3) / 4;

		o.println(ans);
		o.close();
	}

}
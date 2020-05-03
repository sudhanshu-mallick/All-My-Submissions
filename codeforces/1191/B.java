import java.util.*;
import java.io.*;

public class Tokitsukaze_And_Mahjong {

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
		String s[] = new String[3];
		int ans = 0;

		for (int i = 0; i < 3; ++i)
			s[i] = t.next();

		Arrays.sort(s);

		char ch[] = new char[3];
		int num[] = new int[3];

		for (int i = 0; i < 3; ++i) {
			ch[i] = s[i].charAt(1);
			num[i] = (int) (s[i].charAt(0) - '0');
		}

		if (ch[0] == ch[1] && ch[1] == ch[2]) {
			if (num[0] == num[1] && num[1] == num[2])
				ans = 0;
			else if (num[0] == num[1] - 1 && num[1] == num[2] - 1)
				ans = 0;
			else {
				if (Math.abs(num[0] - num[1]) <= 2 || Math.abs(num[1] - num[2]) <= 2)
					ans = 1;
				else
					ans = 2;
			}
		} else {
			if (ch[1] == ch[0] && Math.abs(num[1] - num[0]) <= 2)
				ans = 1;
			else if (ch[1] == ch[2] && Math.abs(num[1] - num[2]) <= 2)
				ans = 1;
			else if (ch[2] == ch[0] && Math.abs(num[2] - num[0]) <= 2)
				ans = 1;
			else
				ans = 2;
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}
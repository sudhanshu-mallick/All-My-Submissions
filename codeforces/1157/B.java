import java.io.*;
import java.util.*;

public class Long_Number {

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
		int n = t.nextInt(), flag = 0;
		char ch[] = new char[n];
		String s = t.next();
		ch = s.toCharArray();
		int[] a = new int[9];
		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < 9; ++i)
			a[i] = t.nextInt();

		for (int i = 0; i < n; i++) {
			int num = ch[i] - '0';

			if (num >= a[num - 1] && flag == 0)
				ans.append(num);
			else {
				if (num < a[num - 1] && flag == 0) {
					flag = 1;
					ans.append(a[num - 1]);
				} else if (num <= a[num - 1] && flag == 1) {
					ans.append(a[num - 1]);
				} else {
					flag = 2;
					ans.append(num);
				}
			}

		}

		o.println(ans);

		o.flush();
		o.close();
	}
}
import java.util.*;
import java.io.*;

public class Queue_At_School {

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
		int k = t.nextInt();
		char ch[] = t.next().toCharArray();

		for (int j = 0; j < k; ++j) {
			for (int i = 0; i < n - 1; ++i) {
				if (ch[i] == 'B' && ch[i + 1] == 'G') {
					ch[i] = 'G';
					ch[i + 1] = 'B';
					i++;
				}
			}
		}

		o.println(new String(ch));
		o.flush();
		o.close();
	}
}


import java.util.*;
import java.io.*;

public class ABBB {

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
		int test = t.nextInt();

		while (test-- > 0) {
			char[] ch = t.next().toCharArray();
			int n = ch.length;
			int numb = 0;
			int numa = 0;

			for (int i = n - 1; i >= 0; --i) {
				if (ch[i] == 'B') {
					numb++;
				} else {
					if (numb > 0) {
						numb--;
					} else
						numa++;
				}
			}

			o.println(numa + (numb & 1));

		}

		o.flush();
		o.close();
	}
}
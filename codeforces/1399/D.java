import java.util.*;
import java.io.*;

public class Binary_String_To_Subsequence {
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
			int n = t.nextInt();
			char ch[] = t.next().toCharArray();
			Stack<Integer> zero = new Stack<>();
			Stack<Integer> one = new Stack<>();
			int[] ans = new int[n];

			for (int i = 0; i < n; ++i) {
				int size = zero.size() + one.size();

				if (ch[i] == '0') {
					if (one.size() == 0) {
						zero.push(size);
					} else {
						size = one.pop();

						zero.push(size);
					}
				} else {
					if (zero.size() == 0) {
						one.push(size);
					} else {
						size = zero.pop();

						one.push(size);
					}
				}

				ans[i] = size + 1;
			}

			o.println(one.size() + zero.size());

			for (int v : ans)
				o.print(v + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}
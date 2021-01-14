import java.util.*;
import java.io.*;

public class Program {

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
			int queries = t.nextInt();
			char[] ch = t.next().toCharArray();
			int[] a = new int[n + 2];

			for (int i = 1; i <= n; ++i) {
				if (ch[i - 1] == '-')
					a[i] = a[i - 1] - 1;
				else
					a[i] = a[i - 1] + 1;
			}

			a[n + 1] = a[n];
			int[] preMin = new int[n + 2];
			int[] preMax = new int[n + 2];
			int[] sufMin = new int[n + 2];
			int[] sufMax = new int[n + 2];
			preMin[0] = preMax[0] = 0;
			sufMin[n + 1] = sufMax[n + 1] = a[n + 1];

			for (int i = 1; i <= n + 1; ++i) {
				preMin[i] = Math.min(preMin[i - 1], a[i]);
				preMax[i] = Math.max(preMax[i - 1], a[i]);
				sufMin[n - i + 1] = Math.min(sufMin[n - i + 2], a[n - i + 1]);
				sufMax[n - i + 1] = Math.max(sufMax[n - i + 2], a[n - i + 1]);
			}

			while (queries-- > 0) {
				int left = t.nextInt();
				int right = t.nextInt();
				int offset = a[left - 1] - a[right];
				int min, max;
				min = Math.min(0, Math.min(preMin[left - 1], sufMin[right + 1] + offset));
				max = Math.max(0, Math.max(preMax[left - 1], sufMax[right + 1] + offset));

				o.println(max - min + 1);
			}

		}

		o.flush();
		o.close();
	}
}
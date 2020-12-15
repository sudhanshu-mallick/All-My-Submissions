import java.util.*;
import java.io.*;

public class Last_Years_Substring {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			char ch[] = t.next().toCharArray();
			boolean ans = false;
			String a = ch[0] + "" + ch[1] + "" + ch[2] + "" + ch[3];
			String b = ch[0] + "" + ch[1] + "" + ch[2] + "" + ch[n - 1];
			String c = ch[0] + "" + ch[1] + "" + ch[n - 2] + "" + ch[n - 1];
			String d = ch[0] + "" + ch[n - 3] + "" + ch[n - 2] + "" + ch[n - 1];
			String e = ch[n - 4] + "" + ch[n - 3] + "" + ch[n - 2] + "" + ch[n - 1];

			if (a.equals("2020") || b.equals("2020") || c.equals("2020") || d.equals("2020") || e.equals("2020"))
				o.println("YES");
			else
				o.println("NO");
		}

		o.flush();
		o.close();
	}
}
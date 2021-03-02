
import java.util.*;
import java.io.*;

public class ABC_String {

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

		Arrays.sort(a);
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
			char[] ch = t.next().toCharArray();
			int n = ch.length;

			if (ch[0] == ch[n - 1]) {
				o.println("NO");
			} else {
				Stack<Character> stack = new Stack<>();
				boolean res1 = true, res2 = true;

				for (int i = 0; i < n; ++i) {
					if (ch[i] == ch[0])
						stack.push('(');
					else if (ch[i] == ch[n - 1]) {
						if (stack.size() > 0 && stack.peek() == '(') {
							stack.pop();
						} else {
							res1 = false;
							break;
						}
					} else
						stack.push('(');
				}

				if (stack.size() > 0)
					res1 = false;

				stack = new Stack<>();

				for (int i = 0; i < n; ++i) {
					if (ch[i] == ch[0])
						stack.push('(');
					else if (ch[i] == ch[n - 1]) {
						if (stack.size() > 0 && stack.peek() == '(') {
							stack.pop();
						} else {
							res2 = false;
							break;
						}
					} else {
						if (stack.size() > 0 && stack.peek() == '(') {
							stack.pop();
						} else {
							res2 = false;
							break;
						}
					}
				}

				if (stack.size() > 0)
					res2 = false;

				o.println((res1 || res2) ? "YES" : "NO");
			}
		}

		o.flush();
		o.close();
	}
}
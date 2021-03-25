import java.util.*;
import java.io.*;

public class Fixing_Typos {

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
		char ch[] = t.next().toCharArray();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (char c : ch) {
			if (stack.isEmpty() || stack.peek() != c || stack.size() == 1)
				stack.push(c);
			else {
				char ch1 = stack.pop();
				char ch2 = stack.pop();

				if (c == ch1 && c == ch2) {
					stack.push(ch1);
					stack.push(ch2);
				} else {
					if (stack.isEmpty() || stack.peek() != ch2) {
						stack.push(ch2);
						stack.push(ch1);
						stack.push(c);
					} else {
						stack.push(ch2);
						stack.push(ch1);
					}
				}
			}
		}

		while (!stack.isEmpty())
			sb.append(stack.pop());

		o.println(sb.reverse());
		o.flush();
		o.close();
	}
}
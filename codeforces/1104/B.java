import java.util.*;
import java.io.*;

public class Game_With_Strings {

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
		String s = t.next();
		int n = s.length();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);

			if (stack.isEmpty())
				stack.push(ch);
			else if (ch == stack.peek())
				stack.pop();
			else
				stack.push(ch);
		}

		if ((n - stack.size()) / 2 % 2 == 0)
			o.println("No");
		else
			o.println("Yes");

		o.flush();
		o.close();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Helpful_Maths {

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
		int one = 0, two = 0, three = 0;
		StringBuilder a = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				one++;
			else if (s.charAt(i) == '2')
				two++;
			else if (s.charAt(i) == '3')
				three++;
		}

		for (int i = 0; i < one; i++) {
			a.append("1+");
		}

		for (int i = 0; i < two; i++) {
			a.append("2+");
		}

		for (int i = 0; i < three; i++) {
			a.append("3+");
		}

		if (a.charAt(a.length() - 1) == '+')
			a.deleteCharAt(a.length() - 1);

		o.println(a);
		o.close();

	}

}

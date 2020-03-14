import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Life_Without_Zeros {

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
		String s1 = t.next();
		String s2 = t.next();
		long ans = Long.parseLong(s1) + Long.parseLong(s2);
		String s3 = Long.toString(ans);
		StringBuilder p1 = new StringBuilder();
		StringBuilder p2 = new StringBuilder();
		StringBuilder p3 = new StringBuilder();

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != '0')
				p1.append(s1.charAt(i));
		}

		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) != '0')
				p2.append(s2.charAt(i));
		}

		for (int i = 0; i < s3.length(); i++) {
			if (s3.charAt(i) != '0')
				p3.append(s3.charAt(i));
		}

		long anp = Long.parseLong(p1.toString()) + Long.parseLong(p2.toString());

		if (Long.parseLong(p3.toString()) != anp)
			o.println("NO");
		else
			o.println("YES");

		o.flush();
		o.close();
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Drazil_And_Factorial {

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
		int n = t.nextInt(), size = 0;
		String s = "";
		int[] a = new int[4];
		StringBuilder ans = new StringBuilder();
		s = t.next();

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);

			if (ch > '1') {
				if (ch == '2' || ch == '3')
					a[0]++;
				else if (ch == '4' || ch == '5')
					a[0] += 3;

				else if (ch == '6' || ch == '7')
					a[0] += 4;

				else if (ch == '8' || ch == '9')
					a[0] += 7;

				if (ch >= '3' && ch < '6')
					a[1]++;
				else if (ch >= '6' && ch < '9')
					a[1] += 2;
				else if (ch == '9')
					a[1] += 4;

				if (ch >= '5')
					a[2]++;

				if (ch >= '7')
					a[3]++;
			}

		}

		size = a[3];

		for (int i = 0; i < size; i++) {
			ans.append('7');
			a[3]--;
			a[2]--;
			a[1] -= 2;
			a[0] -= 4;
		}

		size = a[2];

		for (int i = 0; i < size; i++) {
			ans.append('5');
			a[2]--;
			a[1]--;
			a[0] -= 3;
		}

		size = a[1];

		for (int i = 0; i < size; i++) {
			ans.append('3');
			a[1]--;
			a[0]--;
		}

		size = a[0];

		for (int i = 0; i < size; i++) {
			ans.append('2');
			a[0]--;
		}

		o.println(ans);
		o.flush();
		o.close();
	}

}

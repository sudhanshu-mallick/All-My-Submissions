import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MUH_And_Sticks {

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
		int[] a = new int[6];
		int max = 1, idx = 0, cmax = 1;

		for (int i = 0; i < 6; i++)
			a[i] = t.nextInt();

		Arrays.sort(a);

		for (int i = 0; i < 6 - 1; i++) {
			if (a[i] == a[i + 1]) {
				cmax++;

				if (max < cmax) {
					max = cmax;
					idx = i;
				}
			} else {
				cmax = 1;
			}
		}

		if (max >= 4) {
			if (idx == 2) {
				if (a[4] < a[5])
					o.println("Bear");
				else
					o.println("Elephant");
			} else if (idx == 3) {
				if (a[0] < a[5])
					o.println("Bear");
				else
					o.println("Elephant");
			} else {
				if (a[0] < a[1])
					o.println("Bear");
				else
					o.println("Elephant");
			}
		} else {
			o.print("Alien");
		}

		o.flush();
		o.close();
	}

}

import java.util.*;
import java.io.*;

public class Vasya_And_Petya_Game {

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
		int n = t.nextInt();
		ArrayList<Integer> list = new ArrayList<>(), a;
		a = soe(n);

		for (int i = 0; i < a.size(); ++i) {
			int el = a.get(i);
			int ans = el;

			while (ans <= n) {
				list.add(ans);

				ans = ans * el;
			}
		}

		o.println(list.size());

		for (int i = 0; i < list.size(); ++i) {
			o.print(list.get(i) + " ");
		}

		o.flush();
		o.close();
	}

	private static ArrayList<Integer> soe(int n) {
		ArrayList<Integer> a = new ArrayList<>();

		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}

		for (int i = 2; i <= n; i++) {
			if (prime[i] == true)
				a.add(i);
		}

		return a;
	}
}
import java.util.*;
import java.io.*;

public class Consecutive_Subsequnece {

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
		int[] a = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0, last = 0;

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();
			int val = !map.containsKey(a[i] - 1) ? 1 : map.get(a[i] - 1) + 1;

			map.put(a[i], val);

			if (val > max) {
				last = a[i];
				max = val;
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = n - 1; i >= 0; --i) {
			if (a[i] == last) {
				ans.add(i + 1);
				last--;
			}
		}

		o.println(ans.size());

		for (int i = ans.size() - 1; i >= 0; --i)
			o.print(ans.get(i) + " ");

		o.flush();
		o.close();
	}
}
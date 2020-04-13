import java.util.*;
import java.io.*;

public class Filya_And_Homework {

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
		boolean flag = true;
		ArrayList<Long> a = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			long e = t.nextLong();

			if (a.contains(e)) {

			} else {
				if (a.size() >= 3)
					flag = false;
				else
					a.add(e);
			}
		}

		if (flag) {
			Collections.sort(a);
			if (a.size() <= 2)
				o.println("YES");
			else {
				if (a.get(1) - a.get(0) == a.get(2) - a.get(1))
					o.println("YES");
				else
					o.println("NO");
			}
		} else {
			o.println("NO");
		}

		o.flush();
		o.close();
	}
}
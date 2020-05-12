import java.util.*;
import java.io.*;

public class Another_Problem_In_Strings {

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
		int k = t.nextInt();
		String s = t.next();
		ArrayList<Long> list = new ArrayList<>();
		list.add(-1l);
		long count = 0;

		for (int i = 0; i < s.length(); ++i)
			if (s.charAt(i) == '1')
				list.add((long) i);

		list.add((long) s.length());

		if (k > 0)
			for (int i = 1; i < list.size() - k; ++i) {
				long left = list.get(i) - list.get(i - 1);
				long right = list.get(i + k) - list.get(i + k - 1);
				count += left * right;
			}
		else
			for (int i = 1; i < list.size(); ++i) {
				long num = list.get(i) - list.get(i - 1) - 1;
				count += (num) * (num + 1) / 2;
			}

		o.println(count);

		o.flush();
		o.close();
	}
}

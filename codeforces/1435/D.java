import java.util.*;
import java.io.*;

public class Shurikens {

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
		TreeSet<Integer> pq = new TreeSet<>();
		char[] ch = new char[n << 1];
		List<Integer> list = new ArrayList<>();
		boolean flag = true;
		List<Integer> ans = new ArrayList<>();
		int idx = n - 1;

		for (int i = 0; i < (n << 1); ++i) {
			char c = t.next().charAt(0);
			ch[i] = c;

			if (c == '-') {
				list.add(t.nextInt());
			}
		}

		for (int i = (n << 1) - 1; i >= 0; --i) {
			if (ch[i] == '+') {
				if (pq.isEmpty()) {
					flag = false;

					break;
				} else {
					ans.add(pq.first());
					pq.remove(pq.first());
				}
			} else {
				if (pq.isEmpty()) {
					pq.add(list.get(idx));

					--idx;
				} else if (pq.first() < list.get(idx)) {
					flag = false;

					break;
				} else {
					pq.add(list.get(idx));

					--idx;
				}
			}
		}

		if (flag) {
			o.println("YES");

			for (int i = n - 1; i >= 0; --i)
				o.print(ans.get(i) + " ");
		} else
			o.println("NO");

		o.flush();
		o.close();
	}
}
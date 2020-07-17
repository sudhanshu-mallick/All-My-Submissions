import java.util.*;
import java.io.*;

public class a_Good_String {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			char a[] = t.next().toCharArray();
			int pow = 0;
			int cur = n;
			List<Integer> list = new ArrayList<>();

			while (cur > 0) {
				pow++;
				cur = cur >> 1;
			}

			char ch = (char) ('a' + pow - 1);

			for (int i = 0; i < n; ++i) {
				if (a[i] == ch)
					list.add(0);
				else
					list.add(1);
			}

			cur = 1;
			ch--;

			while (cur < n) {				
				List<Integer> temp = new ArrayList<>();

				for (int i = 0; i < n; i += cur) {
					int cnt = 0;

					for (int j = i; j < i + cur; ++j) {
						if (a[j] != ch)
							cnt++;
					}

					temp.add(cnt);
				}

				List<Integer> fin = new ArrayList<>();

				for (int i = 0; i < temp.size(); i += 2) {
					fin.add(Math.min(temp.get(i) + list.get(i + 1), temp.get(i + 1) + list.get(i)));
				}

				list = fin;
				cur = cur << 1;
				ch--;
			}

			int min = Integer.MAX_VALUE;
	
			for (int i = 0; i < list.size(); ++i)
				min = Math.min(min, list.get(i));

			o.println(min);

		}

		o.flush();
		o.close();
	}
}

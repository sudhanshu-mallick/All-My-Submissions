import java.util.*;
import java.io.*;

public class Chess_Cheater {

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
			int k = t.nextInt();
			char[] ch = t.next().toCharArray();
			int sum = 0;
			int i = 0;
			int j = n - 1;
			int p = 0;
			List<Pair> list = new ArrayList<>();

			while (i < n && ch[i] == 'L') {
				++i;
			}

			while (j >= 0 && ch[j] == 'L') {
				--j;
			}

			p = i;
			int count = 0;

			while (i <= j) {
				if (ch[i] == 'W') {
					if (count != 0) {
						list.add(new Pair(i - count, count));

						count = 0;
					}
				} else {
					count++;
				}
				
				++i;
			}

			Collections.sort(list, (Pair x, Pair y) -> x.count - y.count);

			i = 0;

			while (k > 0) {
				if (i >= list.size())
					break;

				int idx = list.get(i).idx;
				count = list.get(i).count;

				while (k > 0 && count > 0) {
					ch[idx] = 'W';
					++idx;
					--count;
					--k;
				}

				++i;
			}

			++j;

			while (k > 0 && j < n) {
				ch[j++] = 'W';
				--k;
			}

			--p;

			while (k > 0 && p >= 0) {
				ch[p--] = 'W';
				--k;
			}

			if (ch[0] == 'W')
				sum += 1;

			for (i = 1; i < n; ++i) {
				if (ch[i] == 'W') {
					if (ch[i - 1] == 'W')
						sum += 2;
					else
						++sum;
				}
			}

			o.println(sum);
		}

		o.flush();
		o.close();
	}
}

class Pair {
	int idx;
	int count;

	Pair(int idx, int count) {
		this.idx = idx;
		this.count = count;
	}
}
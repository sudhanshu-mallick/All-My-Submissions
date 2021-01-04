import java.util.*;
import java.io.*;

public class Even_Odd_Game {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			List<Long> even = new ArrayList<>();
			List<Long> odd = new ArrayList<>();
			long alice = 0, bob = 0;

			while (n-- > 0) {
				long x = t.nextLong();

				if ((x & 1) == 0)
					even.add(x);
				else
					odd.add(x);
			}

			Collections.sort(even, Collections.reverseOrder());
			Collections.sort(odd, Collections.reverseOrder());

			int i = 0, j = 0;
			int ev = even.size(), od = odd.size();
			boolean turn = true;

			while (i < even.size() && j < odd.size()) {
				if (turn) {
					if (even.get(i) > odd.get(j))
						alice += even.get(i++);
					else
						++j;
				} else {
					if (even.get(i) > odd.get(j))
						++i;
					else
						bob += odd.get(j++);
				}

				turn = !turn;
			}

			while (i < ev) {
				if (turn) {
					alice += even.get(i++);
				} else {
					++i;
				}

				turn = !turn;
			}

			while (j < od) {
				if (turn) {
					++j;
				} else {
					bob += odd.get(j++);
				}

				turn = !turn;
			}

			o.println(alice > bob ? "Alice" : alice < bob ? "Bob" : "Tie");
		}

		o.flush();
		o.close();
	}
}
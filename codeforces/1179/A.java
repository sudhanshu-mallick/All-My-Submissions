import java.util.*;
import java.io.*;

public class Valery_And_Deque {

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
		int q = t.nextInt();
		int idx = 0;
		int max = 0;
		List<int[]> pre = new ArrayList<>();
		Deque<Integer> dq = new LinkedList<>();

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();

			if (a[i] > max) {
				idx = i;
				max = a[i];
			}

			dq.add(a[i]);
		}

		for (int i = 0; i < idx; ++i) {
			int v1 = dq.removeFirst();
			int v2 = dq.removeFirst();

			pre.add(new int[] { v1, v2 });

			if (v1 > v2) {
				dq.addFirst(v1);
				dq.addLast(v2);
			} else {
				dq.addFirst(v2);
				dq.addLast(v1);
			}
		}

		dq.removeFirst();

		for (int i = 0; i < n - 1; ++i) {
			a[i] = dq.removeFirst();
		}
		
		while (q-- > 0) {
			long m = t.nextLong();

			if (m <= (long) pre.size())
				o.println(pre.get((int) m - 1)[0] + " " + pre.get((int) m - 1)[1]);
			else {
				m -= pre.size() - (n - 2);
				m %= (n - 1);

				o.println(max + " " + a[(int) m]);
			}
		}

		o.flush();
		o.close();
	}
}
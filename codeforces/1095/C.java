import java.util.*;
import java.io.*;
import java.util.Queue;

public class Power_Of_Two {

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
		long n = t.nextLong();
		long k = t.nextLong();
		long p = n;
		long count = 0;

		while (p > 0) {
			count += (p & 1);
			p = p >> 1;
		}

		if (k < count || k > n) {
			o.println("NO");
		} else {
			o.println("YES");

			Queue<Long> queue = new LinkedList<>();
			p = 1;

			while (n > 0) {
				if ((n & 1) == 1)
					queue.add(p);

				n = n >> 1;
				p = p << 1;
			}

			while (queue.size() < k) {
				long val;

				while (queue.peek() == 1) {
					val = queue.remove();
					queue.add(val);
				}

				val = queue.remove();
				val = val >> 1;

				queue.add(val);
				queue.add(val);
			}

			while (!queue.isEmpty()) {
				o.print(queue.remove() + " ");
			}

		}

		o.flush();
		o.close();
	}
}

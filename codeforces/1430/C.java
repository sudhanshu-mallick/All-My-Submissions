import java.util.*;
import java.io.*;

public class Numbers_On_Whiteboard {

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
			PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y.intValue() - x.intValue());

			for (int i = 0; i < n; ++i) {
				pq.add(i + 1);
			}

			o.println("2");

			while (pq.size() > 2) {
				int x = pq.remove();
				int y = pq.remove();

				o.println(x + " " + y);
				pq.add((x + y + 1) / 2);
			}

			o.println(pq.remove() + " " + pq.remove());
		}

		o.flush();
		o.close();
	}
}
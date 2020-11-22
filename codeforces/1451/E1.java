import java.util.*;
import java.io.*;

public class Bitwise_Queries {

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

	static FastReader t = new FastReader();
	static PrintWriter o = new PrintWriter(System.out);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = t.nextInt();
		ArrayList<Integer> list[] = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++)
			list[i] = new ArrayList<Integer>();

		int xor[] = new int[n + 1];
		int ans[] = new int[n + 1];
		xor[1] = 0;

		list[0].add(1);

		for (int i = 2; i <= n; i++) {
			xor[i] = queries("XOR", 1, i);

			list[xor[i]].add(i);
		}

		int a = 1, b = -1, c = -1;
		int same = -1;

		for (int i = 0; i < n; i++)
			if (list[i].size() > 1) {
				b = list[i].get(0);
				c = list[i].get(1);

				same = i;
			}

		if (same == -1) {
			for (int i = 2; i <= 3; i++)
				for (int j = i + 1; j <= n; j++)
					if ((xor[i] ^ xor[j]) == n - 1) {
						b = i;
						c = j;
					}

			int xorab = xor[a] ^ xor[b];
			int xorac = xor[a] ^ xor[c];
			int xorbc = xor[b] ^ xor[c];
			int andab = queries("AND", a, b);
			int andac = queries("AND", a, c);
			int andbc = 0;
			int x = xorab + 2 * andab;
			int y = xorac + 2 * andac;
			int z = xorbc + 2 * andbc;
			ans[a] = (x + y - z) / 2;
		} else {
			ans[b] = queries("AND", b, c);
			ans[1] = xor[b] ^ ans[b];
		}

		for (int i = 2; i <= n; i++)
			ans[i] = (xor[i] ^ ans[1]);

		o.print("! ");

		for (int i = 1; i <= n; i++)
			o.print(ans[i] + " ");

		o.flush();
		o.close();
	}

	public static int queries(String s, int i, int j) {
		o.println(s + " " + i + " " + j);
		o.flush();
		return t.nextInt();
	}
}
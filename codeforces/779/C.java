import java.util.*;
import java.io.*;

public class Dishonest_Sellers {

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
		int k = t.nextInt();
		Node node[] = new Node[n];
		int[] a = new int[n], b = new int[n];
		int sum = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		for (int i = 0; i < n; ++i)
			b[i] = t.nextInt();

		for (int i = 0; i < n; ++i)
			node[i] = new Node(a[i], b[i]);

		Arrays.sort(node, (Node x, Node y) -> x.dif - y.dif);

		for (int i = 0; i < n; ++i) {
			if (i < k)
				sum += node[i].a;
			else
				sum += Math.min(node[i].a, node[i].b);
		}

		o.println(sum);

		o.flush();
		o.close();
	}
}

class Node {
	int dif, a, b;

	Node(int a, int b) {
		this.a = a;
		this.b = b;
		dif = a - b;
	}
}
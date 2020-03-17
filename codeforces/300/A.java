import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Array {

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
		int neg = 0, pos = 0, zer = 0;
		ArrayList<Integer> p = new ArrayList<>();
		ArrayList<Integer> q = new ArrayList<>();
		ArrayList<Integer> r = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (a[i] < 0)
				neg++;
			else if (a[i] > 0)
				pos++;
			else
				zer++;
		}

		if (neg % 2 == 1) {
			int flag = 0;

			for (int i = 0; i < n; i++) {
				if (a[i] < 0 && flag == 0) {
					flag = 1;
					p.add(a[i]);
				} else if (a[i] != 0)
					q.add(a[i]);
				else
					r.add(a[i]);
			}
		} else {
			int flag = 0;

			for (int i = 0; i < n; i++) {
				if (a[i] < 0 && flag == 0) {
					flag = 1;
					p.add(a[i]);
				} else if (a[i] != 0 && neg >= 3) {
					if (flag >= 3 && a[i] < 0) {
						{
							r.add(a[i]);
						}
					} else if (flag < 3 && a[i] < 0) {
						q.add(a[i]);
						flag++;
					} else
						q.add(a[i]);
				} else if (a[i] != 0 && neg < 3) {
					if (a[i] < 0)
						r.add(a[i]);
					else
						q.add(a[i]);
				} else
					r.add(a[i]);
			}
		}

		o.print(p.size() + " ");

		for (int i = 0; i < p.size(); i++)
			o.print(p.get(i) + " ");

		o.println();

		o.print(q.size() + " ");

		for (int i = 0; i < q.size(); i++)
			o.print(q.get(i) + " ");

		o.println();

		o.print(r.size() + " ");

		for (int i = 0; i < r.size(); i++)
			o.print(r.get(i) + " ");

		o.println();

		o.flush();
		o.close();

	}
}
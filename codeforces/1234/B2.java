import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Social_Network {

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
		HashSet<Integer> map = new HashSet<>();
		int k = t.nextInt();
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			int a = t.nextInt();

			if (q.size() < k) {
				if (map.contains(a)) {

				} else {
					{
						q.add(a);
						map.add(a);
					}
				}
			} else {
				if (map.contains(a)) {

				} else {
					int p = q.remove();
					map.remove(p);
					q.add(a);
					map.add(a);
				}
			}
		}

		o.println(q.size());
		ArrayList<Integer> list = new ArrayList<>();

		while (q.size() > 0)
			list.add(q.remove());

		for (int i = 0; i < list.size(); i++)
			o.print(list.get(list.size() - i - 1) + " ");

		o.flush();
		o.close();
	}

}

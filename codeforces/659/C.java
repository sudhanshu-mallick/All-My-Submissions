import java.util.*;
import java.io.*;

public class Tanya_And_Toys {

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
		int n = t.nextInt(), idx = 1;
		long m = t.nextLong(), sum = 0;
		HashSet<Integer> map = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; ++i)
			map.add(t.nextInt());

		while (sum <= m) {
			if (!map.contains(idx)) {
				sum += idx;

				if (sum > m)
					break;
				list.add(idx);
			}

			idx++;
		}

		o.println(list.size());

		for (int i = 0; i < list.size(); ++i)
			o.print(list.get(i) + " ");

		o.flush();
		o.close();
	}
}
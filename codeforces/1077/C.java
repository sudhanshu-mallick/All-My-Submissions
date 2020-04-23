import java.util.*;
import java.io.*;

public class Good_Array {

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
		long sum = 0;
		long[] a = new long[n];
		long[] count = new long[1000001];
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextLong();
			sum += a[i];
			count[(int) a[i]]++;
		}

		for (int i = 0; i < n; ++i) {
			long v = sum - a[i];
			count[(int) a[i]]--;

			if ((v & 1) == 0 && v / 2 <= 1000000 && count[(int) v / 2] > 0)
				list.add(i + 1);

			count[(int) a[i]]++;
		}

		o.println(list.size());

		for (int i = 0; i < list.size(); o.print(list.get(i++) + " ")) {
		}

		o.flush();
		o.close();
	}
}
import java.util.*;
import java.io.*;

public class Divide_And_Summarize {

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

	public static void shuffle(long[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}
	}

	public static void swap(long[] a, int i, int j) {
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			freq = new long[1000001];
			set = new HashSet<>();
			int n = t.nextInt();
			int q = t.nextInt();

			for (int i = 0; i < n; ++i) {
				int v = t.nextInt();
				freq[v] += v;
			}

			calc(1, 1000000);

			while (q-- > 0) {
				long sum = t.nextLong();

				if (set.contains(sum))
					o.println("Yes");
				else
					o.println("No");
			}

		}

		o.flush();
		o.close();
	}

	public static long freq[];
	public static Set<Long> set;

	public static void calc(int low, int high) {
		if (low > high)
			return;

		while (low < high && freq[low] == 0)
			++low;

		while (high > low & freq[high] == 0)
			--high;

		if (low == high) {
			if (freq[low] != 0)
				set.add(freq[low]);

			return;
		}

		long sum = 0;
		int mid = ((low + high) >> 1);

		for (int i = low; i <= high; ++i)
			sum += freq[i];

		set.add(sum);
		calc(low, mid);
		calc(mid + 1, high);
	}
}
import java.util.*;
import java.io.*;

public class Stable_Groups {

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

		Arrays.sort(a);
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
		int n = t.nextInt();
		long k = t.nextLong();
		long x = t.nextLong();
		long[] a = new long[n];
		List<List<Long>> list = new ArrayList<>();
		List<Long> temp = new ArrayList<>();
		List<Long> count = new ArrayList<>();

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		shuffle(a);

		int i = 0;
		long prev = a[0];

		while (i < n) {
			if (a[i] - prev <= x)
				temp.add(a[i]);
			else {
				list.add(temp);

				temp = new ArrayList<>();

				temp.add(a[i]);
			}

			prev = a[i];
			++i;
		}

		if (temp.size() > 0)
			list.add(temp);

		long size = list.size();

		for (i = 1; i < list.size(); ++i)
			count.add(list.get(i).get(0) - list.get(i - 1).get(list.get(i - 1).size() - 1));

		Collections.sort(count);

		i = 0;

//		System.out.println(count);

		while (k > 0 && i < count.size()) {
			long req = (count.get(i) + x - 1) / x - 1;

			if (req > k)
				break;
			else
				k -= req;

			--size;
			++i;
		}

		o.println(size);
		o.flush();
		o.close();
	}
}
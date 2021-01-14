import java.util.*;
import java.io.*;

public class Program {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int queries = t.nextInt();
			char[] ch = t.next().toCharArray();
			int[] a = new int[n + 2];

			for (int i = 1; i <= n; ++i) {
				if (ch[i - 1] == '-')
					a[i] = a[i - 1] - 1;
				else
					a[i] = a[i - 1] + 1;
			}

			a[n + 1] = a[n];
			Min min = new Min();
			Max max = new Max();

			min.constructST(a, n + 2);
			max.constructST(a, n + 2);

			while (queries-- > 0) {
				int left = t.nextInt();
				int right = t.nextInt();
				int mi = 0, ma = 0;
				int MIN = min.RMQ(n + 2, 0, left - 1);
				mi = Math.min(mi, MIN);
				ma = Math.max(ma, MIN);
				int MAX = max.RMQ(n + 2, 0, left - 1);
				mi = Math.min(mi, MAX);
				ma = Math.max(ma, MAX);
				int offset = a[left - 1] - a[right];
				MIN = min.RMQ(n + 2, right, n + 1);
				mi = Math.min(mi, MIN + offset);
				ma = Math.max(ma, MIN + offset);
				MAX = max.RMQ(n + 2, right, n + 1);
				mi = Math.min(mi, MAX + offset);
				ma = Math.max(ma, MAX + offset);

				o.println(ma - mi + 1);
			}

		}

		o.flush();
		o.close();
	}

	static class Min {
		int st[];

		int minVal(int x, int y) {
			return (x < y) ? x : y;
		}

		int getMid(int s, int e) {
			return s + (e - s) / 2;
		}

		int RMQUtil(int ss, int se, int qs, int qe, int index) {
			if (qs <= ss && qe >= se)
				return st[index];

			if (se < qs || ss > qe)
				return Integer.MAX_VALUE;

			int mid = getMid(ss, se);

			return minVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1), RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
		}

		int RMQ(int n, int qs, int qe) {
			if (qs < 0 || qe > n - 1 || qs > qe) {
				System.out.println("Invalid Input");
				return -1;
			}

			return RMQUtil(0, n - 1, qs, qe, 0);
		}

		int constructSTUtil(int arr[], int ss, int se, int si) {
			if (ss == se) {
				st[si] = arr[ss];
				return arr[ss];
			}

			int mid = getMid(ss, se);
			st[si] = minVal(constructSTUtil(arr, ss, mid, si * 2 + 1), constructSTUtil(arr, mid + 1, se, si * 2 + 2));

			return st[si];
		}

		void constructST(int arr[], int n) {
			int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
			int max_size = 2 * (int) Math.pow(2, x) - 1;
			st = new int[max_size];

			constructSTUtil(arr, 0, n - 1, 0);
		}
	}

	static class Max {
		int st[];

		int minVal(int x, int y) {
			return (x < y) ? y : x;
		}

		int getMid(int s, int e) {
			return s + (e - s) / 2;
		}

		int RMQUtil(int ss, int se, int qs, int qe, int index) {
			if (qs <= ss && qe >= se)
				return st[index];

			if (se < qs || ss > qe)
				return Integer.MIN_VALUE;

			int mid = getMid(ss, se);

			return minVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1), RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
		}

		int RMQ(int n, int qs, int qe) {
			if (qs < 0 || qe > n - 1 || qs > qe) {
				System.out.println("Invalid Input");
				return -1;
			}

			return RMQUtil(0, n - 1, qs, qe, 0);
		}

		int constructSTUtil(int arr[], int ss, int se, int si) {
			if (ss == se) {
				st[si] = arr[ss];
				return arr[ss];
			}

			int mid = getMid(ss, se);
			st[si] = minVal(constructSTUtil(arr, ss, mid, si * 2 + 1), constructSTUtil(arr, mid + 1, se, si * 2 + 2));

			return st[si];
		}

		void constructST(int arr[], int n) {
			int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
			int max_size = 2 * (int) Math.pow(2, x) - 1;
			st = new int[max_size];

			constructSTUtil(arr, 0, n - 1, 0);
		}
	}
}

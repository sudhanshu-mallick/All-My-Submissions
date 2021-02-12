import java.util.*;
import java.io.*;

public class Floor_And_Mod {

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

		Arrays.sort(a);
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
			long x = t.nextLong();
			long y = t.nextLong();
			long l = 2, r = y;
			long now = r;

			while (l <= r) {
				long mid = (l + r) >> 1;

				if ((mid + 1) * (mid - 1) <= x) {
					l = mid + 1;
				} else {
					r = mid - 1;
					now = r;
				}
			}

			long cur = now + 1;
			now = (now * (now - 1)) >> 1;
			long cnt = cur - 1;

			while (cnt > 0 && cur < x && cur <= y) {
				long low = cur, high = y;
				long here = -1;

				while (low <= high) {
					long mid = (low + high) >> 1;

					if (mid > cnt && (mid + 1) * cnt <= x) {
						low = mid + 1;
						here = low - 1;
					} else {
						high = mid - 1;

					}
				}

				if (here > cnt)
					now = now + (here - cur + 1) * cnt;

				cur = Math.max(here + 1, cur);
				--cnt;
			}

			o.println(now);

		}

		o.flush();
		o.close();
	}
}
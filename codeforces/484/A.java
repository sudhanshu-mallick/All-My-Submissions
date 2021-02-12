import java.util.*;
import java.io.*;

public class Bits {

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
			int[] low = new int[64];
			int[] high = new int[64];
			long l = t.nextLong();
			long h = t.nextLong();
			int i = 63;
			boolean flag = true;
			int cnt = 0;
			long H = h;

			while (i >= 0 && l > 0) {
				if ((l & 1) == 1)
					low[i] = 1;

				--i;
				l >>= 1;
			}

			i = 63;

			while (i >= 0 && h > 0) {
				if ((h & 1) == 1) {
					high[i] = 1;
					++cnt;
				}

				if (high[i] != 1) {
					flag = false;
				}

				--i;
				h >>= 1;
			}

			if (flag) {
				i = 0;
				long ans = 0;

				while (i < 64) {
					if (high[i] == 1) {
						ans = (ans + 1) << 1;
					}

					++i;
				}

				o.println(ans >> 1);
			} else {
				i = 0;
				long ans = 0;
				flag = true;

				while (i <= 63) {
					if (!flag) {
						ans = (ans + 1) << 1;
					} else {
						if (high[i] == low[i]) {
							ans = (ans + high[i]) << 1;
						} else {
							if (i == 63) {
								ans = (ans + 1) << 1;
							} else {
								ans = ans << 1;
								flag = false;
							}
						}
					}

					++i;
				}

				int cntAns = 0;
				long p = ans;

				while (ans > 0) {
					if ((ans & 1) == 1)
						++cntAns;

					ans = ans >> 1;
				}

				if (cntAns >= cnt)
					o.println(p >> 1);
				else
					o.println(H);
			}
		}

		o.flush();
		o.close();
	}
}
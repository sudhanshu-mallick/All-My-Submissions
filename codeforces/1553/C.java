import java.util.*;
import java.io.*;

public class Penalty {

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
			char[] ch = t.next().toCharArray();
			int[] first = new int[2];
			int[] second = new int[2];

			for (int i = 0; i < 10; ++i) {
				if ((i & 1) == 0) {
					if (ch[i] == '?')
						++first[1];
					else
						first[0] += ch[i] - '0';
				} else {
					if (ch[i] == '?')
						++second[1];
					else
						second[0] += ch[i] - '0';
				}
			}

			int i = 9, ans = 10;

			while (i >= 0) {
				int maxFirst = first[0] + first[1];
				int minFirst = first[0];
				int maxSecond = second[0] + second[1];
				int minSecond = second[0];
				boolean flag = false;

				if (maxFirst > minSecond) {
					int firstScore = maxFirst;
					int secondScore = minSecond;

					for (int k = i + 1; k < 10; ++k) {
						if ((k & 1) == 1) {
							++secondScore;
						} else {
//							++firstScore;
						}
					}

					if (firstScore > secondScore) {
						ans = i + 1;

						flag = true;
					}
				}

				if (maxSecond > minFirst) {
					int firstScore = minFirst;
					int secondScore = maxSecond;

					for (int k = i + 1; k < 10; ++k) {
						if ((k & 1) == 1) {
//							++secondScore;
						} else {
							++firstScore;
						}
					}

					if (secondScore > firstScore) {
						ans = i + 1;
						flag = true;
					}
				}

				if (!flag)
					break;

				if ((i & 1) == 0) {
					if (ch[i] == '?')
						--first[1];
					else
						first[0] -= ch[i] - '0';
				} else {
					if (ch[i] == '?')
						--second[1];
					else
						second[0] -= ch[i] - '0';
				}

				--i;
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}
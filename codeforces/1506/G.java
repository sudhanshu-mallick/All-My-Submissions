import java.util.*;
import java.io.*;

public class Maximizing_The_Remaining_String {

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
			char ch[] = t.next().toCharArray();
			int n = ch.length;
			int[][] map = new int[n][27];
			map[n - 1][0] = map[n - 1][ch[n - 1] - 'a' + 1] = 1;
			StringBuilder sb = new StringBuilder();
			Queue<Integer> pos[] = new LinkedList[26];
			Set<Character> set = new HashSet<>();
			int cur = 0;

			for (int i = 0; i < 26; ++i)
				pos[i] = new LinkedList<>();

			for (int i = 0; i < n; ++i) {
				pos[ch[i] - 'a'].add(i);
			}

			for (int i = n - 2; i >= 0; --i) {
				int id = ch[i] - 'a' + 1;
				map[i][0] = map[i + 1][0];

				if (map[i + 1][id] == 0)
					++map[i][0];

				for (int j = 1; j <= 26; ++j)
					map[i][j] = map[i + 1][j];

				++map[i][id];
			}

//			for (int i = 0; i < n; ++i)
//				System.out.print(map[i][0] + " ");
//
//			System.out.println();

			for (int j = 0; j < map[0][0]; ++j)
				for (int i = 25; i >= 0; --i) {
					if (pos[i].isEmpty() || set.contains((char) ('a' + i)))
						continue;

					int rem = map[0][0] - j;
					int id = pos[i].peek();

					int cnt = 0;

					for (Character c : set) {
						if (map[id][c - 'a' + 1] > 0)
							++cnt;
					}

					if (map[id][0] - cnt == rem) {
						sb.append((char) ('a' + i));
						set.add((char) ('a' + i));

						cur = id;

						for (int k = 0; k < 26; ++k) {
							while (!pos[k].isEmpty() && pos[k].peek() <= cur)
								pos[k].remove();
						}

						break;
					}
				}

			o.println(sb);
		}

		o.flush();
		o.close();
	}
}
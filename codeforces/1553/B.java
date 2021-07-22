import java.util.*;
import java.io.*;

public class Reverse_String {

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
			char[] s = t.next().toCharArray();
			char[] ch = t.next().toCharArray();
			Queue<int[]> queue = new LinkedList<>();

			for (int i = 0; i < s.length; ++i)
				if (s[i] == ch[0])
					queue.add(new int[] { i, 1 });

			if (queue.isEmpty()) {
				o.println("NO");
			}

			else {
				int i = 1;

				while (i < ch.length && !queue.isEmpty()) {
					boolean[][] added = new boolean[s.length][2];
					int size = queue.size();

					for (int k = 0; k < size; ++k) {
						int idx[] = queue.remove();
						boolean isRight = idx[1] == 1;
						int index = idx[0];

						if (isRight) {
							if (index > 0 && s[index - 1] == ch[i] && !added[index - 1][0]) {
								added[index - 1][0] = true;

//								System.out.println(index - 1 + " " + 0);
								queue.add(new int[] { index - 1, 0 });
							}

							if (index < s.length - 1 && s[index + 1] == ch[i] && !added[index + 1][1]) {
								added[index + 1][1] = true;

//								System.out.println(index + 1 + " " + 1);
								queue.add(new int[] { index + 1, 1 });
							}
						} else {
							if (index > 0 && s[index - 1] == ch[i] && !added[index - 1][0]) {
								added[index - 1][0] = true;

//								System.out.println(index - 1 + " " + 0);
								queue.add(new int[] { index - 1, 0 });
							}
						}
					}

					if (queue.isEmpty())
						break;

					++i;
				}

				o.println(i == ch.length ? "YES" : "NO");
			}
		}

		o.flush();
		o.close();
	}
}
import java.util.*;
import java.io.*;

public class Physics_Practical {

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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(new File("input.txt"));
		FileWriter o = new FileWriter("output.txt");
		int n = t.nextInt();
		int[] a = new int[n];
		int ans = n - 1;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		shuffle(a);

		int i = 0, j = 0;

		while (i < n) {
			while (j < n && a[i] << 1 >= a[j])
				++j;

			ans = Math.min(ans, i + n - j);
			++i;
		}

		o.write(ans + "");
		o.close();
	}
}
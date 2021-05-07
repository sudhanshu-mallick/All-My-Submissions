import java.util.*;
import java.io.*;

public class Psychos_In_A_Line {

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
		int n = t.nextInt();
		int[] a = new int[n];
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		int[] life = new int[n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		for (int i = 0; i < n; ++i) {
			life[i] = 1;

			while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
				life[i] = Math.max(life[i], life[stack.peek()] + 1);

				stack.pop();
			}

			if (stack.isEmpty())
				life[i] = 0;

			max = Math.max(max, life[i]);

			stack.push(i);
		}

		o.println(max);
		o.flush();
		o.close();
	}
}
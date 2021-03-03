import java.util.*;
import java.io.*;

public class _1D_Sokoban {

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
			int m = t.nextInt();
			int n = t.nextInt();
			List<Integer> pos = new ArrayList<>();
			List<Integer> specialPos = new ArrayList<>();
			List<Integer> neg = new ArrayList<>();
			List<Integer> specialNeg = new ArrayList<>();

			for (int i = 0; i < m; ++i) {
				long x = t.nextLong();

				if (x > 0)
					pos.add((int) x);
				else
					neg.add((int) x);
			}

			for (int i = 0; i < n; ++i) {
				long x = t.nextLong();

				if (x > 0)
					specialPos.add((int) x);
				else
					specialNeg.add((int) x);
			}

			int count[] = new int[pos.size()];
			int i = 0, j = 0;

			while (i < pos.size()) {
				if (j >= specialPos.size())
					count[i] = i > 0 ? count[i - 1] : 0;
				else {
					while (j < specialPos.size() && pos.get(i).intValue() > specialPos.get(j).intValue())
						++j;

					if (j < specialPos.size() && specialPos.get(j).intValue() == pos.get(i).intValue())
						count[i] = 1 + (i > 0 ? count[i - 1] : 0);
					else
						count[i] = i > 0 ? count[i - 1] : 0;
				}

				++i;
			}

			i = 0;
			j = 0;

			while (pos.size() > 0 && j < specialPos.size() && specialPos.get(j).intValue() < pos.get(0).intValue()) {
				++j;
			}

			int idx = 0;
			int jdx = 0;
			int right = pos.size() > 0 ? count[pos.size() - 1] : 0;

			while (i < pos.size() && j < specialPos.size()) {
				int first = specialPos.get(j).intValue();

				while (idx < pos.size() && idx + first >= pos.get(idx).intValue())
					++idx;

				--idx;

				while (jdx < specialPos.size() && specialPos.get(jdx).intValue() <= idx + first)
					++jdx;

				--jdx;

				right = Math.max(right, jdx - j + 1 + count[pos.size() - 1] - count[idx]);
				++j;
			}

			for (i = 0; i < neg.size(); ++i)
				neg.set(i, -neg.get(i));

			for (i = 0; i < specialNeg.size(); ++i)
				specialNeg.set(i, -specialNeg.get(i));

			Collections.reverse(neg);
			Collections.reverse(specialNeg);

			count = new int[neg.size()];
			i = 0;
			j = 0;

			while (i < neg.size()) {
				if (j >= specialNeg.size())
					count[i] = i > 0 ? count[i - 1] : 0;
				else {
					while (j < specialNeg.size() && neg.get(i).intValue() > specialNeg.get(j).intValue())
						++j;

					if (j < specialNeg.size() && specialNeg.get(j).intValue() == neg.get(i).intValue())
						count[i] = 1 + (i > 0 ? count[i - 1] : 0);
					else
						count[i] = i > 0 ? count[i - 1] : 0;
				}

				++i;
			}

			i = 0;
			j = 0;

			while (neg.size() > 0 && j < specialNeg.size() && specialNeg.get(j).intValue() < neg.get(0).intValue()) {
				++j;
			}

			idx = 0;
			jdx = 0;
			long left = neg.size() > 0 ? count[neg.size() - 1] : 0;

			while (i < neg.size() && j < specialNeg.size()) {
				int first = specialNeg.get(j).intValue();

				while (idx < neg.size() && idx + first >= neg.get(idx).intValue())
					++idx;

				--idx;

				while (jdx < specialNeg.size() && specialNeg.get(jdx).intValue() <= idx + first)
					++jdx;

				--jdx;

				left = Math.max(left, jdx - j + 1 + count[neg.size() - 1] - count[idx]);
				++j;
			}

			o.println(left + right);
		}

		o.flush();
		o.close();
	}
}
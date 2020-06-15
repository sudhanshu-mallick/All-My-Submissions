import java.util.*;
import java.io.*;

public class Colored_Boots {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		char l[] = t.next().toCharArray();
		char r[] = t.next().toCharArray();
		ArrayList<Integer> cl[] = new ArrayList[26];
		ArrayList<Integer> cr[] = new ArrayList[26];
		ArrayList<Integer> q1 = new ArrayList<>();
		ArrayList<Integer> q2 = new ArrayList<>();
		ArrayList<String> ans = new ArrayList<>();

		for (int i = 0; i < 26; i++) {
			cl[i] = new ArrayList<>();
			cr[i] = new ArrayList<>();

		}

		for (int i = 0; i < n; i++) {
			if (l[i] == '?') {
				q1.add(i + 1);
			} else {
				cl[l[i] - 'a'].add((int) (i + 1));
			}

			if (r[i] == '?') {
				q2.add(i + 1);
			} else {
				cr[r[i] - 'a'].add(i + 1);
			}
		}

		int q1ind = 0;
		int q2ind = 0;

		for (int i = 0; i < 26; i++) {
			int ind1 = 0;
			int ind2 = 0;
			while (ind1 < cl[i].size() && ind2 < cr[i].size()) {
				ans.add(cl[i].get(ind1) + " " + cr[i].get(ind2));

				ind1++;
				ind2++;
			}

			while (ind1 < cl[i].size() && q2ind < q2.size()) {
				ans.add(cl[i].get(ind1) + " " + q2.get(q2ind));

				ind1++;
				q2ind++;

			}

			while (ind2 < cr[i].size() && q1ind < q1.size()) {
				ans.add(q1.get(q1ind) + " " + cr[i].get(ind2));

				ind2++;
				q1ind++;
			}
		}

		while (q1ind < q1.size() && q2ind < q2.size()) {
			ans.add(q1.get(q1ind) + " " + q2.get(q2ind));

			q1ind++;
			q2ind++;
		}
		o.println(ans.size());

		for (int i = 0; i < ans.size(); ++i) {
			o.print(ans.get(i) + "\n");
		}

		o.close();
	}
}
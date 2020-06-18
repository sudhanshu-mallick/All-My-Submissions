import java.util.*;
import java.io.*;

public class Yuhao_And_A_Parenthesis {

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
		int[] count = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String s = t.next();
			int left = 0;
			int right = 0;

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(') {
					left++;
				} else {
					if (left > 0) {
						left--;
					} else {
						right--;
					}
				}
			}

			if (left != 0 && right != 0) {
				count[i] = 500000;
			} else {
				if (left == 0) {
					count[i] = right;
				} else {
					count[i] = left;
				}
			}

			if (count[i] != 500000 && map.containsKey(count[i])) {
				map.put(count[i], map.get(count[i]) + 1);
			} else {
				if (count[i] == 500000) {
					continue;
				}

				map.put(count[i], 1);
			}
		}

		int ans = 0;

		for (int i = 0; i < n; i++) {
			if (count[i] != 0 && count[i] != 500000 && map.containsKey(0 - count[i]) && map.containsKey(count[i])) {
				ans += Math.min(map.get(count[i]), map.get(0 - count[i]));

				map.remove(count[i]);
				map.remove(0 - count[i]);
			}
		}

		if (map.containsKey(0)) {
			ans += (map.get(0) >> 1);
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}
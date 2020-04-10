import java.util.*;
import java.io.*;

public class Yet_Another_Walking_Robot {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt(), r = 0, c = 0, ans = n + 1, end = -1;
			String s = t.next();
			char[] ch = s.toCharArray();
			HashMap<String, Integer> map = new HashMap<>();
			HashMap<Character, int[]> move = new HashMap<>();

			move.put('L', new int[] { 0, -1 });
			move.put('R', new int[] { 0, 1 });
			move.put('U', new int[] { -1, 0 });
			move.put('D', new int[] { 1, 0 });
			map.put("0_0", 0);

			for (int i = 1; i <= n; i++) {
				int[] path = move.get(ch[i - 1]);
				r += path[0];
				c += path[1];
				String key = r + "_" + c;

				if (map.containsKey(key)) {
					if (ans > i - map.get(key)) {
						ans = i - map.get(key);
						end = i;
					}
				}

				map.put(key, i);
			}
			System.out.println(end == -1 ? end : (end - ans + 1) + " " + end);
		}

		o.flush();
		o.close();
	}
}
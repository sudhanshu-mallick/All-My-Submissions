import java.util.*;
import java.io.*;

public class Full_Turn {

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
			int n = t.nextInt();
			Map<String, Long> map = new HashMap<>();
			long ans = 0;

			while (n-- > 0) {
				long x0 = t.nextLong();
				long y0 = t.nextLong();
				long x1 = t.nextLong();
				long y1 = t.nextLong();

				if (x0 != x1) {
					long x = x1 - x0;
					long y = y1 - y0;
					long gcd = gcd(Math.abs(x), Math.abs(y));
					x /= gcd;
					y /= gcd;
					String s = Math.abs(x) + "," + Math.abs(y);

					if (x > 0) {
						if (y > 0)
							s = "+pp," + s;
						else if (y < 0)
							s = "-pn," + s;
						else {
							s = "+tt," + s;
						}
					} else {
						if (y > 0)
							s = "-np," + s;
						else if (y < 0)
							s = "+nn," + s;
						else
							s = "-tt," + s;
					}

					map.put(s, map.getOrDefault(s, 0l) + 1);
				} else {
					if (y1 > y0) {
						map.put("INF", map.getOrDefault("INF", 0l) + 1);
					} else {
						map.put("-INF", map.getOrDefault("-INF", 0l) + 1);
					}
				}
			}

			for (Map.Entry<String, Long> m : map.entrySet()) {
				long v1 = m.getValue();
				long v2 = 0;
				String s = m.getKey();

				if (s.equals("INF") || s.equals("-INF")) {
					if (s.charAt(0) == '-')
						v2 = map.getOrDefault("INF", 0l);
					else
						v2 = map.getOrDefault("-INF", 0l);

					ans += v1 * v2;
				} else {
					String q = s.substring(1, 3);
					String req = "";

					if (q.equals("pp"))
						req = "nn";
					else if (q.equals("nn"))
						req = "pp";
					else if (q.equals("np"))
						req = "pn";
					else if (q.equals("pn"))
						req = "np";
					else
						req = "tt";

					if (!req.equals("tt")) {
						if (s.charAt(0) == '-')
							req = "-" + req + s.substring(3);
						else
							req = "+" + req + s.substring(3);
					} else {
						if (s.charAt(0) == '-')
							req = "+" + req + s.substring(3);
						else
							req = "-" + req + s.substring(3);
					}

					v2 = map.getOrDefault(req, 0l);

					ans += v1 * v2;
				}
			}

			ans = ans >> 1;

			o.println(ans);
		}

		o.flush();
		o.close();
	}

	private static long gcd(long a, long b) {
		if (a == 0)
			return b;

		return gcd(b % a, a);
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class Permutation_Partition {
 
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
		long a[] = new long[n];
		int k = t.nextInt();
		int k0 = n - k;
		long sum = 0;
		long p = 0, check = 0, ans = 1;
 
		for (int i = 0; i < n; i++)
			a[i] = t.nextLong();
 
		sum = (long) n * (n + 1) / 2 - (long) k0 * (k0 + 1) / 2;
 
		for (int i = 0; i < n; i++) {
			if (a[i] > n - k) {
				if (check == 0)
					check++;
				else {
					ans = ans * (p + 1) % 998244353;
					p = 0;
				}
			} else {
				if (check != 0)
					p++;
			}
		}
 
		ans = ans % 998244353;
 
		o.println(sum + " " + ans);
		o.flush();
		o.close();
 
	}
 
}
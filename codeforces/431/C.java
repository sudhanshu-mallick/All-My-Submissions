import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class K_Tree {

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
		int k = t.nextInt();
		int d = t.nextInt();
		BigInteger[] a1 = new BigInteger[n + 1];
		BigInteger[] b1 = new BigInteger[n + 1];
		int[] a = new int[n + 1];
		int[] b = new int[n + 1];
		a[n] = b[n] = 1;
		a1[n] = new BigInteger("1");
		b1[n] = new BigInteger("1");
		int d1 = d - 1;
		
		for (int i = n - 1; i >= 0; i--) {

			a1[i] = new BigInteger("0");
			
			for (int j = i + 1; j <= Math.min(d1 + i, n); j++) {
//				a[i] = (a[i] + a[j]);
//				
//				if(a[i]>=1000000007)
//					a[i]-=1000000007;
				
				a1[i]=a1[i].add(a1[j]);
				
				
			}
		}

		for (int i = n - 1; i >= 0; i--) {

			b1[i] = new BigInteger("0");

			for (int j = i + 1; j <= Math.min(k + i, n); j++) {
//				b[i] = (b[i] + b[j]);
//				
//				if(b[i]>=1000000007)
//					b[i]-=1000000007;

				b1[i]=b1[i].add(b1[j]);
			}
		}

		BigInteger ok = new BigInteger("1000000007");
		b1[0]=b1[0].subtract(a1[0]);
		b1[0]=b1[0].remainder(ok);
		
//		System.out.println(b1[0]);
//		System.out.println(a1[0]);

		long ans = (b[0] - a[0]) % 1000000007;

		o.println(b1[0]);
		o.flush();
		o.close();

	}

}

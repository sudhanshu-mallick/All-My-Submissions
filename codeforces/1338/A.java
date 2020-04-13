import java.util.*;
import java.io.*;
 
public class Nitin {
 
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
			long[] a = new long[n];
			long cost[] = new long[n];
 
			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();
			
 
			long max = a[0];
			cost[0] = 0;
 
			for (int i = 1; i < n; ++i) {
				if (max < a[i]) {
					max = a[i];
				}
 
				cost[i] = Math.max(cost[i - 1], max - a[i]);
			}
			
//			for(int i=0;i<n;++i)
//				System.out.print(cost[i]+" ");
//			
//			System.out.println();
 
			if (cost[n - 1] > 0) {
				o.println((long) (Math.log(cost[n - 1] * 2) / Math.log(2)));
			} else
				o.println(0);
 
		}
 
		o.flush();
		o.close();
	}
}
import java.util.*;
import java.io.*;

public class I_Wanna_BE_The_Guy {
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
		Set<Integer> set = new HashSet<>();
		int a = t.nextInt();
			
		while(a-- > 0)
		    set.add(t.nextInt());
			    
		a = t.nextInt();
			
		while(a-- > 0)
		    set.add(t.nextInt());
			    
		if(set.size() == n)
		    o.println("I become the guy.");
		else
		    o.println("Oh, my keyboard!");

	o.flush();
	o.close();
    }
}
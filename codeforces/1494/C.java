import java.util.*;
import java.io.*;

public class C1494 {

	public static int solve(ArrayList<Integer> box, ArrayList<Integer> special) {
		int i = 0;
		int j = 0;
		int ans = 0;
		while (i < box.size() && j < special.size()) {
			if (box.get(i).equals(special.get(j))) {
				ans++;
				i++;
				j++;
			} else if (box.get(i) < special.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		int max = ans;
		i = 0;
		for (j = 0; j < special.size(); j++) {
			while (i < box.size() && box.get(i) <= special.get(j)) {
				if (box.get(i).equals(special.get(j)))
					ans--;
				i++;
			}
			int bs = Collections.binarySearch(special, special.get(j) - i + 1);
			if (bs < 0) {
				bs = -bs - 1;
			}
			max = Math.max(max, ans + j - bs + 1);
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			Stack<Integer> negBox = new Stack<Integer>();
			Stack<Integer> negSpec = new Stack<Integer>();
			ArrayList<Integer> posBox = new ArrayList<Integer>();
			ArrayList<Integer> posSpec = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				if (x > 0) {
					posBox.add(x);
				} else {
					negBox.add(-x);
				}
			}
			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				if (x > 0) {
					posSpec.add(x);
				} else {
					negSpec.add(-x);
				}
			}
			ArrayList<Integer> negBoxal = new ArrayList<Integer>();
			while (!negBox.isEmpty()) {
				negBoxal.add(negBox.pop());
			}
			ArrayList<Integer> negSpecal = new ArrayList<Integer>();
			while (!negSpec.isEmpty()) {
				negSpecal.add(negSpec.pop());
			}
			pw.println(solve(posBox, posSpec) + solve(negBoxal, negSpecal));
		}
		pw.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(next());
			}
			return arr;
		}

	}

}

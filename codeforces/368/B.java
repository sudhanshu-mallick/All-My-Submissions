import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sereja_And_Suffixes {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader t = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(t.readLine());
		int n = Integer.parseInt(s.nextToken());
		HashSet<Integer> set = new HashSet<>();
		int[] a = new int[n];
		int m = Integer.parseInt(s.nextToken());
		s = new StringTokenizer(t.readLine());
		int distinct[] = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(s.nextToken());

		for (int i = n - 1; i >= 0; i--) {

			if (!set.contains(a[i]))
				set.add(a[i]);

			distinct[i] = set.size();
		}

		for (int i = 0; i < m; i++) {
			int k = Integer.parseInt(t.readLine());

			System.out.println(distinct[k - 1]);
		}
	}
}

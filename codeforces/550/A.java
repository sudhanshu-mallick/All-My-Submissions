import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Two_Substrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter writ = new PrintWriter(out);
		StringBuilder s = new StringBuilder(t.next());
		int n = s.length();
		int[] ab = new int[n];

		for (int i = 0; i < n - 1; i++) {
			if (s.substring(i, i + 2).equals("AB")) {
				if (i == 0)
					ab[i] = 1;
				else
					ab[i] = ab[i - 1] + 1;
			} else if (i > 0)
				ab[i] = ab[i - 1];
		}

		if (n > 1)
			ab[n - 1] = ab[n - 2];

		for (int i = 0; i < n - 1; i++) {
			if (s.substring(i, i + 2).equals("BA")) {
				if (i > 1 && i < n - 1 && (ab[i - 2] > 0 || ab[n - 1] - ab[i + 1] > 0)) {
					System.out.println("YES");
					return;
				} else if (i > 1 && ab[i - 2] > 0) {
					System.out.println("YES");
					return;
				} else if (i < n - 1 && ab[n - 1] - ab[i + 1] > 0) {
					System.out.println("YES");
					return;
				}
			}
		}

		System.out.println("NO");
	}

}

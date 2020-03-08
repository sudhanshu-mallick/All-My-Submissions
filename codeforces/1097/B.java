import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Petr_And_A_Combination_Of_Lock {

	static boolean ans = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter writ = new PrintWriter(out);

		int n = t.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		comb(0, n, a, 0);

		if (ans)
			writ.println("YES");
		else
			writ.println("NO");

		writ.close();
	}

	public static void comb(int idx, int n, int[] a, int sum) {
		if (idx >= n) {
			if (sum % 360 == 0)
				ans = true;

			return;
		}

		if (ans)
			return;

		comb(idx + 1, n, a, sum + a[idx]);
		comb(idx + 1, n, a, sum - a[idx]);
	}

}
